package GRPC;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import org.DS.gerryproject.SmartFarmingGRPC.Empty;
import org.DS.gerryproject.SmartFarmingGRPC.SprinklerServiceGrpc.SprinklerServiceImplBase;
import org.DS.gerryproject.SmartFarmingGRPC.booleanRequest;
import org.DS.gerryproject.SmartFarmingGRPC.booleanResponse;
import org.DS.gerryproject.SmartFarmingGRPC.sprinklerResponse;
import org.DS.gerryproject.SmartFarmingGRPC.stringRequest;
import org.DS.gerryproject.SmartFarmingGRPC.stringResponse;
import org.DS.gerryproject.SmartFarmingGRPC.valueRequest;
import org.DS.gerryproject.SmartFarmingGRPC.valueResponse;

import io.grpc.stub.StreamObserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import Models.Sprinkler;

public class SprinklerServer extends SprinklerServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(HeatingServer.class.getName());
	public Sprinkler mySprinkler = new Sprinkler();
	public static int sprinklerPort;
	
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
			if (event.getName().equals("Sprinkler")) {
				System.out.println("Found Sprinkler port: " + event.getInfo().getPort());
				try {
					sprinklerPort = event.getInfo().getPort();
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
	}

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
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void startGRPC(int portNumber) throws IOException, InterruptedException {
		SprinklerServer sprinklerServer = new SprinklerServer();
		Server server = ServerBuilder.forPort(portNumber).addService(sprinklerServer).build().start();

		logger.info("SprinklerServer started, listening on " + portNumber);

		server.awaitTermination();
	}
	
	

	public void initialAppliance(Empty request, StreamObserver<sprinklerResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("Receiving initial appliance request for Sprinkler ");
		String status;
		
		if(mySprinkler.isOn()) {
			status = "On";
		}
		else {
			status = "Off";
		}
		String aName = mySprinkler.getApplianceName();
		String aStatus = status;
		Integer aIntensity = mySprinkler.getIntensity();
		Integer aRange = mySprinkler.getRange();
		
		sprinklerResponse response = sprinklerResponse.newBuilder().setAname(aName).setStatus(aStatus).setIntensity(aIntensity).setRange(aRange).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void changeIntensity(valueRequest request, StreamObserver<valueResponse> responseObserver) {
		// TODO Auto-generated method stub
		int currentIntensity= mySprinkler.getIntensity();
		int changeIntensity = request.getLength();
		
		System.out.println("Receiving new intensity for sprinkler" + currentIntensity);
		int newIntensity= currentIntensity + changeIntensity;
		if(newIntensity > 100 || newIntensity < 0 ) {//start if
			System.out.println("Intensity cannot exceed 100 or be less than 0: " + newIntensity);
			System.out.println("The current intensity is set to: " + mySprinkler.getIntensity());
			
			valueResponse response = valueResponse.newBuilder().setLength(mySprinkler.getIntensity()).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end if
		else {//start else
			mySprinkler.setIntensity(newIntensity);
			System.out.println("The updated intensity level is: " + newIntensity);		
			valueResponse response = valueResponse.newBuilder().setLength(newIntensity).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end else
		
	}

	@Override
	public void changeRange(valueRequest request, StreamObserver<valueResponse> responseObserver) {
		// TODO Auto-generated method stub
		int currentRange= mySprinkler.getRange();
		int changeRange = request.getLength();
		
		System.out.println("Receiving new range for sprinkler" + currentRange);
		int newRange= currentRange + changeRange;
		if(newRange > 80 || newRange < 1 ) {//start if
			System.out.println("Range cannot exceed 80 or be less than 1: " + newRange);
			System.out.println("The current range is set to: " + mySprinkler.getRange());
			
			valueResponse response = valueResponse.newBuilder().setLength(mySprinkler.getRange()).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end if
		else {//start else
			mySprinkler.setRange(newRange);
			System.out.println("The updated range is: " + newRange);		
			valueResponse response = valueResponse.newBuilder().setLength(newRange).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end else
		
	}

	@Override
	public void onOff(booleanRequest request, StreamObserver<booleanResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("Receiving information about On/Off for Sprinkler");
		Boolean onOff = request.getMsg();
		mySprinkler.setOn(onOff);
		
		//print out
		booleanResponse response = booleanResponse.newBuilder().setMsg(onOff).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void changeApplianceName(stringRequest request, StreamObserver<stringResponse> responseObserver) {
		// TODO Auto-generated method stub
		String name = request.getText();
		System.out.println("Changing sprinkler name to "+name);

		mySprinkler.setApplianceName(name);
		 
		stringResponse response = stringResponse.newBuilder().setText(name).build();
		System.out.println("Response "+response.getText());
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}


}
