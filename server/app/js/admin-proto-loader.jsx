class ProtoLoader {
    static TYPES = {
        RpcRequest: 'bigsciencequiz.RpcRequest',
        RpcResponse: 'bigsciencequiz.RpcResponse',
        IdentifyUserRequest: 'bigsciencequiz.IdentifyUserRequest',
        AutocompleteMemberNameRequest: 'bigsciencequiz.AutocompleteMemberNameRequest',
        AutocompleteMemberNameResponse: 'bigsciencequiz.AutocompleteMemberNameResponse',
        AdminGetQuestionsRequest: 'bigsciencequiz.admin.AdminGetQuestionsRequest',
        AdminSetActiveQuestionRequest: 'bigsciencequiz.admin.AdminSetActiveQuestionRequest',
    };

    static PROTOS = [
        "/proto/models/rpc.proto",
        "/proto/models/admin_rpc.proto"
    ];

    static ROOT = new protobuf.Root();

    static load() {
        const promises = ProtoLoader.PROTOS.map(
            path => protobuf.load(path, ProtoLoader.ROOT)
        );

        return Promise.all(promises).then(protos => {
            Object.keys(ProtoLoader.TYPES).forEach(name => {
                window[name] = ProtoLoader.ROOT.lookup(ProtoLoader.TYPES[name]);
            });
        });
    }
}
