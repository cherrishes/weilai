// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/PackAuth.proto

package com.ebanswers.starfreezer.proto;

public final class PackAuth {
  private PackAuth() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface AuthBodyOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.ebanswers.starfreezer.proto.AuthBody)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string token = 1;</code>
     *
     * <pre>
     **
     * 客户端：请求时认证token
     * </pre>
     */
    boolean hasToken();
    /**
     * <code>optional string token = 1;</code>
     *
     * <pre>
     **
     * 客户端：请求时认证token
     * </pre>
     */
    java.lang.String getToken();
    /**
     * <code>optional string token = 1;</code>
     *
     * <pre>
     **
     * 客户端：请求时认证token
     * </pre>
     */
    com.google.protobuf.ByteString
        getTokenBytes();

    /**
     * <code>optional int32 requestCmd = 2;</code>
     *
     * <pre>
     **
     * 客户端请求命令
     * </pre>
     */
    boolean hasRequestCmd();
    /**
     * <code>optional int32 requestCmd = 2;</code>
     *
     * <pre>
     **
     * 客户端请求命令
     * </pre>
     */
    int getRequestCmd();

    /**
     * <code>optional int32 responseCmd = 3;</code>
     *
     * <pre>
     **
     * 服务端响应命令，不一定每次都有
     * </pre>
     */
    boolean hasResponseCmd();
    /**
     * <code>optional int32 responseCmd = 3;</code>
     *
     * <pre>
     **
     * 服务端响应命令，不一定每次都有
     * </pre>
     */
    int getResponseCmd();

    /**
     * <code>optional bool isSucceed = 4;</code>
     *
     * <pre>
     **
     * 服务端：是否成功执行
     * </pre>
     */
    boolean hasIsSucceed();
    /**
     * <code>optional bool isSucceed = 4;</code>
     *
     * <pre>
     **
     * 服务端：是否成功执行
     * </pre>
     */
    boolean getIsSucceed();

    /**
     * <code>optional string pbKey = 5;</code>
     *
     * <pre>
     **
     * pb密钥，rc4 key
     * </pre>
     */
    boolean hasPbKey();
    /**
     * <code>optional string pbKey = 5;</code>
     *
     * <pre>
     **
     * pb密钥，rc4 key
     * </pre>
     */
    java.lang.String getPbKey();
    /**
     * <code>optional string pbKey = 5;</code>
     *
     * <pre>
     **
     * pb密钥，rc4 key
     * </pre>
     */
    com.google.protobuf.ByteString
        getPbKeyBytes();

    /**
     * <code>optional string pbBody = 6;</code>
     *
     * <pre>
     **
     * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
     * </pre>
     */
    boolean hasPbBody();
    /**
     * <code>optional string pbBody = 6;</code>
     *
     * <pre>
     **
     * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
     * </pre>
     */
    java.lang.String getPbBody();
    /**
     * <code>optional string pbBody = 6;</code>
     *
     * <pre>
     **
     * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
     * </pre>
     */
    com.google.protobuf.ByteString
        getPbBodyBytes();
  }
  /**
   * Protobuf type {@code com.ebanswers.starfreezer.proto.AuthBody}
   */
  public static final class AuthBody extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.ebanswers.starfreezer.proto.AuthBody)
      AuthBodyOrBuilder {
    // Use AuthBody.newBuilder() to construct.
    private AuthBody(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private AuthBody(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final AuthBody defaultInstance;
    public static AuthBody getDefaultInstance() {
      return defaultInstance;
    }

    public AuthBody getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private AuthBody(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              token_ = bs;
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              requestCmd_ = input.readInt32();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              responseCmd_ = input.readInt32();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              isSucceed_ = input.readBool();
              break;
            }
            case 42: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000010;
              pbKey_ = bs;
              break;
            }
            case 50: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000020;
              pbBody_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ebanswers.starfreezer.proto.PackAuth.internal_static_com_ebanswers_starfreezer_proto_AuthBody_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ebanswers.starfreezer.proto.PackAuth.internal_static_com_ebanswers_starfreezer_proto_AuthBody_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ebanswers.starfreezer.proto.PackAuth.AuthBody.class, com.ebanswers.starfreezer.proto.PackAuth.AuthBody.Builder.class);
    }

    public static com.google.protobuf.Parser<AuthBody> PARSER =
        new com.google.protobuf.AbstractParser<AuthBody>() {
      public AuthBody parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AuthBody(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<AuthBody> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private java.lang.Object token_;
    /**
     * <code>optional string token = 1;</code>
     *
     * <pre>
     **
     * 客户端：请求时认证token
     * </pre>
     */
    public boolean hasToken() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string token = 1;</code>
     *
     * <pre>
     **
     * 客户端：请求时认证token
     * </pre>
     */
    public java.lang.String getToken() {
      java.lang.Object ref = token_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          token_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string token = 1;</code>
     *
     * <pre>
     **
     * 客户端：请求时认证token
     * </pre>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      java.lang.Object ref = token_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REQUESTCMD_FIELD_NUMBER = 2;
    private int requestCmd_;
    /**
     * <code>optional int32 requestCmd = 2;</code>
     *
     * <pre>
     **
     * 客户端请求命令
     * </pre>
     */
    public boolean hasRequestCmd() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 requestCmd = 2;</code>
     *
     * <pre>
     **
     * 客户端请求命令
     * </pre>
     */
    public int getRequestCmd() {
      return requestCmd_;
    }

    public static final int RESPONSECMD_FIELD_NUMBER = 3;
    private int responseCmd_;
    /**
     * <code>optional int32 responseCmd = 3;</code>
     *
     * <pre>
     **
     * 服务端响应命令，不一定每次都有
     * </pre>
     */
    public boolean hasResponseCmd() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 responseCmd = 3;</code>
     *
     * <pre>
     **
     * 服务端响应命令，不一定每次都有
     * </pre>
     */
    public int getResponseCmd() {
      return responseCmd_;
    }

    public static final int ISSUCCEED_FIELD_NUMBER = 4;
    private boolean isSucceed_;
    /**
     * <code>optional bool isSucceed = 4;</code>
     *
     * <pre>
     **
     * 服务端：是否成功执行
     * </pre>
     */
    public boolean hasIsSucceed() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional bool isSucceed = 4;</code>
     *
     * <pre>
     **
     * 服务端：是否成功执行
     * </pre>
     */
    public boolean getIsSucceed() {
      return isSucceed_;
    }

    public static final int PBKEY_FIELD_NUMBER = 5;
    private java.lang.Object pbKey_;
    /**
     * <code>optional string pbKey = 5;</code>
     *
     * <pre>
     **
     * pb密钥，rc4 key
     * </pre>
     */
    public boolean hasPbKey() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional string pbKey = 5;</code>
     *
     * <pre>
     **
     * pb密钥，rc4 key
     * </pre>
     */
    public java.lang.String getPbKey() {
      java.lang.Object ref = pbKey_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          pbKey_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string pbKey = 5;</code>
     *
     * <pre>
     **
     * pb密钥，rc4 key
     * </pre>
     */
    public com.google.protobuf.ByteString
        getPbKeyBytes() {
      java.lang.Object ref = pbKey_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pbKey_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PBBODY_FIELD_NUMBER = 6;
    private java.lang.Object pbBody_;
    /**
     * <code>optional string pbBody = 6;</code>
     *
     * <pre>
     **
     * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
     * </pre>
     */
    public boolean hasPbBody() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional string pbBody = 6;</code>
     *
     * <pre>
     **
     * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
     * </pre>
     */
    public java.lang.String getPbBody() {
      java.lang.Object ref = pbBody_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          pbBody_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string pbBody = 6;</code>
     *
     * <pre>
     **
     * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
     * </pre>
     */
    public com.google.protobuf.ByteString
        getPbBodyBytes() {
      java.lang.Object ref = pbBody_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pbBody_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      token_ = "";
      requestCmd_ = 0;
      responseCmd_ = 0;
      isSucceed_ = false;
      pbKey_ = "";
      pbBody_ = "";
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
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getTokenBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, requestCmd_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, responseCmd_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBool(4, isSucceed_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, getPbKeyBytes());
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeBytes(6, getPbBodyBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getTokenBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, requestCmd_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, responseCmd_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(4, isSucceed_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, getPbKeyBytes());
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, getPbBodyBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.ebanswers.starfreezer.proto.PackAuth.AuthBody parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.ebanswers.starfreezer.proto.PackAuth.AuthBody prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.ebanswers.starfreezer.proto.AuthBody}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.ebanswers.starfreezer.proto.AuthBody)
        com.ebanswers.starfreezer.proto.PackAuth.AuthBodyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.ebanswers.starfreezer.proto.PackAuth.internal_static_com_ebanswers_starfreezer_proto_AuthBody_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.ebanswers.starfreezer.proto.PackAuth.internal_static_com_ebanswers_starfreezer_proto_AuthBody_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.ebanswers.starfreezer.proto.PackAuth.AuthBody.class, com.ebanswers.starfreezer.proto.PackAuth.AuthBody.Builder.class);
      }

      // Construct using com.ebanswers.starfreezer.proto.PackAuth.AuthBody.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        token_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        requestCmd_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        responseCmd_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        isSucceed_ = false;
        bitField0_ = (bitField0_ & ~0x00000008);
        pbKey_ = "";
        bitField0_ = (bitField0_ & ~0x00000010);
        pbBody_ = "";
        bitField0_ = (bitField0_ & ~0x00000020);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.ebanswers.starfreezer.proto.PackAuth.internal_static_com_ebanswers_starfreezer_proto_AuthBody_descriptor;
      }

      public com.ebanswers.starfreezer.proto.PackAuth.AuthBody getDefaultInstanceForType() {
        return com.ebanswers.starfreezer.proto.PackAuth.AuthBody.getDefaultInstance();
      }

      public com.ebanswers.starfreezer.proto.PackAuth.AuthBody build() {
        com.ebanswers.starfreezer.proto.PackAuth.AuthBody result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.ebanswers.starfreezer.proto.PackAuth.AuthBody buildPartial() {
        com.ebanswers.starfreezer.proto.PackAuth.AuthBody result = new com.ebanswers.starfreezer.proto.PackAuth.AuthBody(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.token_ = token_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.requestCmd_ = requestCmd_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.responseCmd_ = responseCmd_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.isSucceed_ = isSucceed_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.pbKey_ = pbKey_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000020;
        }
        result.pbBody_ = pbBody_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.ebanswers.starfreezer.proto.PackAuth.AuthBody) {
          return mergeFrom((com.ebanswers.starfreezer.proto.PackAuth.AuthBody)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.ebanswers.starfreezer.proto.PackAuth.AuthBody other) {
        if (other == com.ebanswers.starfreezer.proto.PackAuth.AuthBody.getDefaultInstance()) return this;
        if (other.hasToken()) {
          bitField0_ |= 0x00000001;
          token_ = other.token_;
          onChanged();
        }
        if (other.hasRequestCmd()) {
          setRequestCmd(other.getRequestCmd());
        }
        if (other.hasResponseCmd()) {
          setResponseCmd(other.getResponseCmd());
        }
        if (other.hasIsSucceed()) {
          setIsSucceed(other.getIsSucceed());
        }
        if (other.hasPbKey()) {
          bitField0_ |= 0x00000010;
          pbKey_ = other.pbKey_;
          onChanged();
        }
        if (other.hasPbBody()) {
          bitField0_ |= 0x00000020;
          pbBody_ = other.pbBody_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.ebanswers.starfreezer.proto.PackAuth.AuthBody parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.ebanswers.starfreezer.proto.PackAuth.AuthBody) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object token_ = "";
      /**
       * <code>optional string token = 1;</code>
       *
       * <pre>
       **
       * 客户端：请求时认证token
       * </pre>
       */
      public boolean hasToken() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional string token = 1;</code>
       *
       * <pre>
       **
       * 客户端：请求时认证token
       * </pre>
       */
      public java.lang.String getToken() {
        java.lang.Object ref = token_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            token_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string token = 1;</code>
       *
       * <pre>
       **
       * 客户端：请求时认证token
       * </pre>
       */
      public com.google.protobuf.ByteString
          getTokenBytes() {
        java.lang.Object ref = token_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          token_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string token = 1;</code>
       *
       * <pre>
       **
       * 客户端：请求时认证token
       * </pre>
       */
      public Builder setToken(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        token_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string token = 1;</code>
       *
       * <pre>
       **
       * 客户端：请求时认证token
       * </pre>
       */
      public Builder clearToken() {
        bitField0_ = (bitField0_ & ~0x00000001);
        token_ = getDefaultInstance().getToken();
        onChanged();
        return this;
      }
      /**
       * <code>optional string token = 1;</code>
       *
       * <pre>
       **
       * 客户端：请求时认证token
       * </pre>
       */
      public Builder setTokenBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        token_ = value;
        onChanged();
        return this;
      }

      private int requestCmd_ ;
      /**
       * <code>optional int32 requestCmd = 2;</code>
       *
       * <pre>
       **
       * 客户端请求命令
       * </pre>
       */
      public boolean hasRequestCmd() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional int32 requestCmd = 2;</code>
       *
       * <pre>
       **
       * 客户端请求命令
       * </pre>
       */
      public int getRequestCmd() {
        return requestCmd_;
      }
      /**
       * <code>optional int32 requestCmd = 2;</code>
       *
       * <pre>
       **
       * 客户端请求命令
       * </pre>
       */
      public Builder setRequestCmd(int value) {
        bitField0_ |= 0x00000002;
        requestCmd_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 requestCmd = 2;</code>
       *
       * <pre>
       **
       * 客户端请求命令
       * </pre>
       */
      public Builder clearRequestCmd() {
        bitField0_ = (bitField0_ & ~0x00000002);
        requestCmd_ = 0;
        onChanged();
        return this;
      }

      private int responseCmd_ ;
      /**
       * <code>optional int32 responseCmd = 3;</code>
       *
       * <pre>
       **
       * 服务端响应命令，不一定每次都有
       * </pre>
       */
      public boolean hasResponseCmd() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional int32 responseCmd = 3;</code>
       *
       * <pre>
       **
       * 服务端响应命令，不一定每次都有
       * </pre>
       */
      public int getResponseCmd() {
        return responseCmd_;
      }
      /**
       * <code>optional int32 responseCmd = 3;</code>
       *
       * <pre>
       **
       * 服务端响应命令，不一定每次都有
       * </pre>
       */
      public Builder setResponseCmd(int value) {
        bitField0_ |= 0x00000004;
        responseCmd_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 responseCmd = 3;</code>
       *
       * <pre>
       **
       * 服务端响应命令，不一定每次都有
       * </pre>
       */
      public Builder clearResponseCmd() {
        bitField0_ = (bitField0_ & ~0x00000004);
        responseCmd_ = 0;
        onChanged();
        return this;
      }

      private boolean isSucceed_ ;
      /**
       * <code>optional bool isSucceed = 4;</code>
       *
       * <pre>
       **
       * 服务端：是否成功执行
       * </pre>
       */
      public boolean hasIsSucceed() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional bool isSucceed = 4;</code>
       *
       * <pre>
       **
       * 服务端：是否成功执行
       * </pre>
       */
      public boolean getIsSucceed() {
        return isSucceed_;
      }
      /**
       * <code>optional bool isSucceed = 4;</code>
       *
       * <pre>
       **
       * 服务端：是否成功执行
       * </pre>
       */
      public Builder setIsSucceed(boolean value) {
        bitField0_ |= 0x00000008;
        isSucceed_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool isSucceed = 4;</code>
       *
       * <pre>
       **
       * 服务端：是否成功执行
       * </pre>
       */
      public Builder clearIsSucceed() {
        bitField0_ = (bitField0_ & ~0x00000008);
        isSucceed_ = false;
        onChanged();
        return this;
      }

      private java.lang.Object pbKey_ = "";
      /**
       * <code>optional string pbKey = 5;</code>
       *
       * <pre>
       **
       * pb密钥，rc4 key
       * </pre>
       */
      public boolean hasPbKey() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional string pbKey = 5;</code>
       *
       * <pre>
       **
       * pb密钥，rc4 key
       * </pre>
       */
      public java.lang.String getPbKey() {
        java.lang.Object ref = pbKey_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            pbKey_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string pbKey = 5;</code>
       *
       * <pre>
       **
       * pb密钥，rc4 key
       * </pre>
       */
      public com.google.protobuf.ByteString
          getPbKeyBytes() {
        java.lang.Object ref = pbKey_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pbKey_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string pbKey = 5;</code>
       *
       * <pre>
       **
       * pb密钥，rc4 key
       * </pre>
       */
      public Builder setPbKey(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        pbKey_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string pbKey = 5;</code>
       *
       * <pre>
       **
       * pb密钥，rc4 key
       * </pre>
       */
      public Builder clearPbKey() {
        bitField0_ = (bitField0_ & ~0x00000010);
        pbKey_ = getDefaultInstance().getPbKey();
        onChanged();
        return this;
      }
      /**
       * <code>optional string pbKey = 5;</code>
       *
       * <pre>
       **
       * pb密钥，rc4 key
       * </pre>
       */
      public Builder setPbKeyBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        pbKey_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object pbBody_ = "";
      /**
       * <code>optional string pbBody = 6;</code>
       *
       * <pre>
       **
       * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
       * </pre>
       */
      public boolean hasPbBody() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>optional string pbBody = 6;</code>
       *
       * <pre>
       **
       * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
       * </pre>
       */
      public java.lang.String getPbBody() {
        java.lang.Object ref = pbBody_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            pbBody_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string pbBody = 6;</code>
       *
       * <pre>
       **
       * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
       * </pre>
       */
      public com.google.protobuf.ByteString
          getPbBodyBytes() {
        java.lang.Object ref = pbBody_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pbBody_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string pbBody = 6;</code>
       *
       * <pre>
       **
       * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
       * </pre>
       */
      public Builder setPbBody(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        pbBody_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string pbBody = 6;</code>
       *
       * <pre>
       **
       * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
       * </pre>
       */
      public Builder clearPbBody() {
        bitField0_ = (bitField0_ & ~0x00000020);
        pbBody_ = getDefaultInstance().getPbBody();
        onChanged();
        return this;
      }
      /**
       * <code>optional string pbBody = 6;</code>
       *
       * <pre>
       **
       * pb报文，rc4 value；isSucceed为true时，为pb报文，为false时，为错误信息
       * </pre>
       */
      public Builder setPbBodyBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        pbBody_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.ebanswers.starfreezer.proto.AuthBody)
    }

    static {
      defaultInstance = new AuthBody(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.ebanswers.starfreezer.proto.AuthBody)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ebanswers_starfreezer_proto_AuthBody_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_ebanswers_starfreezer_proto_AuthBody_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024proto/PackAuth.proto\022\037com.ebanswers.st" +
      "arfreezer.proto\"t\n\010AuthBody\022\r\n\005token\030\001 \001" +
      "(\t\022\022\n\nrequestCmd\030\002 \001(\005\022\023\n\013responseCmd\030\003 " +
      "\001(\005\022\021\n\tisSucceed\030\004 \001(\010\022\r\n\005pbKey\030\005 \001(\t\022\016\n" +
      "\006pbBody\030\006 \001(\tB+\n\037com.ebanswers.starfreez" +
      "er.protoB\010PackAuth"
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
    internal_static_com_ebanswers_starfreezer_proto_AuthBody_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ebanswers_starfreezer_proto_AuthBody_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_ebanswers_starfreezer_proto_AuthBody_descriptor,
        new java.lang.String[] { "Token", "RequestCmd", "ResponseCmd", "IsSucceed", "PbKey", "PbBody", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
