package GRPC;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import org.DS.gerryproject.SmartFarmingGRPC.Empty;
import org.DS.gerryproject.SmartFarmingGRPC.HeatingServiceGrpc.HeatingServiceImplBase;
import org.DS.gerryproject.SmartFarmingGRPC.booleanRequest;
import org.DS.gerryproject.SmartFarmingGRPC.booleanResponse;
import org.DS.gerryproject.SmartFarmingGRPC.heatingResponse;
import org.DS.gerryproject.SmartFarmingGRPC.stringRequest;
import org.DS.gerryproject.SmartFarmingGRPC.stringResponse;
import org.DS.gerryproject.SmartFarmingGRPC.valueRequest;
import org.DS.gerryproject.SmartFarmingGRPC.valueResponse;

import io.grpc.stub.StreamObserver;

import com.google.protobuf.Int32ValueOrBuilder;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import Models.Heating;

public class HeatingServer extends HeatingServiceImplBase{
	private static final Logger logger = Logger.getLogger(HeatingServer.class.getName());
	public Heating myHeating = new Heating();
	public static int heatingPort;
	
	private static class SampleListener implements ServiceListener {//start class

		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: " + event.getInfo());

		}

		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}

		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service resolved: " + event.getInfo());
			System.out.println("Get Name: " + event.getName() + " PORT: " + event.getInfo().getPort());

			// Start GRPC server with discovered device
			if (event.getName().equals("Heating")) {
				System.out.println("Found Heating port: " + event.getInfo().getPort());
				try {
					heatingPort = event.getInfo().getPort();
					startGRPC(event.getInfo().getPort());
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}//end method

	public static void main(String[] args) throws IOException, InterruptedException {
		startDiscovery();
	}

	public static void startDiscovery() throws IOException, InterruptedException {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Add a service listener
			jmdns.addServiceListener("_http._tcp.local.", new SampleListener());
			System.out.println("Listening");
			// Wait a bit
			Thread.sleep(30000);
		} 
		catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void startGRPC(int portNumber) throws IOException, InterruptedException {
		HeatingServer heatingServer = new HeatingServer();
		Server server = ServerBuilder.forPort(portNumber).addService(heatingServer).build().start();

		logger.info("Heating Server started, listening on " + portNumber);

		server.awaitTermination();
	}

	@Override
	public void initialAppliance(Empty request, StreamObserver<heatingResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("Receiving initial appliance request for TV ");
		String status;
		
		if(myHeating.isOn()) {
			status = "On";
		}
		else {
			status = "Off";
		}
		
		String aName = myHeating.getApplianceName();
		String aStatus = status;
		Integer aTemperature = myHeating.getTemperature();
		Integer aFan = myHeating.getSpeed();
		
		heatingResponse response = heatingResponse.newBuilder().setAname(aName).setStatus(aStatus).setTemperature(aTemperature).setFan(aFan).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
		
	}

	@Override
	public void changeTemperature(valueRequest request, StreamObserver<valueResponse> responseObserver) {
		// TODO Auto-generated method stub
		int currentTemperature = myHeating.getTemperature();
		int changeTemperature = request.getLength();
		
		System.out.println("Receiving new temperature for heating " + currentTemperature);
		int newTemperature = currentTemperature + changeTemperature;
		if(newTemperature > 40 || newTemperature < 0 ) {//start if
			System.out.println("Temperature cannot exceed 40 or be less than 0: " + newTemperature);
			System.out.println("The current Temperature is set to: " + myHeating.getTemperature());
			
			valueResponse response = valueResponse.newBuilder().setLength(myHeating.getTemperature()).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end if
		else {//start else
			myHeating.setTemperature(newTemperature);
			System.out.println("The updated temperature is: " + newTemperature);		
			valueResponse response = valueResponse.newBuilder().setLength(newTemperature).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end else
		
	}

	@Override
	public void changeFan(valueRequest request, StreamObserver<valueResponse> responseObserver) {
		// TODO Auto-generated method stub
		int currentSpeed = myHeating.getSpeed();
		int changeSpeed = request.getLength();
		
		System.out.println("Receiving new fan speed for heating " + currentSpeed);
		int newSpeed = currentSpeed + changeSpeed;
		if(newSpeed > 10 || newSpeed < 0 ) {//start if
			System.out.println("Speed cannot exceed 10 or be less than 0: " + newSpeed);
			System.out.println("The current speed is set to: " + myHeating.getSpeed());
			
			valueResponse response = valueResponse.newBuilder().setLength(myHeating.getSpeed()).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end if
		else {//start else
			myHeating.setSpeed(newSpeed);
			System.out.println("The updated fan speed is: " + newSpeed);		
			valueResponse response = valueResponse.newBuilder().setLength(newSpeed).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end else
		
	}

	@Override
	public void onOff(booleanRequest request, StreamObserver<booleanResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("Receiving information about On/Off for Heating");
		Boolean onOff = request.getMsg();
		myHeating.setOn(onOff);
		
		//print out
		booleanResponse response = booleanResponse.newBuilder().setMsg(onOff).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void changeApplianceName(stringRequest request, StreamObserver<stringResponse> responseObserver) {
		// TODO Auto-generated method stub
		String name = request.getText();
		System.out.println("Changing projector name to "+name);

		myHeating.setApplianceName(name);
		 
		stringResponse response = stringResponse.newBuilder().setText(name).build();
		System.out.println("Response "+response.getText());
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	 public StreamObserver<stringRequest> changeDeviceNameStream(final StreamObserver<stringResponse> responseObserver){
		return new StreamObserver<stringRequest>() {

			@Override
			public void onNext(stringRequest value) {
				// TODO Auto-generated method stub
				System.out.println("Next text value " + value.getText());
				stringResponse resp = stringResponse.newBuilder().setText(value.getText()).build();
				responseObserver.onNext(resp);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				responseObserver.onCompleted();
			}
			
		};
		 
	 }
	
}
