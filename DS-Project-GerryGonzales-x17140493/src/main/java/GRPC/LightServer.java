package GRPC;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import org.DS.gerryproject.SmartFarmingGRPC.Empty;
import org.DS.gerryproject.SmartFarmingGRPC.LightServiceGrpc.LightServiceImplBase;
import org.DS.gerryproject.SmartFarmingGRPC.booleanRequest;
import org.DS.gerryproject.SmartFarmingGRPC.booleanResponse;
import org.DS.gerryproject.SmartFarmingGRPC.lightResponse;
import org.DS.gerryproject.SmartFarmingGRPC.stringRequest;
import org.DS.gerryproject.SmartFarmingGRPC.stringResponse;
import org.DS.gerryproject.SmartFarmingGRPC.valueRequest;
import org.DS.gerryproject.SmartFarmingGRPC.valueResponse;

import io.grpc.stub.StreamObserver;

import com.google.protobuf.Int32ValueOrBuilder;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import Models.Light;

public class LightServer extends LightServiceImplBase{
	private static final Logger logger = Logger.getLogger(LightServer.class.getName());
	public Light myLight = new Light();
	public static int lightPort;
	
	private static class SampleListener implements ServiceListener {
		 
        public void serviceAdded(ServiceEvent event) {
            System.out.println("Service added: " + event.getInfo());
        }

        
        public void serviceRemoved(ServiceEvent event) {
            System.out.println("Service removed: " + event.getInfo());
        }

        
        public void serviceResolved(ServiceEvent event) {
        	System.out.println("Service resolved: " + event.getInfo());
            System.out.println("Get Name: " + event.getName()+" PORT: "+event.getInfo().getPort());
            
            //Start GRPC server with discovered device
            if(event.getName().equals("Light")) {
            	System.out.println("Found Light port: " + event.getInfo().getPort());
	       		try {
	       			lightPort = event.getInfo().getPort();
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
	
	public static void main(String[] args) throws IOException, InterruptedException  {	 
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
	
	public int getLightPort() {
		return lightPort;
	}

	public void setLightPort(int lightPort) {
		LightServer.lightPort = lightPort;
	}
	
	public static void startGRPC(int portNumber) throws IOException, InterruptedException {
		LightServer lightServer = new LightServer();
		    
		Server server = ServerBuilder.forPort(portNumber).addService(lightServer).build().start();
		logger.info("LightServer started, listening on " + portNumber);		     
		server.awaitTermination();
	 }
	

	@Override
	public void initialAppliance(Empty request, StreamObserver<lightResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("Receiving initial appliance request for Lights");
		String status;
		
		if(myLight.isOn()) {
			  status ="On";
		}
		else {
			  status ="Off";

		}
		String aName = myLight.getApplianceName();
		String aStatus = status;
		Integer aBrightness = myLight.getBrightness();
		
		//print out
		lightResponse response = lightResponse.newBuilder().setAname(aName).setStatus(aStatus).setBrightness(aBrightness).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void changeBrightness(valueRequest request, StreamObserver<valueResponse> responseObserver) {//start changeBrightness method
		// TODO Auto-generated method stub
		int currentBrightness= myLight.getBrightness();
		int changeBrightness = request.getLength();
		
		System.out.println("Receiving new brightness for lights" + currentBrightness);
		int newBrightness = currentBrightness + changeBrightness;
		if(newBrightness > 100 || newBrightness < 0 ) {//start if
			System.out.println("Brightness cannot exceed 100 or be less than 0: " + newBrightness);
			System.out.println("The current brightness is set to: " + myLight.getBrightness());
			
			valueResponse response = valueResponse.newBuilder().setLength(myLight.getBrightness()).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end if
		else {//start else
			myLight.setBrightness(newBrightness);
			System.out.println("The updated brightness level is: " + newBrightness);		
			valueResponse response = valueResponse.newBuilder().setLength(newBrightness).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}//end else
		
	}//end changeBrightness method

	@Override
	public void onOff(booleanRequest request, StreamObserver<booleanResponse> responseObserver) {//start onOff method
		// TODO Auto-generated method stub
		System.out.println("Receiving information about On/Off for Lights");
		Boolean onOff = request.getMsg();
		myLight.setOn(onOff);
		
		//print out
		booleanResponse response = booleanResponse.newBuilder().setMsg(onOff).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}//end onOff method

	@Override
	public void changeApplianceName(stringRequest request, StreamObserver<stringResponse> responseObserver) {
		// TODO Auto-generated method stub
		String name = request.getText();
		System.out.println("Changing light name to "+name);

		myLight.setApplianceName(name);
		 
		stringResponse response = stringResponse.newBuilder().setText(name).build();
		System.out.println("Response "+response.getText());
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	

}
