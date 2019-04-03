package model;

public class ReceivingHospital {
	private int hospitalID;
	private String hospitalName;
	private Location location;

	public ReceivingHospital(){
		
	}
	
	public int getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(int hospitalID) {
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

	public ReceivingHospital(int hospitalID, String hospitalName, Location location) {
		this.hospitalID = hospitalID;
		this.hospitalName = hospitalName;
		this.location = location;
	}
	
	public ReceivingHospital( String hospitalName, Location location) {
		this.hospitalName = hospitalName;
		this.location = location;
	}

}
