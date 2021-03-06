package club.eslcc.bigsciencequiz.server;

import club.eslcc.bigsciencequiz.proto.Events;
import club.eslcc.bigsciencequiz.proto.Gamestate;
import club.eslcc.bigsciencequiz.proto.QuestionOuterClass;
import club.eslcc.bigsciencequiz.proto.admin.AdminEvents;
import com.google.protobuf.InvalidProtocolBufferException;
import org.eclipse.jetty.websocket.api.Session;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.stream.Collectors;

import static club.eslcc.bigsciencequiz.server.RpcHelpers.stob;
import static club.eslcc.bigsciencequiz.server.RpcHelpers.stoi;
import static club.eslcc.bigsciencequiz.server.SocketHandler.logLock;


/**
 * Created by marks on 18/03/2017.
 */
public class RpcPubSub extends JedisPubSub {

    private void sendEvent(Events.GameEvent event) {
        byte[] data = EventHelpers.addEventFlag(event.toByteArray());
        SocketHandler.users.keySet().stream()
                .filter(s -> SocketHandler.users.get(s) != null)
                .filter(Session::isOpen)
                .forEach(session -> {
                            session.getRemote().sendBytesByFuture(ByteBuffer.wrap(data));
                        }
                );
        synchronized (logLock) {
            System.out.println("Sent event: " + event.getEventCase());
            System.out.println("Content: " + event);
            System.out.println("Binary: " + Arrays.toString(data));
        }
    }

    private void sendAdminEvent(Events.GameEvent event) {
        byte[] data = EventHelpers.addEventFlag(event.toByteArray());
        SocketHandler.users.keySet().stream()
                .filter(s -> SocketHandler.users.get(s) != null)
                .filter(s -> SocketHandler.users.get(s).equals("ADMIN"))
                .filter(Session::isOpen)
                .forEach(session -> {
                            session.getRemote().sendBytesByFuture(ByteBuffer.wrap(data));
                        }
                );
        synchronized (logLock) {
            System.out.println("Sent ADMIN event: " + event.getEventCase());
            System.out.println("Content: " + event);
            System.out.println("Binary: " + Arrays.toString(data));
        }
    }

    private void sendBigscreenEvent(Events.GameEvent event) {
        byte[] data = EventHelpers.addEventFlag(event.toByteArray());
        SocketHandler.users.keySet().stream()
                .filter(s -> SocketHandler.users.get(s) != null)
                .filter(s -> SocketHandler.users.get(s).equals("BIGSCREEN"))
                .filter(Session::isOpen)
                .forEach(session -> {
                            session.getRemote().sendBytesByFuture(ByteBuffer.wrap(data));
                        }
                );
        synchronized (logLock) {
            System.out.println("Sent BIGSCREEN event: " + event.getEventCase());
            System.out.println("Content: " + event);
            System.out.println("Binary: " + Arrays.toString(data));
        }
    }

    private void handleGameStateChange() {
        final Gamestate.GameState state = RedisHelpers.getGameState();

        if (state.getState() == Gamestate.GameState.State.QUESTION_LIVEANSWERS) {
            handleLiveAnswers();
        }

        final boolean[] logged = {false}; // Java 8 is weird.
        SocketHandler.users.keySet().stream().filter(Session::isOpen).forEach(session -> {
            Events.GameEvent.Builder builder = Events.GameEvent.newBuilder();
            Events.GameStateChangeEvent.Builder gsceB = Events.GameStateChangeEvent.newBuilder();

            gsceB.setNewState(state);
            builder.setGameStateChangeEvent(gsceB);
            Events.GameEvent event = builder.build();
            byte[] data = EventHelpers.addEventFlag(event.toByteArray());
            session.getRemote().sendBytesByFuture(ByteBuffer.wrap(data));
            if (!logged[0]) {
                synchronized (logLock) {
                    System.out.println("Sent event: " + event.getEventCase());
                    System.out.println("Content: " + event);
                    System.out.println("Binary: " + Arrays.toString(data));
                }
                logged[0] = true;
            }

            if (state.getState() == Gamestate.GameState.State.QUESTION_ANSWERS_REVEALED) {
                handleRevealAnswers(session);
            }
        });
    }

    private void handleAdminDevices() {
        try (Jedis jedis = Redis.pool.getResource()) {
            Map<String, String> deviceTeams = jedis.hgetAll("devices");
            Set<String> readyDevices = jedis.smembers("ready_devices");

            List<AdminEvents.AdminDevicesChangedEvent.Device> result = deviceTeams.keySet().stream().map(
                    id -> AdminEvents.AdminDevicesChangedEvent.Device.newBuilder()
                            .setDeviceId(id)
                            .setReady(readyDevices.contains(id))
                            .setTeam(stoi(deviceTeams.get(id)))
                            .setDisconnected(jedis.sismember("disconnected_devices", id))
                            .build()
            ).collect(Collectors.toList());

            Events.GameEvent.Builder wrapped = Events.GameEvent.newBuilder();
            AdminEvents.AdminDevicesChangedEvent.Builder builder = AdminEvents.AdminDevicesChangedEvent.newBuilder();
            builder.addAllDevices(result);
            wrapped.setAdminDevicesChangedEvent(builder);
            Events.GameEvent event = wrapped.build();
            sendAdminEvent(event);
        }
    }

    private void handleNoFreeTeams(String[] args) {
        Events.GameEvent.Builder wrapped = Events.GameEvent.newBuilder();
        Events.ErrorEvent.Builder builder = Events.ErrorEvent.newBuilder();
        builder.setDescription("No free teams for device " + args[0]);
        wrapped.setErrorEvent(builder);
        Events.GameEvent event = wrapped.build();
        sendAdminEvent(event);
    }

    private void handleQuestionsChange() {
        try (Jedis jedis = Redis.pool.getResource()) {
            Map<byte[], byte[]> questions = jedis.hgetAll(stob("questions"));

            List<QuestionOuterClass.Question> questionProtos = questions.values().stream().map(bytes -> {
                try {
                    return QuestionOuterClass.Question.parseFrom(bytes);
                } catch (InvalidProtocolBufferException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());

            Events.GameEvent.Builder wrapped = Events.GameEvent.newBuilder();
            AdminEvents.AdminQuestionsChangedEvent.Builder builder = AdminEvents.AdminQuestionsChangedEvent.newBuilder();
            builder.addAllNewQuestions(questionProtos);
            wrapped.setAdminQuestionsChangedEvent(builder);
            Events.GameEvent event = wrapped.build();
            sendAdminEvent(event);
        }
    }

    private void handleLiveAnswers() {
        try (Jedis jedis = Redis.pool.getResource()) {
            List<String> answers = jedis.hvals("answers");
            Map<Integer, Integer> answerCounts = new HashMap<>(answers.size());

            for (String answer : answers) {
                answerCounts.put(stoi(answer), jedis.zscore("answer_counts", answer).intValue());
            }

            Events.GameEvent.Builder wrapped = Events.GameEvent.newBuilder();
            Events.LiveAnswersEvent.Builder builder = Events.LiveAnswersEvent.newBuilder();
            builder.putAllAnswers(answerCounts);
            wrapped.setLiveAnswersEvent(builder);
            Events.GameEvent event = wrapped.build();
            sendAdminEvent(event);
            sendBigscreenEvent(event);
        }
    }

    private void handleRevealAnswers(Session session) {
        Events.GameEvent.Builder builder = Events.GameEvent.newBuilder();
        Events.RevealAnswersEvent.Builder raeb = Events.RevealAnswersEvent.newBuilder();

        QuestionOuterClass.Question question = null;
        int userAnswer = -1;
        int correctAnswer = -1;

        try (Jedis jedis = Redis.pool.getResource()) {
            byte[] currentQuestion = jedis.hget(stob("state"), stob("currentQuestion"));

            question = QuestionOuterClass.Question.parseFrom(currentQuestion);

            String userId = SocketHandler.users.get(session);

            if (userId != null && (!userId.equals("ADMIN")) && (!userId.equals("BIGSCREEN"))) {
                String teamId = jedis.hget("devices", userId);
                String answer = jedis.hget("answers", teamId);

                if (answer != null)
                    userAnswer = Integer.parseInt(answer);
            }

            Optional<QuestionOuterClass.Question.Answer> streamAnswer =
                    question.getAnswersList().stream().filter(QuestionOuterClass.Question.Answer::getCorrect).findFirst();
            if (streamAnswer.isPresent())
                correctAnswer = streamAnswer.get().getId();

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        if (question != null)
            raeb.setCurrentQuestion(question);

        if (userAnswer != -1)
            raeb.setUserAnswer(userAnswer);

        if (correctAnswer != -1)
            raeb.setCorrectAnswer(correctAnswer);

        builder.setRevealAnswersEvent(raeb);
        Events.GameEvent event = builder.build();
        byte[] data = EventHelpers.addEventFlag(event.toByteArray());
        session.getRemote().sendBytesByFuture(ByteBuffer.wrap(data));
    }

    @Override
    public void onMessage(String channel, String message) {
        switch (channel) {
            case "device_shutdown":
                handleShutdown(message);
                break;
            case "game_events":
                switch (message) {
                    case "game_state_change":
                        handleGameStateChange();
                        break;
                    case "live_answers":
                        handleLiveAnswers();
                }
                break;
            case "bigscreen_events":
                switch(message) {
                    case "show_liveanswers":
                        handleLiveAnswers();
                        break;
                }
            case "admin_events":
                switch (message) {
                    case "identified_device_change":
                    case "ready_device_change":
                        handleAdminDevices();
                        break;
                    case "questions_change":
                        handleQuestionsChange();
                        break;
                    default:
                        if (message.startsWith("no_free_teams")) {
                            String[] args = message.substring("no_free_teams:".length()).split(":");
                            handleNoFreeTeams(args);
                        } else {
                            System.out.println("WHAT: " + message);
                        }
                }
        }
    }

    private void handleShutdown(String deviceId) {
        Events.GameEvent.Builder wrapped = Events.GameEvent.newBuilder();
        Events.RemoteShutdownEvent.Builder builder = Events.RemoteShutdownEvent.newBuilder();
        wrapped.setRemoteShutdownEvent(builder);
        Events.GameEvent event = wrapped.build();
        byte[] data = EventHelpers.addEventFlag(event.toByteArray());
        Session session = RpcHelpers.getKeyByValue(SocketHandler.users, deviceId);
        try {
            if (session != null) {
                session.getRemote().sendBytes(ByteBuffer.wrap(data));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
