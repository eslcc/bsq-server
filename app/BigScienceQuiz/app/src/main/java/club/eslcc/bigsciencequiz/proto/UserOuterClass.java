// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package club.eslcc.bigsciencequiz.proto;

public final class UserOuterClass {
  private UserOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface UserOrBuilder extends
      // @@protoc_insertion_point(interface_extends:bigsciencequiz.User)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 id = 1;</code>
     */
    int getId();

    /**
     * <code>repeated string memberNames = 2;</code>
     */
    java.util.List<java.lang.String>
        getMemberNamesList();
    /**
     * <code>repeated string memberNames = 2;</code>
     */
    int getMemberNamesCount();
    /**
     * <code>repeated string memberNames = 2;</code>
     */
    java.lang.String getMemberNames(int index);
    /**
     * <code>repeated string memberNames = 2;</code>
     */
    com.google.protobuf.ByteString
        getMemberNamesBytes(int index);

    /**
     * <code>string teamName = 3;</code>
     */
    java.lang.String getTeamName();
    /**
     * <code>string teamName = 3;</code>
     */
    com.google.protobuf.ByteString
        getTeamNameBytes();

    /**
     * <code>int32 score = 4;</code>
     */
    int getScore();
  }
  /**
   * Protobuf type {@code bigsciencequiz.User}
   */
  public  static final class User extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:bigsciencequiz.User)
      UserOrBuilder {
    // Use User.newBuilder() to construct.
    private User(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private User() {
      id_ = 0;
      memberNames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      teamName_ = "";
      score_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private User(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              id_ = input.readInt32();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                memberNames_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000002;
              }
              memberNames_.add(s);
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              teamName_ = s;
              break;
            }
            case 32: {

              score_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          memberNames_ = memberNames_.getUnmodifiableView();
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return club.eslcc.bigsciencequiz.proto.UserOuterClass.internal_static_bigsciencequiz_User_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return club.eslcc.bigsciencequiz.proto.UserOuterClass.internal_static_bigsciencequiz_User_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              club.eslcc.bigsciencequiz.proto.UserOuterClass.User.class, club.eslcc.bigsciencequiz.proto.UserOuterClass.User.Builder.class);
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    public static final int MEMBERNAMES_FIELD_NUMBER = 2;
    private com.google.protobuf.LazyStringList memberNames_;
    /**
     * <code>repeated string memberNames = 2;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getMemberNamesList() {
      return memberNames_;
    }
    /**
     * <code>repeated string memberNames = 2;</code>
     */
    public int getMemberNamesCount() {
      return memberNames_.size();
    }
    /**
     * <code>repeated string memberNames = 2;</code>
     */
    public java.lang.String getMemberNames(int index) {
      return memberNames_.get(index);
    }
    /**
     * <code>repeated string memberNames = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMemberNamesBytes(int index) {
      return memberNames_.getByteString(index);
    }

    public static final int TEAMNAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object teamName_;
    /**
     * <code>string teamName = 3;</code>
     */
    public java.lang.String getTeamName() {
      java.lang.Object ref = teamName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        teamName_ = s;
        return s;
      }
    }
    /**
     * <code>string teamName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTeamNameBytes() {
      java.lang.Object ref = teamName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        teamName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SCORE_FIELD_NUMBER = 4;
    private int score_;
    /**
     * <code>int32 score = 4;</code>
     */
    public int getScore() {
      return score_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (id_ != 0) {
        output.writeInt32(1, id_);
      }
      for (int i = 0; i < memberNames_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, memberNames_.getRaw(i));
      }
      if (!getTeamNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, teamName_);
      }
      if (score_ != 0) {
        output.writeInt32(4, score_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < memberNames_.size(); i++) {
          dataSize += computeStringSizeNoTag(memberNames_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getMemberNamesList().size();
      }
      if (!getTeamNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, teamName_);
      }
      if (score_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, score_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof club.eslcc.bigsciencequiz.proto.UserOuterClass.User)) {
        return super.equals(obj);
      }
      club.eslcc.bigsciencequiz.proto.UserOuterClass.User other = (club.eslcc.bigsciencequiz.proto.UserOuterClass.User) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && getMemberNamesList()
          .equals(other.getMemberNamesList());
      result = result && getTeamName()
          .equals(other.getTeamName());
      result = result && (getScore()
          == other.getScore());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      if (getMemberNamesCount() > 0) {
        hash = (37 * hash) + MEMBERNAMES_FIELD_NUMBER;
        hash = (53 * hash) + getMemberNamesList().hashCode();
      }
      hash = (37 * hash) + TEAMNAME_FIELD_NUMBER;
      hash = (53 * hash) + getTeamName().hashCode();
      hash = (37 * hash) + SCORE_FIELD_NUMBER;
      hash = (53 * hash) + getScore();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(club.eslcc.bigsciencequiz.proto.UserOuterClass.User prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code bigsciencequiz.User}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:bigsciencequiz.User)
        club.eslcc.bigsciencequiz.proto.UserOuterClass.UserOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return club.eslcc.bigsciencequiz.proto.UserOuterClass.internal_static_bigsciencequiz_User_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return club.eslcc.bigsciencequiz.proto.UserOuterClass.internal_static_bigsciencequiz_User_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                club.eslcc.bigsciencequiz.proto.UserOuterClass.User.class, club.eslcc.bigsciencequiz.proto.UserOuterClass.User.Builder.class);
      }

      // Construct using club.eslcc.bigsciencequiz.proto.UserOuterClass.User.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        id_ = 0;

        memberNames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        teamName_ = "";

        score_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return club.eslcc.bigsciencequiz.proto.UserOuterClass.internal_static_bigsciencequiz_User_descriptor;
      }

      public club.eslcc.bigsciencequiz.proto.UserOuterClass.User getDefaultInstanceForType() {
        return club.eslcc.bigsciencequiz.proto.UserOuterClass.User.getDefaultInstance();
      }

      public club.eslcc.bigsciencequiz.proto.UserOuterClass.User build() {
        club.eslcc.bigsciencequiz.proto.UserOuterClass.User result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public club.eslcc.bigsciencequiz.proto.UserOuterClass.User buildPartial() {
        club.eslcc.bigsciencequiz.proto.UserOuterClass.User result = new club.eslcc.bigsciencequiz.proto.UserOuterClass.User(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.id_ = id_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          memberNames_ = memberNames_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.memberNames_ = memberNames_;
        result.teamName_ = teamName_;
        result.score_ = score_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof club.eslcc.bigsciencequiz.proto.UserOuterClass.User) {
          return mergeFrom((club.eslcc.bigsciencequiz.proto.UserOuterClass.User)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(club.eslcc.bigsciencequiz.proto.UserOuterClass.User other) {
        if (other == club.eslcc.bigsciencequiz.proto.UserOuterClass.User.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (!other.memberNames_.isEmpty()) {
          if (memberNames_.isEmpty()) {
            memberNames_ = other.memberNames_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureMemberNamesIsMutable();
            memberNames_.addAll(other.memberNames_);
          }
          onChanged();
        }
        if (!other.getTeamName().isEmpty()) {
          teamName_ = other.teamName_;
          onChanged();
        }
        if (other.getScore() != 0) {
          setScore(other.getScore());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        club.eslcc.bigsciencequiz.proto.UserOuterClass.User parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (club.eslcc.bigsciencequiz.proto.UserOuterClass.User) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int id_ ;
      /**
       * <code>int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder setId(int value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList memberNames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureMemberNamesIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          memberNames_ = new com.google.protobuf.LazyStringArrayList(memberNames_);
          bitField0_ |= 0x00000002;
         }
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public com.google.protobuf.ProtocolStringList
          getMemberNamesList() {
        return memberNames_.getUnmodifiableView();
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public int getMemberNamesCount() {
        return memberNames_.size();
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public java.lang.String getMemberNames(int index) {
        return memberNames_.get(index);
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public com.google.protobuf.ByteString
          getMemberNamesBytes(int index) {
        return memberNames_.getByteString(index);
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public Builder setMemberNames(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureMemberNamesIsMutable();
        memberNames_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public Builder addMemberNames(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureMemberNamesIsMutable();
        memberNames_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public Builder addAllMemberNames(
          java.lang.Iterable<java.lang.String> values) {
        ensureMemberNamesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, memberNames_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public Builder clearMemberNames() {
        memberNames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string memberNames = 2;</code>
       */
      public Builder addMemberNamesBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensureMemberNamesIsMutable();
        memberNames_.add(value);
        onChanged();
        return this;
      }

      private java.lang.Object teamName_ = "";
      /**
       * <code>string teamName = 3;</code>
       */
      public java.lang.String getTeamName() {
        java.lang.Object ref = teamName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          teamName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string teamName = 3;</code>
       */
      public com.google.protobuf.ByteString
          getTeamNameBytes() {
        java.lang.Object ref = teamName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          teamName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string teamName = 3;</code>
       */
      public Builder setTeamName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        teamName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string teamName = 3;</code>
       */
      public Builder clearTeamName() {
        
        teamName_ = getDefaultInstance().getTeamName();
        onChanged();
        return this;
      }
      /**
       * <code>string teamName = 3;</code>
       */
      public Builder setTeamNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        teamName_ = value;
        onChanged();
        return this;
      }

      private int score_ ;
      /**
       * <code>int32 score = 4;</code>
       */
      public int getScore() {
        return score_;
      }
      /**
       * <code>int32 score = 4;</code>
       */
      public Builder setScore(int value) {
        
        score_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 score = 4;</code>
       */
      public Builder clearScore() {
        
        score_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:bigsciencequiz.User)
    }

    // @@protoc_insertion_point(class_scope:bigsciencequiz.User)
    private static final club.eslcc.bigsciencequiz.proto.UserOuterClass.User DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new club.eslcc.bigsciencequiz.proto.UserOuterClass.User();
    }

    public static club.eslcc.bigsciencequiz.proto.UserOuterClass.User getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<User>
        PARSER = new com.google.protobuf.AbstractParser<User>() {
      public User parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new User(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<User> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<User> getParserForType() {
      return PARSER;
    }

    public club.eslcc.bigsciencequiz.proto.UserOuterClass.User getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bigsciencequiz_User_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bigsciencequiz_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nuser.proto\022\016bigsciencequiz\"H\n\004User\022\n\n\002" +
      "id\030\001 \001(\005\022\023\n\013memberNames\030\002 \003(\t\022\020\n\010teamNam" +
      "e\030\003 \001(\t\022\r\n\005score\030\004 \001(\005B!\n\037club.eslcc.big" +
      "sciencequiz.protob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_bigsciencequiz_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_bigsciencequiz_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bigsciencequiz_User_descriptor,
        new java.lang.String[] { "Id", "MemberNames", "TeamName", "Score", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
