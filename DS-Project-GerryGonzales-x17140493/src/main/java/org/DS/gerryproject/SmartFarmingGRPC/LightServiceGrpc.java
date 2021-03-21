package org.DS.gerryproject.SmartFarmingGRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Light.proto")
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "SmartFarmingGRPC.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.Empty,
      org.DS.gerryproject.SmartFarmingGRPC.lightResponse> getInitialApplianceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initialAppliance",
      requestType = org.DS.gerryproject.SmartFarmingGRPC.Empty.class,
      responseType = org.DS.gerryproject.SmartFarmingGRPC.lightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.Empty,
      org.DS.gerryproject.SmartFarmingGRPC.lightResponse> getInitialApplianceMethod() {
    io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.Empty, org.DS.gerryproject.SmartFarmingGRPC.lightResponse> getInitialApplianceMethod;
    if ((getInitialApplianceMethod = LightServiceGrpc.getInitialApplianceMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getInitialApplianceMethod = LightServiceGrpc.getInitialApplianceMethod) == null) {
          LightServiceGrpc.getInitialApplianceMethod = getInitialApplianceMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.Empty, org.DS.gerryproject.SmartFarmingGRPC.lightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.LightService", "initialAppliance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.lightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("initialAppliance"))
                  .build();
          }
        }
     }
     return getInitialApplianceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
      org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeBrightness",
      requestType = org.DS.gerryproject.SmartFarmingGRPC.valueRequest.class,
      responseType = org.DS.gerryproject.SmartFarmingGRPC.valueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
      org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeBrightnessMethod() {
    io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest, org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeBrightnessMethod;
    if ((getChangeBrightnessMethod = LightServiceGrpc.getChangeBrightnessMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getChangeBrightnessMethod = LightServiceGrpc.getChangeBrightnessMethod) == null) {
          LightServiceGrpc.getChangeBrightnessMethod = getChangeBrightnessMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.valueRequest, org.DS.gerryproject.SmartFarmingGRPC.valueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.LightService", "changeBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.valueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.valueResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("changeBrightness"))
                  .build();
          }
        }
     }
     return getChangeBrightnessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.booleanRequest,
      org.DS.gerryproject.SmartFarmingGRPC.booleanResponse> getOnOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onOff",
      requestType = org.DS.gerryproject.SmartFarmingGRPC.booleanRequest.class,
      responseType = org.DS.gerryproject.SmartFarmingGRPC.booleanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.booleanRequest,
      org.DS.gerryproject.SmartFarmingGRPC.booleanResponse> getOnOffMethod() {
    io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.booleanRequest, org.DS.gerryproject.SmartFarmingGRPC.booleanResponse> getOnOffMethod;
    if ((getOnOffMethod = LightServiceGrpc.getOnOffMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getOnOffMethod = LightServiceGrpc.getOnOffMethod) == null) {
          LightServiceGrpc.getOnOffMethod = getOnOffMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.booleanRequest, org.DS.gerryproject.SmartFarmingGRPC.booleanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.LightService", "onOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.booleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.booleanResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("onOff"))
                  .build();
          }
        }
     }
     return getOnOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.stringRequest,
      org.DS.gerryproject.SmartFarmingGRPC.stringResponse> getChangeApplianceNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeApplianceName",
      requestType = org.DS.gerryproject.SmartFarmingGRPC.stringRequest.class,
      responseType = org.DS.gerryproject.SmartFarmingGRPC.stringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.stringRequest,
      org.DS.gerryproject.SmartFarmingGRPC.stringResponse> getChangeApplianceNameMethod() {
    io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.stringRequest, org.DS.gerryproject.SmartFarmingGRPC.stringResponse> getChangeApplianceNameMethod;
    if ((getChangeApplianceNameMethod = LightServiceGrpc.getChangeApplianceNameMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getChangeApplianceNameMethod = LightServiceGrpc.getChangeApplianceNameMethod) == null) {
          LightServiceGrpc.getChangeApplianceNameMethod = getChangeApplianceNameMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.stringRequest, org.DS.gerryproject.SmartFarmingGRPC.stringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.LightService", "changeApplianceName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.stringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.stringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("changeApplianceName"))
                  .build();
          }
        }
     }
     return getChangeApplianceNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    return new LightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void initialAppliance(org.DS.gerryproject.SmartFarmingGRPC.Empty request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.lightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInitialApplianceMethod(), responseObserver);
    }

    /**
     */
    public void changeBrightness(org.DS.gerryproject.SmartFarmingGRPC.valueRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeBrightnessMethod(), responseObserver);
    }

    /**
     */
    public void onOff(org.DS.gerryproject.SmartFarmingGRPC.booleanRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.booleanResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOnOffMethod(), responseObserver);
    }

    /**
     */
    public void changeApplianceName(org.DS.gerryproject.SmartFarmingGRPC.stringRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.stringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeApplianceNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInitialApplianceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.DS.gerryproject.SmartFarmingGRPC.Empty,
                org.DS.gerryproject.SmartFarmingGRPC.lightResponse>(
                  this, METHODID_INITIAL_APPLIANCE)))
          .addMethod(
            getChangeBrightnessMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
                org.DS.gerryproject.SmartFarmingGRPC.valueResponse>(
                  this, METHODID_CHANGE_BRIGHTNESS)))
          .addMethod(
            getOnOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.DS.gerryproject.SmartFarmingGRPC.booleanRequest,
                org.DS.gerryproject.SmartFarmingGRPC.booleanResponse>(
                  this, METHODID_ON_OFF)))
          .addMethod(
            getChangeApplianceNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.DS.gerryproject.SmartFarmingGRPC.stringRequest,
                org.DS.gerryproject.SmartFarmingGRPC.stringResponse>(
                  this, METHODID_CHANGE_APPLIANCE_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractStub<LightServiceStub> {
    private LightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     */
    public void initialAppliance(org.DS.gerryproject.SmartFarmingGRPC.Empty request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.lightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitialApplianceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeBrightness(org.DS.gerryproject.SmartFarmingGRPC.valueRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getChangeBrightnessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onOff(org.DS.gerryproject.SmartFarmingGRPC.booleanRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.booleanResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOnOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeApplianceName(org.DS.gerryproject.SmartFarmingGRPC.stringRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.stringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeApplianceNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.DS.gerryproject.SmartFarmingGRPC.lightResponse initialAppliance(org.DS.gerryproject.SmartFarmingGRPC.Empty request) {
      return blockingUnaryCall(
          getChannel(), getInitialApplianceMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> changeBrightness(
        org.DS.gerryproject.SmartFarmingGRPC.valueRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getChangeBrightnessMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.DS.gerryproject.SmartFarmingGRPC.booleanResponse onOff(org.DS.gerryproject.SmartFarmingGRPC.booleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getOnOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.DS.gerryproject.SmartFarmingGRPC.stringResponse changeApplianceName(org.DS.gerryproject.SmartFarmingGRPC.stringRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeApplianceNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractStub<LightServiceFutureStub> {
    private LightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.DS.gerryproject.SmartFarmingGRPC.lightResponse> initialAppliance(
        org.DS.gerryproject.SmartFarmingGRPC.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getInitialApplianceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.DS.gerryproject.SmartFarmingGRPC.booleanResponse> onOff(
        org.DS.gerryproject.SmartFarmingGRPC.booleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOnOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.DS.gerryproject.SmartFarmingGRPC.stringResponse> changeApplianceName(
        org.DS.gerryproject.SmartFarmingGRPC.stringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeApplianceNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INITIAL_APPLIANCE = 0;
  private static final int METHODID_CHANGE_BRIGHTNESS = 1;
  private static final int METHODID_ON_OFF = 2;
  private static final int METHODID_CHANGE_APPLIANCE_NAME = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INITIAL_APPLIANCE:
          serviceImpl.initialAppliance((org.DS.gerryproject.SmartFarmingGRPC.Empty) request,
              (io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.lightResponse>) responseObserver);
          break;
        case METHODID_CHANGE_BRIGHTNESS:
          serviceImpl.changeBrightness((org.DS.gerryproject.SmartFarmingGRPC.valueRequest) request,
              (io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse>) responseObserver);
          break;
        case METHODID_ON_OFF:
          serviceImpl.onOff((org.DS.gerryproject.SmartFarmingGRPC.booleanRequest) request,
              (io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.booleanResponse>) responseObserver);
          break;
        case METHODID_CHANGE_APPLIANCE_NAME:
          serviceImpl.changeApplianceName((org.DS.gerryproject.SmartFarmingGRPC.stringRequest) request,
              (io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.stringResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.DS.gerryproject.SmartFarmingGRPC.LightServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getInitialApplianceMethod())
              .addMethod(getChangeBrightnessMethod())
              .addMethod(getOnOffMethod())
              .addMethod(getChangeApplianceNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
