package model;

public class ReceivingHospital {
	private int hospitalID;
	private String hospitalName;
	private Location hospitalAddress;
	
	public ReceivingHospital(int hospitalID, String hospitalName,
			Location hospitalAddress) {
		this.hospitalID = hospitalID;
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
	}
	
	public ReceivingHospital(String hospitalName,
			Location hospitalAddress) {
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
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

	public Location getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(Location hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	
}
