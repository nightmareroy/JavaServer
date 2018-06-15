// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services.proto

package test;

public final class Services {
  private Services() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf service {@code test.Handle}
   */
  public static abstract class Handle
      implements com.google.protobuf.Service {
    protected Handle() {}

    public interface Interface {
      /**
       * <code>rpc Test(.test.TestRequest) returns (.test.TestResponse);</code>
       */
      public abstract void test(
          com.google.protobuf.RpcController controller,
          test.Packet.TestRequest request,
          com.google.protobuf.RpcCallback<test.Packet.TestResponse> done);

      /**
       * <code>rpc Test222(.test.Test2Request) returns (.test.Test2Response);</code>
       */
      public abstract void test222(
          com.google.protobuf.RpcController controller,
          test.Packet2.Test2Request request,
          com.google.protobuf.RpcCallback<test.Packet2.Test2Response> done);

    }

    public static com.google.protobuf.Service newReflectiveService(
        final Interface impl) {
      return new Handle() {
        @java.lang.Override
        public  void test(
            com.google.protobuf.RpcController controller,
            test.Packet.TestRequest request,
            com.google.protobuf.RpcCallback<test.Packet.TestResponse> done) {
          impl.test(controller, request, done);
        }

        @java.lang.Override
        public  void test222(
            com.google.protobuf.RpcController controller,
            test.Packet2.Test2Request request,
            com.google.protobuf.RpcCallback<test.Packet2.Test2Response> done) {
          impl.test222(controller, request, done);
        }

      };
    }

    public static com.google.protobuf.BlockingService
        newReflectiveBlockingService(final BlockingInterface impl) {
      return new com.google.protobuf.BlockingService() {
        public final com.google.protobuf.Descriptors.ServiceDescriptor
            getDescriptorForType() {
          return getDescriptor();
        }

        public final com.google.protobuf.Message callBlockingMethod(
            com.google.protobuf.Descriptors.MethodDescriptor method,
            com.google.protobuf.RpcController controller,
            com.google.protobuf.Message request)
            throws com.google.protobuf.ServiceException {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.callBlockingMethod() given method descriptor for " +
              "wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return impl.test(controller, (test.Packet.TestRequest)request);
            case 1:
              return impl.test222(controller, (test.Packet2.Test2Request)request);
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getRequestPrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.getRequestPrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return test.Packet.TestRequest.getDefaultInstance();
            case 1:
              return test.Packet2.Test2Request.getDefaultInstance();
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getResponsePrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.getResponsePrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return test.Packet.TestResponse.getDefaultInstance();
            case 1:
              return test.Packet2.Test2Response.getDefaultInstance();
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

      };
    }

    /**
     * <code>rpc Test(.test.TestRequest) returns (.test.TestResponse);</code>
     */
    public abstract void test(
        com.google.protobuf.RpcController controller,
        test.Packet.TestRequest request,
        com.google.protobuf.RpcCallback<test.Packet.TestResponse> done);

    /**
     * <code>rpc Test222(.test.Test2Request) returns (.test.Test2Response);</code>
     */
    public abstract void test222(
        com.google.protobuf.RpcController controller,
        test.Packet2.Test2Request request,
        com.google.protobuf.RpcCallback<test.Packet2.Test2Response> done);

    public static final
        com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptor() {
      return test.Services.getDescriptor().getServices().get(0);
    }
    public final com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }

    public final void callMethod(
        com.google.protobuf.Descriptors.MethodDescriptor method,
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Message request,
        com.google.protobuf.RpcCallback<
          com.google.protobuf.Message> done) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.callMethod() given method descriptor for wrong " +
          "service type.");
      }
      switch(method.getIndex()) {
        case 0:
          this.test(controller, (test.Packet.TestRequest)request,
            com.google.protobuf.RpcUtil.<test.Packet.TestResponse>specializeCallback(
              done));
          return;
        case 1:
          this.test222(controller, (test.Packet2.Test2Request)request,
            com.google.protobuf.RpcUtil.<test.Packet2.Test2Response>specializeCallback(
              done));
          return;
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getRequestPrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.getRequestPrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return test.Packet.TestRequest.getDefaultInstance();
        case 1:
          return test.Packet2.Test2Request.getDefaultInstance();
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getResponsePrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.getResponsePrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return test.Packet.TestResponse.getDefaultInstance();
        case 1:
          return test.Packet2.Test2Response.getDefaultInstance();
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public static Stub newStub(
        com.google.protobuf.RpcChannel channel) {
      return new Stub(channel);
    }

    public static final class Stub extends test.Services.Handle implements Interface {
      private Stub(com.google.protobuf.RpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.RpcChannel channel;

      public com.google.protobuf.RpcChannel getChannel() {
        return channel;
      }

      public  void test(
          com.google.protobuf.RpcController controller,
          test.Packet.TestRequest request,
          com.google.protobuf.RpcCallback<test.Packet.TestResponse> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          test.Packet.TestResponse.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            test.Packet.TestResponse.class,
            test.Packet.TestResponse.getDefaultInstance()));
      }

      public  void test222(
          com.google.protobuf.RpcController controller,
          test.Packet2.Test2Request request,
          com.google.protobuf.RpcCallback<test.Packet2.Test2Response> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(1),
          controller,
          request,
          test.Packet2.Test2Response.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            test.Packet2.Test2Response.class,
            test.Packet2.Test2Response.getDefaultInstance()));
      }
    }

    public static BlockingInterface newBlockingStub(
        com.google.protobuf.BlockingRpcChannel channel) {
      return new BlockingStub(channel);
    }

    public interface BlockingInterface {
      public test.Packet.TestResponse test(
          com.google.protobuf.RpcController controller,
          test.Packet.TestRequest request)
          throws com.google.protobuf.ServiceException;

      public test.Packet2.Test2Response test222(
          com.google.protobuf.RpcController controller,
          test.Packet2.Test2Request request)
          throws com.google.protobuf.ServiceException;
    }

    private static final class BlockingStub implements BlockingInterface {
      private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.BlockingRpcChannel channel;

      public test.Packet.TestResponse test(
          com.google.protobuf.RpcController controller,
          test.Packet.TestRequest request)
          throws com.google.protobuf.ServiceException {
        return (test.Packet.TestResponse) channel.callBlockingMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          test.Packet.TestResponse.getDefaultInstance());
      }


      public test.Packet2.Test2Response test222(
          com.google.protobuf.RpcController controller,
          test.Packet2.Test2Request request)
          throws com.google.protobuf.ServiceException {
        return (test.Packet2.Test2Response) channel.callBlockingMethod(
          getDescriptor().getMethods().get(1),
          controller,
          request,
          test.Packet2.Test2Response.getDefaultInstance());
      }

    }

    // @@protoc_insertion_point(class_scope:test.Handle)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016services.proto\022\004test\032\014packet.proto\032\rpa" +
      "cket2.proto2k\n\006Handle\022-\n\004Test\022\021.test.Tes" +
      "tRequest\032\022.test.TestResponse\0222\n\007Test222\022" +
      "\022.test.Test2Request\032\023.test.Test2Response" +
      "B\003\210\001\001b\006proto3"
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
          test.Packet.getDescriptor(),
          test.Packet2.getDescriptor(),
        }, assigner);
    test.Packet.getDescriptor();
    test.Packet2.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
