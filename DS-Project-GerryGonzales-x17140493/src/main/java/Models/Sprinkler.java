package Models;

public class Sprinkler {
	private String appliance, applianceName;
	private boolean on;
	private int intensity;
	private int range;
	
	public Sprinkler() {
		this.appliance = "Sprinkler";
		this.on = true;
		this.applianceName = "Sprinkler Name";
		this.intensity = 50;
		this.range = 5;
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

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
	

}
