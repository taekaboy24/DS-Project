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
    comments = "Source: Heating.proto")
public final class HeatingServiceGrpc {

  private HeatingServiceGrpc() {}

  public static final String SERVICE_NAME = "SmartFarmingGRPC.HeatingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.Empty,
      org.DS.gerryproject.SmartFarmingGRPC.heatingResponse> getInitialApplianceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "initialAppliance",
      requestType = org.DS.gerryproject.SmartFarmingGRPC.Empty.class,
      responseType = org.DS.gerryproject.SmartFarmingGRPC.heatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.Empty,
      org.DS.gerryproject.SmartFarmingGRPC.heatingResponse> getInitialApplianceMethod() {
    io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.Empty, org.DS.gerryproject.SmartFarmingGRPC.heatingResponse> getInitialApplianceMethod;
    if ((getInitialApplianceMethod = HeatingServiceGrpc.getInitialApplianceMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getInitialApplianceMethod = HeatingServiceGrpc.getInitialApplianceMethod) == null) {
          HeatingServiceGrpc.getInitialApplianceMethod = getInitialApplianceMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.Empty, org.DS.gerryproject.SmartFarmingGRPC.heatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.HeatingService", "initialAppliance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.heatingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("initialAppliance"))
                  .build();
          }
        }
     }
     return getInitialApplianceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
      org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeTemperature",
      requestType = org.DS.gerryproject.SmartFarmingGRPC.valueRequest.class,
      responseType = org.DS.gerryproject.SmartFarmingGRPC.valueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
      org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeTemperatureMethod() {
    io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest, org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeTemperatureMethod;
    if ((getChangeTemperatureMethod = HeatingServiceGrpc.getChangeTemperatureMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getChangeTemperatureMethod = HeatingServiceGrpc.getChangeTemperatureMethod) == null) {
          HeatingServiceGrpc.getChangeTemperatureMethod = getChangeTemperatureMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.valueRequest, org.DS.gerryproject.SmartFarmingGRPC.valueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.HeatingService", "changeTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.valueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.valueResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("changeTemperature"))
                  .build();
          }
        }
     }
     return getChangeTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
      org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeFanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeFan",
      requestType = org.DS.gerryproject.SmartFarmingGRPC.valueRequest.class,
      responseType = org.DS.gerryproject.SmartFarmingGRPC.valueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
      org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeFanMethod() {
    io.grpc.MethodDescriptor<org.DS.gerryproject.SmartFarmingGRPC.valueRequest, org.DS.gerryproject.SmartFarmingGRPC.valueResponse> getChangeFanMethod;
    if ((getChangeFanMethod = HeatingServiceGrpc.getChangeFanMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getChangeFanMethod = HeatingServiceGrpc.getChangeFanMethod) == null) {
          HeatingServiceGrpc.getChangeFanMethod = getChangeFanMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.valueRequest, org.DS.gerryproject.SmartFarmingGRPC.valueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.HeatingService", "changeFan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.valueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.valueResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("changeFan"))
                  .build();
          }
        }
     }
     return getChangeFanMethod;
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
    if ((getOnOffMethod = HeatingServiceGrpc.getOnOffMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getOnOffMethod = HeatingServiceGrpc.getOnOffMethod) == null) {
          HeatingServiceGrpc.getOnOffMethod = getOnOffMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.booleanRequest, org.DS.gerryproject.SmartFarmingGRPC.booleanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.HeatingService", "onOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.booleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.booleanResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("onOff"))
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
    if ((getChangeApplianceNameMethod = HeatingServiceGrpc.getChangeApplianceNameMethod) == null) {
      synchronized (HeatingServiceGrpc.class) {
        if ((getChangeApplianceNameMethod = HeatingServiceGrpc.getChangeApplianceNameMethod) == null) {
          HeatingServiceGrpc.getChangeApplianceNameMethod = getChangeApplianceNameMethod = 
              io.grpc.MethodDescriptor.<org.DS.gerryproject.SmartFarmingGRPC.stringRequest, org.DS.gerryproject.SmartFarmingGRPC.stringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartFarmingGRPC.HeatingService", "changeApplianceName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.stringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.DS.gerryproject.SmartFarmingGRPC.stringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HeatingServiceMethodDescriptorSupplier("changeApplianceName"))
                  .build();
          }
        }
     }
     return getChangeApplianceNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HeatingServiceStub newStub(io.grpc.Channel channel) {
    return new HeatingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HeatingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HeatingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HeatingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HeatingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HeatingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void initialAppliance(org.DS.gerryproject.SmartFarmingGRPC.Empty request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.heatingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInitialApplianceMethod(), responseObserver);
    }

    /**
     */
    public void changeTemperature(org.DS.gerryproject.SmartFarmingGRPC.valueRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeTemperatureMethod(), responseObserver);
    }

    /**
     */
    public void changeFan(org.DS.gerryproject.SmartFarmingGRPC.valueRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeFanMethod(), responseObserver);
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
                org.DS.gerryproject.SmartFarmingGRPC.heatingResponse>(
                  this, METHODID_INITIAL_APPLIANCE)))
          .addMethod(
            getChangeTemperatureMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
                org.DS.gerryproject.SmartFarmingGRPC.valueResponse>(
                  this, METHODID_CHANGE_TEMPERATURE)))
          .addMethod(
            getChangeFanMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.DS.gerryproject.SmartFarmingGRPC.valueRequest,
                org.DS.gerryproject.SmartFarmingGRPC.valueResponse>(
                  this, METHODID_CHANGE_FAN)))
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
  public static final class HeatingServiceStub extends io.grpc.stub.AbstractStub<HeatingServiceStub> {
    private HeatingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HeatingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HeatingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HeatingServiceStub(channel, callOptions);
    }

    /**
     */
    public void initialAppliance(org.DS.gerryproject.SmartFarmingGRPC.Empty request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.heatingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitialApplianceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeTemperature(org.DS.gerryproject.SmartFarmingGRPC.valueRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getChangeTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeFan(org.DS.gerryproject.SmartFarmingGRPC.valueRequest request,
        io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getChangeFanMethod(), getCallOptions()), request, responseObserver);
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
  public static final class HeatingServiceBlockingStub extends io.grpc.stub.AbstractStub<HeatingServiceBlockingStub> {
    private HeatingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HeatingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HeatingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HeatingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.DS.gerryproject.SmartFarmingGRPC.heatingResponse initialAppliance(org.DS.gerryproject.SmartFarmingGRPC.Empty request) {
      return blockingUnaryCall(
          getChannel(), getInitialApplianceMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> changeTemperature(
        org.DS.gerryproject.SmartFarmingGRPC.valueRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getChangeTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.DS.gerryproject.SmartFarmingGRPC.valueResponse> changeFan(
        org.DS.gerryproject.SmartFarmingGRPC.valueRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getChangeFanMethod(), getCallOptions(), request);
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
  public static final class HeatingServiceFutureStub extends io.grpc.stub.AbstractStub<HeatingServiceFutureStub> {
    private HeatingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HeatingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HeatingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HeatingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.DS.gerryproject.SmartFarmingGRPC.heatingResponse> initialAppliance(
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
  private static final int METHODID_CHANGE_TEMPERATURE = 1;
  private static final int METHODID_CHANGE_FAN = 2;
  private static final int METHODID_ON_OFF = 3;
  private static final int METHODID_CHANGE_APPLIANCE_NAME = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HeatingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HeatingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INITIAL_APPLIANCE:
          serviceImpl.initialAppliance((org.DS.gerryproject.SmartFarmingGRPC.Empty) request,
              (io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.heatingResponse>) responseObserver);
          break;
        case METHODID_CHANGE_TEMPERATURE:
          serviceImpl.changeTemperature((org.DS.gerryproject.SmartFarmingGRPC.valueRequest) request,
              (io.grpc.stub.StreamObserver<org.DS.gerryproject.SmartFarmingGRPC.valueResponse>) responseObserver);
          break;
        case METHODID_CHANGE_FAN:
          serviceImpl.changeFan((org.DS.gerryproject.SmartFarmingGRPC.valueRequest) request,
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

  private static abstract class HeatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HeatingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.DS.gerryproject.SmartFarmingGRPC.HeatingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HeatingService");
    }
  }

  private static final class HeatingServiceFileDescriptorSupplier
      extends HeatingServiceBaseDescriptorSupplier {
    HeatingServiceFileDescriptorSupplier() {}
  }

  private static final class HeatingServiceMethodDescriptorSupplier
      extends HeatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HeatingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HeatingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HeatingServiceFileDescriptorSupplier())
              .addMethod(getInitialApplianceMethod())
              .addMethod(getChangeTemperatureMethod())
              .addMethod(getChangeFanMethod())
              .addMethod(getOnOffMethod())
              .addMethod(getChangeApplianceNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
