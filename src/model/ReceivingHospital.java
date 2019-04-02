package model;

public class ReceivingHospital {
	private String hospitalID;
	private String hospitalName;
	private Location location;

	public String getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ReceivingHospital(String hospitalID, String hospitalName, Location location) {
		this.hospitalID = hospitalID;
		this.hospitalName = hospitalName;
		this.location = location;
	}
	
	public ReceivingHospital( String hospitalName, Location location) {
		this.hospitalName = hospitalName;
		this.location = location;
	}

}
