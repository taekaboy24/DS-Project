package Models;

public class Light {
	private String appliance, applianceName;
	private boolean on;
	private int brightness;
	
	public Light() {
		this.appliance="Light";
		this.on=true;
		this.applianceName="Light Name";
		this.brightness=30;
	}

	public String getAppliance() {
		return appliance;
	}

	public void setAppliance(String appliance) {
		this.appliance = appliance;
	}

	public String getApplianceName() {
		return applianceName;
	}

	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}
	
	
}
