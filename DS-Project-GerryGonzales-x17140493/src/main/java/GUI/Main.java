package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import GRPC.LightServer;
import GRPC.HeatingServer;
import GRPC.SprinklerServer;
import Models.Light;
import Models.Heating;
import Models.Sprinkler;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import org.DS.gerryproject.SmartFarmingGRPC.*;

import io.grpc.stub.StreamObserver;
import jmDNS.Registering;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import java.awt.Color;


public class Main {
	
	private JFrame frame;
	private JTextField appliance_name_text;
	private JTextField appliance_onOff_text;
	private JTextField appliance_extra_op_text;
	private JTextField appliance_extra_op2_text;
	
	private static SprinklerServiceGrpc.SprinklerServiceBlockingStub sprinkler_blockingStub;
	private static SprinklerServiceGrpc.SprinklerServiceStub sprinkler_asyncStub;
	private static SprinklerServiceGrpc.SprinklerServiceFutureStub sprinkler_futureStub;
	
	private static LightServiceGrpc.LightServiceBlockingStub light_blockingStub;
	private static LightServiceGrpc.LightServiceStub light_asyncStub;
	private static LightServiceGrpc.LightServiceFutureStub light_futureStub;
	
	private static HeatingServiceGrpc.HeatingServiceBlockingStub heating_blockingStub;
	private static HeatingServiceGrpc.HeatingServiceStub heating_asyncStub;
	private static HeatingServiceGrpc.HeatingServiceFutureStub heating_futureStub;
	
	private static SecuritycameraServiceGrpc.SecuritycameraServiceBlockingStub securitycamera_blockingStub;
	private static SecuritycameraServiceGrpc.SecuritycameraServiceStub securitycamera_asyncStub;
	private static SecuritycameraServiceGrpc.SecuritycameraServiceFutureStub securitycamera_futureStub;
	
	private JTextField sprinklerName_tf;
	private JTextField heatingName_tf;
	private JTextField camName_tf;
	private JTextField lightName_tf;
	
	public JLabel sprinklerInfo_name;
	public JLabel sprinklerInfo_status;
	public JLabel sprinklerInfo_intensity;
	public JLabel sprinklerInfo_range;
	
	public JLabel lightInfo_name;
	public JLabel lightInfo_status;
	public JLabel lightInfo_brightness;
	
	public JLabel camInfo_name;
	public JLabel camInfo_status;
	public JLabel camInfo_intensity;
	public JLabel camInfo_camera;
	
	public JLabel heatingInfo_name;
	public JLabel heatingInfo_status;
	public JLabel heatingInfo_temperature;
	public JLabel heatingInfo_speed;
	
	int heatingPort =8080;
	int sprinklerPort =8081;
	int lightPort =8082;
	int camPort =8083;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() throws InterruptedException, IOException {
		initialize();
		Registering r = new Registering();
		//Start Appliance Registry, GRPC servers and channels then unregister
		r.jmndsRegister(heatingPort, sprinklerPort, lightPort, camPort);
		startGRPCServers();
		channels();
		r.unRegister();
		loadInitialAppliances();
	}
	
	public void startGRPCServers() throws IOException, InterruptedException {
		SprinklerServer.startDiscovery();
		LightServer.startDiscovery();
		HeatingServer.startDiscovery();

	}
	public void loadInitialAppliances() throws IOException, InterruptedException {
		initialHeating();
		initialSprinkler();
		initialLight();
	}
	
	public void channels() {
		
		System.out.println("CHANNELS STARTING");
		ManagedChannel sprinklerChannel = ManagedChannelBuilder.forAddress("localhost",sprinklerPort).usePlaintext().build();
		ManagedChannel lightChannel = ManagedChannelBuilder.forAddress("localhost", lightPort).usePlaintext().build();
		ManagedChannel heatingChannel = ManagedChannelBuilder.forAddress("localhost", heatingPort).usePlaintext().build();
		ManagedChannel camChannel = ManagedChannelBuilder.forAddress("localhost", camPort).usePlaintext().build();

		sprinkler_blockingStub = SprinklerServiceGrpc.newBlockingStub(sprinklerChannel);
		sprinkler_asyncStub = SprinklerServiceGrpc.newStub(sprinklerChannel);
		sprinkler_futureStub = SprinklerServiceGrpc.newFutureStub(sprinklerChannel);
		
		light_blockingStub = LightServiceGrpc.newBlockingStub(lightChannel);
		light_asyncStub = LightServiceGrpc.newStub(lightChannel);
		light_futureStub = LightServiceGrpc.newFutureStub(lightChannel);
		
		heating_blockingStub = HeatingServiceGrpc.newBlockingStub(heatingChannel);
		heating_asyncStub = HeatingServiceGrpc.newStub(heatingChannel);
		heating_futureStub = HeatingServiceGrpc.newFutureStub(heatingChannel);
		
		securitycamera_blockingStub = SecuritycameraServiceGrpc.newBlockingStub(camChannel);
		securitycamera_asyncStub = SecuritycameraServiceGrpc.newStub(camChannel);
		securitycamera_futureStub = SecuritycameraServiceGrpc.newFutureStub(camChannel);

	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.Green);
		frame.setBounds(100, 100, 468, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		/*Heading Label*/
		JLabel headLabel = new JLabel("Smart Farming");
		headLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		headLabel.setBounds(101, 11, 245, 14);
		frame.getContentPane().add(headLabel);
		
		JLabel controller_lbl = new JLabel("Appliance Controls");
		controller_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		controller_lbl.setBounds(10, 64, 143, 14);
		frame.getContentPane().add(controller_lbl);
		
		JLabel appliance_name_lbl = new JLabel("Appliance Name");
		appliance_name_lbl.setBounds(56, 89, 83, 14);
		frame.getContentPane().add(appliance_name_lbl);
		
		JLabel intensity_lbl = new JLabel("Intensity");
		intensity_lbl.setBounds(275, 90, 48, 14);
		frame.getContentPane().add(intensity_lbl);
		
		JLabel lblChannel = new JLabel("Range");
		lblChannel.setBounds(370, 90, 48, 14);
		frame.getContentPane().add(lblChannel);
		
		JLabel appliance_name2_lblabel = new JLabel("Appliance Name");
		appliance_name2_lblabel.setBounds(56, 135, 83, 14);
		frame.getContentPane().add(appliance_name2_lblabel);
		
		JLabel appliance_status2_lbl = new JLabel("Appliance Status");
		appliance_status2_lbl.setBounds(170, 135, 83, 14);
		frame.getContentPane().add(appliance_status2_lbl);
		
		JLabel temperature_lbl = new JLabel("Temperature");
		temperature_lbl.setBounds(270, 135, 48, 14);
		frame.getContentPane().add(temperature_lbl);
		
		JLabel speed_lbl = new JLabel("Speed");
		speed_lbl.setBounds(370, 135, 38, 14);
		frame.getContentPane().add(speed_lbl);
		
		JLabel appliance_name3_lbl = new JLabel("Appliance Name");
		appliance_name3_lbl.setBounds(56, 180, 83, 14);
		frame.getContentPane().add(appliance_name3_lbl);
		
		JLabel intensity_2_lbl = new JLabel("Intensity");
		intensity_2_lbl.setBounds(270, 180, 48, 14);
		frame.getContentPane().add(intensity_2_lbl);
		
		JLabel lblCamera = new JLabel("Camera");
		lblCamera.setBounds(355, 180, 63, 14);
		frame.getContentPane().add(lblCamera);
		
		JLabel appliance_status3_lbl = new JLabel("Appliance Status");
		appliance_status3_lbl.setBounds(170, 180, 83, 14);
		frame.getContentPane().add(appliance_status3_lbl);
		
		JLabel appliance_name4_lbl = new JLabel("Appliance Name");
		appliance_name4_lbl.setBounds(56, 225, 83, 14);
		frame.getContentPane().add(appliance_name4_lbl);
		
		JLabel appliance_status4_lbl = new JLabel("Appliance Status");
		appliance_status4_lbl.setBounds(170, 225, 83, 14);
		frame.getContentPane().add(appliance_status4_lbl);
		
		JLabel lblBrigtness = new JLabel("Brightness");
		lblBrigtness.setBounds(254, 225, 72, 14);
		frame.getContentPane().add(lblBrigtness);
		
		//////////////////////
		//Sprinkler Intensity Buttons
		//////////////////////
		JButton sprinkler_intensityUp_btn = new JButton("+");
		sprinkler_intensityUp_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		sprinkler_intensityUp_btn.setBounds(290, 104, 38, 20);
		frame.getContentPane().add(sprinkler_intensityUp_btn);
		sprinkler_intensityUp_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println(+1);
			changeIntensity(1,"Sprinkler");
		}
		});

		JButton sprinkler_intensityDown_btn = new JButton("-");
		sprinkler_intensityDown_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		sprinkler_intensityDown_btn.setBounds(254, 104, 38, 20);
		frame.getContentPane().add(sprinkler_intensityDown_btn);
		sprinkler_intensityDown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		    	System.out.println(-1);
		    	changeIntensity(-1,"Sprinkler");
			}
		});
		
		//////////////////////
		//Heating Temperature Buttons
		//////////////////////
		JButton heating_temperatureDown_btn = new JButton("-");
		heating_temperatureDown_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		heating_temperatureDown_btn.setBounds(254, 149, 38, 20);
		frame.getContentPane().add(heating_temperatureDown_btn);
		heating_temperatureDown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		    	System.out.println(-1);
		    	changeTemperature(-1);
			}
		});
		
		JButton heating_temperatureUp_btn = new JButton("+");
		heating_temperatureUp_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		heating_temperatureUp_btn.setBounds(290, 149, 38, 20);
		frame.getContentPane().add(heating_temperatureUp_btn);
		heating_temperatureUp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(+1);
		    	changeTemperature(1);}
		});
		
		//////////////////////
		//Camera Intensity Buttons
		//////////////////////
		JButton camera_intensityUp_btn = new JButton("+");
		camera_intensityUp_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		camera_intensityUp_btn.setBounds(290, 194, 38, 20);
		frame.getContentPane().add(camera_intensityUp_btn);
		camera_intensityUp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(+1);
		    	changeIntensity(1,"Securitycamera");
		    	}
			
		});
		
		JButton camera_intensityDown_btn = new JButton("-");
		camera_intensityDown_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		camera_intensityDown_btn.setBounds(254, 194, 38, 20);
		frame.getContentPane().add(camera_intensityDown_btn);
		camera_intensityDown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(-1);
		    	changeIntensity(-1,"Securitycamera");
		    	}
			
		});
		
		/////////////
		//Text Fields
		/////////////
		sprinklerName_tf = new JTextField();
		sprinklerName_tf.setBounds(56, 105, 86, 20);
		frame.getContentPane().add(sprinklerName_tf);
		sprinklerName_tf.setColumns(10);
		sprinklerName_tf.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
					System.out.println("changedUpdate "+ sprinklerName_tf.getText());
				  }
				  public void removeUpdate(DocumentEvent e) {
					  changeApplianceName(sprinklerName_tf.getText(),"Sprinkler");
				  }
				  public void insertUpdate(DocumentEvent e) {
					  System.out.println("insertUpdate "+ sprinklerName_tf.getText());
					  changeApplianceName(sprinklerName_tf.getText(),"Sprinkler");

				  }

	
				});		
		
		heatingName_tf = new JTextField();
		heatingName_tf.setColumns(10);
		heatingName_tf.setBounds(56, 150, 86, 20);
		frame.getContentPane().add(heatingName_tf);
		heatingName_tf.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
					
				  }
				  public void removeUpdate(DocumentEvent e) {
					  changeApplianceName(heatingName_tf.getText(),"Heating");
				  }
				  public void insertUpdate(DocumentEvent e) {
				
					  changeApplianceName(heatingName_tf.getText(),"Heating");
				  }

	
				});	
		
		camName_tf = new JTextField();
		camName_tf.setColumns(10);
		camName_tf.setBounds(56, 194, 86, 20);
		frame.getContentPane().add(camName_tf);
		camName_tf.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
					
				  }
				  public void removeUpdate(DocumentEvent e) {
					  changeApplianceName(camName_tf.getText(),"Securitycamera");
				  }
				  public void insertUpdate(DocumentEvent e) {
					  System.out.println("insertUpdate "+camName_tf.getText());
					  changeApplianceName(camName_tf.getText(),"Securitycamera");
				  }

	
				});
		
		lightName_tf = new JTextField();
		lightName_tf.setColumns(10);
		lightName_tf.setBounds(56, 238, 86, 20);
		frame.getContentPane().add(lightName_tf);
		lightName_tf.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
					
				  }
				  public void removeUpdate(DocumentEvent e) {
					  changeApplianceName(lightName_tf.getText(),"Light");
				  }
				  public void insertUpdate(DocumentEvent e) {
					  changeApplianceName(lightName_tf.getText(),"Light");
				  }

	
				});
		
		/////////////////////////
		//Light Brightness Buttons
		/////////////////////////
		JButton light_brightnessDown_btn = new JButton("-");
		light_brightnessDown_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		light_brightnessDown_btn.setBounds(254, 240, 38, 20);
		frame.getContentPane().add(light_brightnessDown_btn);
		light_brightnessDown_btn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println(-1);
		    	changeBrightness(-1);
		    }
		});
		
		JButton light_brightnessUp_btn = new JButton("+");
		light_brightnessUp_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		light_brightnessUp_btn.setBounds(290, 240, 38, 20);
		frame.getContentPane().add(light_brightnessUp_btn);
		light_brightnessUp_btn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println(1);
		    	changeBrightness(1);
		    }
		});
		
		
		JLabel lblSprinkler = new JLabel("Sprinkler");
		lblSprinkler.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSprinkler.setBounds(4, 105, 36, 14);
		frame.getContentPane().add(lblSprinkler);
		
		JLabel lblHeating = new JLabel("Heating");
		lblHeating.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblHeating.setBounds(4, 155, 45, 14);
		frame.getContentPane().add(lblHeating);
		
		JLabel lblSecuritycamera = new JLabel("Cameras");
		lblSecuritycamera.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSecuritycamera.setBounds(4, 200, 56, 14);
		frame.getContentPane().add(lblSecuritycamera);
		
		JLabel lblLight = new JLabel("Light");
		lblLight.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLight.setBounds(4, 241, 45, 14);
		frame.getContentPane().add(lblLight);
		
		JLabel label = new JLabel("Sprinkler");
		label.setFont(new Font("Tahoma", Font.BOLD, 10));
		label.setBounds(10, 313, 36, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Heating");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_1.setBounds(10, 357, 45, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Cameras");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_2.setBounds(10, 402, 76, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Light");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_3.setBounds(10, 439, 45, 14);
		frame.getContentPane().add(label_3);
		
		JLabel lblApplianceStatus = new JLabel("Appliance Info");
		lblApplianceStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApplianceStatus.setBounds(10, 288, 143, 14);
		frame.getContentPane().add(lblApplianceStatus);
		
		
		final JToggleButton sprinklerOnOff_tgl = new JToggleButton("On");
		sprinklerOnOff_tgl.setSelected(true);
		sprinklerOnOff_tgl.setBounds(160, 104, 86, 20);
		frame.getContentPane().add(sprinklerOnOff_tgl);
		sprinklerOnOff_tgl.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent event) {
				if (sprinklerOnOff_tgl.isSelected()){
					 sprinklerOnOff_tgl.setText("On");
					 onOff(true,"Sprinkler");
	            } 
				 else {
	            	sprinklerOnOff_tgl.setText("Off");
					 onOff(false,"Sprinkler");
	            }
				
			}
	    });
		
		final JToggleButton heatingOnOff_tgl = new JToggleButton("On");
		heatingOnOff_tgl.setSelected(true);
		heatingOnOff_tgl.setBounds(160, 149, 86, 20);
		frame.getContentPane().add(heatingOnOff_tgl);
		heatingOnOff_tgl.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				 if (heatingOnOff_tgl.isSelected()){
					 heatingOnOff_tgl.setText("On");
					 onOff(true,"Heating");

	            } else {
	            	heatingOnOff_tgl.setText("Off");
	            	 onOff(false,"Heating");
	            }
				
			}
	    });
		
		final JToggleButton cameraOnOff_tgl = new JToggleButton("On");
		cameraOnOff_tgl.setSelected(true);
		cameraOnOff_tgl.setBounds(160, 194, 86, 20);
		frame.getContentPane().add(cameraOnOff_tgl);
		cameraOnOff_tgl.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				 if (cameraOnOff_tgl.isSelected()){
					 cameraOnOff_tgl.setText("On");
					 onOff(true,"Securitycamera");

	            } else {
	            	cameraOnOff_tgl.setText("Off");
					 onOff(false,"Securitycamera");

	            }
				
			}
	    });
		
		final JToggleButton lightOnOff_tgl = new JToggleButton("On");
		lightOnOff_tgl.setSelected(true);
		lightOnOff_tgl.setBounds(160, 240, 86, 20);
		frame.getContentPane().add(lightOnOff_tgl);
		lightOnOff_tgl.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				 if (lightOnOff_tgl.isSelected()){
					 lightOnOff_tgl.setText("On");
					 onOff(true,"Light");
	            } else {
	            	lightOnOff_tgl.setText("Off");
	            	onOff(false,"Light");
	            }
				
			}
	    });
		
		JButton heating_speedDown_btn = new JButton("-");
		heating_speedDown_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		heating_speedDown_btn.setBounds(345, 149, 38, 20);
		frame.getContentPane().add(heating_speedDown_btn);
		heating_speedDown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		    	System.out.println(-1);
		    	changeSpeed(-1);
			}
		});
		
		JButton heating_speedUp_btn = new JButton("+");
		heating_speedUp_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		heating_speedUp_btn.setBounds(381, 149, 38, 20);
		frame.getContentPane().add(heating_speedUp_btn);
		heating_speedUp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(+1);
		    	changeSpeed(1);}
		});
		
		JButton sprinklerRangeDown_btn = new JButton("-");
		sprinklerRangeDown_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		sprinklerRangeDown_btn.setBounds(355, 104, 38, 20);
		frame.getContentPane().add(sprinklerRangeDown_btn);
		sprinklerRangeDown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	System.out.println(1);
		    	changeRange(-1);
			}
		});
		
		JButton sprinklerRangeUp_btn = new JButton("+");
		sprinklerRangeUp_btn.setFont(new Font("Tahoma", Font.BOLD, 5));
		sprinklerRangeUp_btn.setBounds(391, 104, 38, 20);
		frame.getContentPane().add(sprinklerRangeUp_btn);
		sprinklerRangeUp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(+1);
				changeRange(1);
			}
		});
		
		String[] appNames = {"Select a Camera","Offices", "Garage", "Entrance", "Exit", "Roof", "Stairs" };
		JComboBox appList = new JComboBox(appNames);
		appList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		appList.setBounds(345, 194, 86, 20);
		frame.getContentPane().add(appList);
		appList.addActionListener(new ActionListener()  {
			
		    public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        String appName = (String)cb.getSelectedItem();
		        changeCamera(appName);	
}		
	});
		
		JLabel lblApplianceStatus_1 = new JLabel("Appliance Status");
		lblApplianceStatus_1.setBounds(170, 90, 83, 14);
		frame.getContentPane().add(lblApplianceStatus_1);
		
		heatingInfo_name = new JLabel("Appliance Name");
		heatingInfo_name.setBounds(10, 377, 111, 14);
		frame.getContentPane().add(heatingInfo_name);
		
		heatingInfo_status = new JLabel("Appliance Status");
		heatingInfo_status.setBounds(125, 377, 90, 14);
		frame.getContentPane().add(heatingInfo_status);
		
		heatingInfo_temperature = new JLabel("Intensity");
		heatingInfo_temperature.setBounds(220, 377, 90, 14);
		frame.getContentPane().add(heatingInfo_temperature);
		
		heatingInfo_speed = new JLabel("Speed");
		heatingInfo_speed.setBounds(320, 377, 38, 14);
		frame.getContentPane().add(heatingInfo_speed);
		
		sprinklerInfo_name= new JLabel("Appliance Name");
		sprinklerInfo_name.setBounds(10, 332, 111, 14);
		frame.getContentPane().add(sprinklerInfo_name);
		
		sprinklerInfo_status = new JLabel("Appliance Status");
		sprinklerInfo_status.setBounds(125,332, 90, 14);
		frame.getContentPane().add(sprinklerInfo_status);
		
		sprinklerInfo_intensity = new JLabel("Intensity");
		sprinklerInfo_intensity.setBounds(220, 332, 90, 14);
		frame.getContentPane().add(sprinklerInfo_intensity);
		
		sprinklerInfo_range = new JLabel("Range");
		sprinklerInfo_range.setBounds(320, 332, 98, 14);
		frame.getContentPane().add(sprinklerInfo_range);
		
		camInfo_name = new JLabel("Appliance Name");
		camInfo_name.setBounds(10, 418, 111, 14);
		frame.getContentPane().add(camInfo_name);
		
		camInfo_status = new JLabel("Appliance Status");
		camInfo_status.setBounds(125, 418, 83, 14);
		frame.getContentPane().add(camInfo_status);
		
		camInfo_intensity = new JLabel("Intensity");
		camInfo_intensity.setBounds(220, 418, 83, 14);
		frame.getContentPane().add(camInfo_intensity);
		
		camInfo_camera = new JLabel("Camera");
		camInfo_camera.setBounds(320, 418, 98, 14);
		frame.getContentPane().add(camInfo_camera);
		
		lightInfo_name = new JLabel("Appliance Name");
		lightInfo_name.setBounds(10, 458, 111, 14);
		frame.getContentPane().add(lightInfo_name);
		
		lightInfo_status = new JLabel("Appliance Status");
		lightInfo_status.setBounds(125, 458, 90, 14);
		frame.getContentPane().add(lightInfo_status);
		
		lightInfo_brightness = new JLabel("Brightness");
		lightInfo_brightness.setBounds(220, 458, 103, 14);
		frame.getContentPane().add(lightInfo_brightness);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 357, 432, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 402, 432, 2);
		frame.getContentPane().add(separator_1);
			
	}
		
	///////////////////
	//GRPC Methods
	///////////////////
	
	public void changeApplianceName(String newName, String appliance) {

		System.out.println("New Name "+ newName);
		System.out.println("Appliance "+ appliance);

		stringRequest req = stringRequest.newBuilder().setText(newName).build();
		System.out.println("Changing appliance Name");
		
		if(appliance.equals("Sprinkler")) {
			System.out.println("Appliance is a Sprinkler");
			stringRequest request = stringRequest.newBuilder().setText(newName).build();
			StreamObserver<stringResponse> responseObserver = new StreamObserver<stringResponse>() {

				@Override
				public void onNext(stringResponse value) {
					// TODO Auto-generated method stub
					System.out.println(" on next Sprinkler Response " + value.getText());
					sprinklerInfo_name.setText("Name: "+ value.getText());
				}
	
				@Override
				public void onError(Throwable t) {
					System.out.println("Error with name connection for sprinkler ");
				}
	
				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("On completed for sprinkler name");
				}
			
			};
			sprinkler_asyncStub.changeApplianceName(request,responseObserver);
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e){
				System.out.println("Connection Interrupted");

			}
		}
		
		else if(appliance.equals("Heating")) {
			System.out.println("Appliance is Heating");
			stringResponse response = heating_blockingStub.changeApplianceName(req);
				System.out.println("Heating Response "+response.getText());
		        heatingInfo_name.setText("Name: "+response.getText());

		}
		else if(appliance.equals("Light")) {
			System.out.println("Appliance is a Light");
			stringResponse response = light_blockingStub.changeApplianceName(req);
			System.out.println("Light Response "+response.getText());
	        lightInfo_name.setText("Name: "+response.getText());

		}
		else if(appliance.equals("Securitycamera")) {
			stringResponse response = securitycamera_blockingStub.changeApplianceName(req);
			System.out.println("Camera Response "+response.getText());
	        camInfo_name.setText("Name: "+response.getText());
		}
		
				
	}
	
	public void changeIntensity(int intensity, String appliance) {
		valueRequest req = valueRequest.newBuilder().setLength(intensity).build();
		System.out.println("Changing intensity");

		if(appliance.equals("Sprinkler")) {
			StreamObserver<valueResponse> response = new StreamObserver<valueResponse>() {
				
				@Override
				public void onNext(valueResponse value) {
					System.out.println("Receiving "+value);
					String vol = String.valueOf(value.getLength());
			        sprinklerInfo_intensity.setText("Intensity"+vol);
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Completed changing intensity");
				}
				
				
			};
			//Handle appliance to work with

			 sprinkler_asyncStub.changeIntensity(req, response);			
				System.out.println("Sprinkler response "+req.getLength());

		}else if(appliance.equals("Securitycamera")) {
			StreamObserver<valueResponse> response = new StreamObserver<valueResponse>() {
				
				@Override
				public void onNext(valueResponse value) {
					System.out.println("Receiving "+value);
					String vol = String.valueOf(value.getLength());
			        camInfo_intensity.setText("Intensity: "+vol);
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Completed changing intensity");
				}
				
				
			};
				securitycamera_asyncStub.changeVolume(req, response);
				System.out.println("Camera Response"+req.getLength());
		}

	}
	
	public void changeBrightness(int value) {
		valueRequest req = valueRequest.newBuilder().setLength(value).build();
		System.out.println("Changing Brightness");
		StreamObserver<valueResponse> response = new StreamObserver<valueResponse>() {

			@Override
			public void onNext(valueResponse value) {
				System.out.println("Receiving "+value);
				String brightness = String.valueOf(value.getLength());
		        lightInfo_brightness.setText("Brightness: "+brightness);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Completed changing brightness");
			}
			
		};
		light_asyncStub.changeBrightness(req, response);


	}
	
	public void changeRange(int value) {
		valueRequest req = valueRequest.newBuilder().setLength(value).build();
		System.out.println("Changing Range");
		
		Iterator<valueResponse> response;
		//Error Handling
		try {
			 response =sprinkler_blockingStub.changeRange(req);

		}catch(StatusRuntimeException e) {
			System.out.println("RPC failed: {0}"+ e.getStatus());
			return;
		}
		
		System.out.println("Sprinkler range response"+((DocumentEvent) response).getLength());
		String range = String.valueOf(((DocumentEvent) response).getLength());
        sprinklerInfo_range.setText("Range No: "+range);


	}
	
	public void changeTemperature(int temperature) {
		valueRequest req = valueRequest.newBuilder().setLength(temperature).build();
		System.out.println("Changing temperature");

			StreamObserver<valueResponse> response = new StreamObserver<valueResponse>() {
				
				@Override
				public void onNext(valueResponse value) {
					System.out.println("Receiving "+value);
					String temp = String.valueOf(value.getLength());
			        heatingInfo_temperature.setText("Temperature"+temp);
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Completed changing temperature");
				}
				
				
			};
			//Handle appliance to work with

			heating_asyncStub.changeTemperature(req, response);			
			System.out.println("Temperature response "+req.getLength());

	}

	public void changeCamera(String camera) {
		stringRequest req = stringRequest.newBuilder().setText(camera).build();
		System.out.println("Changing application to "+ req.getText());

			StreamObserver<stringResponse> response = new StreamObserver<stringResponse>() {
				
				@Override
				public void onNext(stringResponse str) {
					System.out.println("Receiving "+str);
					String cam = String.valueOf(str.getText());
			        camInfo_camera.setText("Camera"+cam);
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Completed changing camera");
				}
				
				
			};
			//Handle appliance to work with

			securitycamera_asyncStub.changeCamera(req, response);			
			System.out.println("Channel response "+req.getText());

	}
	
	
	/*public void changeCamera(String camera) {
		stringRequest req = stringRequest.newBuilder().setText(camera).build();
		System.out.println("Changing application to "+ req.getText());
		stringResponse response;
		
		
		//Error Handling
		try {
			 response = securitycamera_blockingStub.changeCamera(req);

		}catch(StatusRuntimeException e) {
			System.out.println("RPC failed: {0}"+ e.getStatus());
			return;
		}
		System.out.println("Camera response"+(response).getText());
		String cam = String.valueOf((response).getText());
        camInfo_camera.setText("Cam: "+cam);

	}*/
	
	public void changeSpeed(int speed) {
		valueRequest req = valueRequest.newBuilder().setLength(speed).build();
		System.out.println("Changing speed");

			StreamObserver<valueResponse> response = new StreamObserver<valueResponse>() {
				
				@Override
				public void onNext(valueResponse value) {
					System.out.println("Receiving "+value);
					String spd = String.valueOf(value.getLength());
			        heatingInfo_speed.setText("Speed"+spd);
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Completed changing speed");
				}
				
				
			};
			//Handle appliance to work with

			heating_asyncStub.changeFan(req, response);			
			System.out.println("Speed response "+req.getLength());

	}
	
	public void onOff(boolean onOff, String appliance) {
		booleanRequest req = booleanRequest.newBuilder().setMsg(onOff).build();
		System.out.println("On Off");

	//Handle appliance to work with
		if(appliance.equals("Sprinkler")) {
			booleanResponse response;
			//Error Handling
			try {
				 response  = sprinkler_blockingStub.onOff(req);

			}catch(StatusRuntimeException e) {
				System.out.println("RPC failed: {0}"+ e.getStatus());
				return;
			}
		
			System.out.println("Sprinkler response "+response.getMsg());
			Boolean status=	response.getMsg();
			if(status) {
				sprinklerInfo_status.setText("Status: On");
			}else {
				sprinklerInfo_status.setText("Status: Off");
			}
		}
		else if(appliance.equals("Heating")) {
			booleanResponse response;
			//Error Handling
			try {
				 response = heating_blockingStub.onOff(req);

			}catch(StatusRuntimeException e) {
				System.out.println("RPC failed: {0}"+ e.getStatus());
				return;
			}
				System.out.println("Heating Response "+response.getMsg());
				Boolean status=	response.getMsg();
				if(status) {
					heatingInfo_status.setText("Status: On");
				}else {
					heatingInfo_status.setText("Status: Off");
				}
		}
		else if(appliance.equals("Securitycamera")) {
			System.out.println("SecurityCamera Response ");

			booleanResponse response;
			//Error Handling
			try {
				 response = securitycamera_blockingStub.onOff(req);

			}catch(StatusRuntimeException e) {
				System.out.println("RPC failed: {0}"+ e.getStatus());
				return;
			}
			
			System.out.println("Cam Response "+response.getMsg());
			Boolean status=	response.getMsg();
			if(status) {
				camInfo_status.setText("Status: On");
			}else {
				camInfo_status.setText("Status: Off");
			}
		}
		else if(appliance.equals("Light")) {
			booleanResponse response;
			
			//Error Handling
			try {
				 response = light_blockingStub.onOff(req);

			}catch(StatusRuntimeException e) {
				System.out.println("RPC failed: {0}"+ e.getStatus());
				return;
			}
			
			System.out.println("Light Response "+response.getMsg());
			Boolean status=	response.getMsg();
			if(status) {
				lightInfo_status.setText("Status: On");
			}else {
				lightInfo_status.setText("Status: Off");
			}
		}
	}
	
	public void initialHeating() {
		Empty req = Empty.newBuilder().build();
		System.out.println("Initial Heating");
		heatingResponse response;
		//Error Handling
		try {
			 response = heating_blockingStub.initialAppliance(req);

		}catch(StatusRuntimeException e) {
			System.out.println("RPC failed: {0}"+ e.getStatus());
			return;
		}		
		heatingInfo_name.setText("Name: "+response.getAname());
		heatingInfo_status.setText("Status: "+response.getStatus());
		String temp = String.valueOf(response.getTemperature());
		heatingInfo_temperature.setText("Temperature: "+temp);

	}
	
	public void initialSprinkler() {
		Empty req = Empty.newBuilder().build();
		System.out.println("Initial Sprinkler");
		sprinklerResponse response;
		
		//Error Handling
		try {
			 response = sprinkler_blockingStub.initialAppliance(req);

		}catch(StatusRuntimeException e) {
			System.out.println("RPC failed: {0}"+ e.getStatus());
			return;
		}		
		sprinklerInfo_name.setText("Name: "+response.getAname());
		sprinklerInfo_status.setText("Status: "+response.getStatus());
		String intensity = String.valueOf(response.getIntensity());
		sprinklerInfo_intensity.setText("Intensity: "+intensity);
		String range = String.valueOf(response.getRange());
		sprinklerInfo_range.setText("Range: "+range);


	}
	
	public void initialLight() {
		Empty req = Empty.newBuilder().build();
		System.out.println("Initial Light");
		lightResponse response;
		//Error Handling
		try {
			 response = light_blockingStub.initialAppliance(req);

		}catch(StatusRuntimeException e) {
			System.out.println("RPC failed: {0}"+ e.getStatus());
			return;
		}		
		
		lightInfo_name.setText("Name: "+response.getAname());
		lightInfo_status.setText("Status: "+response.getStatus());
		String brightness = String.valueOf(response.getBrightness());
		lightInfo_brightness.setText("Brightness: "+ brightness);

	}
	
	public void initialCamera() {
		Empty req = Empty.newBuilder().build();
		System.out.println("Initial Camera");
		cameraResponse response;
		
		//Error Handling
		try {
			 response = securitycamera_blockingStub.initialAppliance(req);

		}catch(StatusRuntimeException e) {
			System.out.println("RPC failed: {0}"+ e.getStatus());
			return;
		}		
		
		camInfo_name.setText("Name: "+response.getAname());
		camInfo_status.setText("Status: "+response.getStatus());
		String volume = String.valueOf(response.getVolume());
		camInfo_camera.setText("App: "+ response.getCam());
		camInfo_intensity.setText("Intensity:"+volume);
	}
		

}//end main
