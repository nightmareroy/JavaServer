// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packet.proto

package test;

public final class Packet {
  private Packet() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TestRequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:test.TestRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 testId = 1;</code>
     */
    int getTestId();
  }
  /**
   * Protobuf type {@code test.TestRequest}
   */
  public  static final class TestRequest extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:test.TestRequest)
      TestRequestOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use TestRequest.newBuilder() to construct.
    private TestRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TestRequest() {
      testId_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private TestRequest(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              testId_ = input.readInt32();
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return test.Packet.internal_static_test_TestRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return test.Packet.internal_static_test_TestRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              test.Packet.TestRequest.class, test.Packet.TestRequest.Builder.class);
    }

    public static final int TESTID_FIELD_NUMBER = 1;
    private int testId_;
    /**
     * <code>int32 testId = 1;</code>
     */
    public int getTestId() {
      return testId_;
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
      if (testId_ != 0) {
        output.writeInt32(1, testId_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (testId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, testId_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof test.Packet.TestRequest)) {
        return super.equals(obj);
      }
      test.Packet.TestRequest other = (test.Packet.TestRequest) obj;

      boolean result = true;
      result = result && (getTestId()
          == other.getTestId());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TESTID_FIELD_NUMBER;
      hash = (53 * hash) + getTestId();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static test.Packet.TestRequest parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static test.Packet.TestRequest parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static test.Packet.TestRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static test.Packet.TestRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static test.Packet.TestRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static test.Packet.TestRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static test.Packet.TestRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static test.Packet.TestRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static test.Packet.TestRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static test.Packet.TestRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static test.Packet.TestRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static test.Packet.TestRequest parseFrom(
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
    public static Builder newBuilder(test.Packet.TestRequest prototype) {
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
     * Protobuf type {@code test.TestRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:test.TestRequest)
        test.Packet.TestRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return test.Packet.internal_static_test_TestRequest_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return test.Packet.internal_static_test_TestRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                test.Packet.TestRequest.class, test.Packet.TestRequest.Builder.class);
      }

      // Construct using test.Packet.TestRequest.newBuilder()
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
        testId_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return test.Packet.internal_static_test_TestRequest_descriptor;
      }

      public test.Packet.TestRequest getDefaultInstanceForType() {
        return test.Packet.TestRequest.getDefaultInstance();
      }

      public test.Packet.TestRequest build() {
        test.Packet.TestRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public test.Packet.TestRequest buildPartial() {
        test.Packet.TestRequest result = new test.Packet.TestRequest(this);
        result.testId_ = testId_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
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
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof test.Packet.TestRequest) {
          return mergeFrom((test.Packet.TestRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(test.Packet.TestRequest other) {
        if (other == test.Packet.TestRequest.getDefaultInstance()) return this;
        if (other.getTestId() != 0) {
          setTestId(other.getTestId());
        }
        this.mergeUnknownFields(other.unknownFields);
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
        test.Packet.TestRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (test.Packet.TestRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int testId_ ;
      /**
       * <code>int32 testId = 1;</code>
       */
      public int getTestId() {
        return testId_;
      }
      /**
       * <code>int32 testId = 1;</code>
       */
      public Builder setTestId(int value) {
        
        testId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 testId = 1;</code>
       */
      public Builder clearTestId() {
        
        testId_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:test.TestRequest)
    }

    // @@protoc_insertion_point(class_scope:test.TestRequest)
    private static final test.Packet.TestRequest DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new test.Packet.TestRequest();
    }

    public static test.Packet.TestRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TestRequest>
        PARSER = new com.google.protobuf.AbstractParser<TestRequest>() {
      public TestRequest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TestRequest(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TestRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TestRequest> getParserForType() {
      return PARSER;
    }

    public test.Packet.TestRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface TestResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:test.TestResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.common.CommonNode testCommonNode = 1;</code>
     */
    boolean hasTestCommonNode();
    /**
     * <code>.common.CommonNode testCommonNode = 1;</code>
     */
    common.Common.CommonNode getTestCommonNode();
    /**
     * <code>.common.CommonNode testCommonNode = 1;</code>
     */
    common.Common.CommonNodeOrBuilder getTestCommonNodeOrBuilder();
  }
  /**
   * Protobuf type {@code test.TestResponse}
   */
  public  static final class TestResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:test.TestResponse)
      TestResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use TestResponse.newBuilder() to construct.
    private TestResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TestResponse() {
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private TestResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              common.Common.CommonNode.Builder subBuilder = null;
              if (testCommonNode_ != null) {
                subBuilder = testCommonNode_.toBuilder();
              }
              testCommonNode_ = input.readMessage(common.Common.CommonNode.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(testCommonNode_);
                testCommonNode_ = subBuilder.buildPartial();
              }

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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return test.Packet.internal_static_test_TestResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return test.Packet.internal_static_test_TestResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              test.Packet.TestResponse.class, test.Packet.TestResponse.Builder.class);
    }

    public static final int TESTCOMMONNODE_FIELD_NUMBER = 1;
    private common.Common.CommonNode testCommonNode_;
    /**
     * <code>.common.CommonNode testCommonNode = 1;</code>
     */
    public boolean hasTestCommonNode() {
      return testCommonNode_ != null;
    }
    /**
     * <code>.common.CommonNode testCommonNode = 1;</code>
     */
    public common.Common.CommonNode getTestCommonNode() {
      return testCommonNode_ == null ? common.Common.CommonNode.getDefaultInstance() : testCommonNode_;
    }
    /**
     * <code>.common.CommonNode testCommonNode = 1;</code>
     */
    public common.Common.CommonNodeOrBuilder getTestCommonNodeOrBuilder() {
      return getTestCommonNode();
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
      if (testCommonNode_ != null) {
        output.writeMessage(1, getTestCommonNode());
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (testCommonNode_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getTestCommonNode());
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof test.Packet.TestResponse)) {
        return super.equals(obj);
      }
      test.Packet.TestResponse other = (test.Packet.TestResponse) obj;

      boolean result = true;
      result = result && (hasTestCommonNode() == other.hasTestCommonNode());
      if (hasTestCommonNode()) {
        result = result && getTestCommonNode()
            .equals(other.getTestCommonNode());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasTestCommonNode()) {
        hash = (37 * hash) + TESTCOMMONNODE_FIELD_NUMBER;
        hash = (53 * hash) + getTestCommonNode().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static test.Packet.TestResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static test.Packet.TestResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static test.Packet.TestResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static test.Packet.TestResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static test.Packet.TestResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static test.Packet.TestResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static test.Packet.TestResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static test.Packet.TestResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static test.Packet.TestResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static test.Packet.TestResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static test.Packet.TestResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static test.Packet.TestResponse parseFrom(
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
    public static Builder newBuilder(test.Packet.TestResponse prototype) {
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
     * Protobuf type {@code test.TestResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:test.TestResponse)
        test.Packet.TestResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return test.Packet.internal_static_test_TestResponse_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return test.Packet.internal_static_test_TestResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                test.Packet.TestResponse.class, test.Packet.TestResponse.Builder.class);
      }

      // Construct using test.Packet.TestResponse.newBuilder()
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
        if (testCommonNodeBuilder_ == null) {
          testCommonNode_ = null;
        } else {
          testCommonNode_ = null;
          testCommonNodeBuilder_ = null;
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return test.Packet.internal_static_test_TestResponse_descriptor;
      }

      public test.Packet.TestResponse getDefaultInstanceForType() {
        return test.Packet.TestResponse.getDefaultInstance();
      }

      public test.Packet.TestResponse build() {
        test.Packet.TestResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public test.Packet.TestResponse buildPartial() {
        test.Packet.TestResponse result = new test.Packet.TestResponse(this);
        if (testCommonNodeBuilder_ == null) {
          result.testCommonNode_ = testCommonNode_;
        } else {
          result.testCommonNode_ = testCommonNodeBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
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
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof test.Packet.TestResponse) {
          return mergeFrom((test.Packet.TestResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(test.Packet.TestResponse other) {
        if (other == test.Packet.TestResponse.getDefaultInstance()) return this;
        if (other.hasTestCommonNode()) {
          mergeTestCommonNode(other.getTestCommonNode());
        }
        this.mergeUnknownFields(other.unknownFields);
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
        test.Packet.TestResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (test.Packet.TestResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private common.Common.CommonNode testCommonNode_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          common.Common.CommonNode, common.Common.CommonNode.Builder, common.Common.CommonNodeOrBuilder> testCommonNodeBuilder_;
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public boolean hasTestCommonNode() {
        return testCommonNodeBuilder_ != null || testCommonNode_ != null;
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public common.Common.CommonNode getTestCommonNode() {
        if (testCommonNodeBuilder_ == null) {
          return testCommonNode_ == null ? common.Common.CommonNode.getDefaultInstance() : testCommonNode_;
        } else {
          return testCommonNodeBuilder_.getMessage();
        }
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public Builder setTestCommonNode(common.Common.CommonNode value) {
        if (testCommonNodeBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          testCommonNode_ = value;
          onChanged();
        } else {
          testCommonNodeBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public Builder setTestCommonNode(
          common.Common.CommonNode.Builder builderForValue) {
        if (testCommonNodeBuilder_ == null) {
          testCommonNode_ = builderForValue.build();
          onChanged();
        } else {
          testCommonNodeBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public Builder mergeTestCommonNode(common.Common.CommonNode value) {
        if (testCommonNodeBuilder_ == null) {
          if (testCommonNode_ != null) {
            testCommonNode_ =
              common.Common.CommonNode.newBuilder(testCommonNode_).mergeFrom(value).buildPartial();
          } else {
            testCommonNode_ = value;
          }
          onChanged();
        } else {
          testCommonNodeBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public Builder clearTestCommonNode() {
        if (testCommonNodeBuilder_ == null) {
          testCommonNode_ = null;
          onChanged();
        } else {
          testCommonNode_ = null;
          testCommonNodeBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public common.Common.CommonNode.Builder getTestCommonNodeBuilder() {
        
        onChanged();
        return getTestCommonNodeFieldBuilder().getBuilder();
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      public common.Common.CommonNodeOrBuilder getTestCommonNodeOrBuilder() {
        if (testCommonNodeBuilder_ != null) {
          return testCommonNodeBuilder_.getMessageOrBuilder();
        } else {
          return testCommonNode_ == null ?
              common.Common.CommonNode.getDefaultInstance() : testCommonNode_;
        }
      }
      /**
       * <code>.common.CommonNode testCommonNode = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          common.Common.CommonNode, common.Common.CommonNode.Builder, common.Common.CommonNodeOrBuilder> 
          getTestCommonNodeFieldBuilder() {
        if (testCommonNodeBuilder_ == null) {
          testCommonNodeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              common.Common.CommonNode, common.Common.CommonNode.Builder, common.Common.CommonNodeOrBuilder>(
                  getTestCommonNode(),
                  getParentForChildren(),
                  isClean());
          testCommonNode_ = null;
        }
        return testCommonNodeBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:test.TestResponse)
    }

    // @@protoc_insertion_point(class_scope:test.TestResponse)
    private static final test.Packet.TestResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new test.Packet.TestResponse();
    }

    public static test.Packet.TestResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TestResponse>
        PARSER = new com.google.protobuf.AbstractParser<TestResponse>() {
      public TestResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TestResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TestResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TestResponse> getParserForType() {
      return PARSER;
    }

    public test.Packet.TestResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_test_TestRequest_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_test_TestRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_test_TestResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_test_TestResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014packet.proto\022\004test\032\014common.proto\"\035\n\013Te" +
      "stRequest\022\016\n\006testId\030\001 \001(\005\":\n\014TestRespons" +
      "e\022*\n\016testCommonNode\030\001 \001(\0132\022.common.Commo" +
      "nNodeb\006proto3"
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
          common.Common.getDescriptor(),
        }, assigner);
    internal_static_test_TestRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_test_TestRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_test_TestRequest_descriptor,
        new java.lang.String[] { "TestId", });
    internal_static_test_TestResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_test_TestResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_test_TestResponse_descriptor,
        new java.lang.String[] { "TestCommonNode", });
    common.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
