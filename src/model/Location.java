package model;

public class Location {
	private int locationID;
	private String type;
	private String name;
	private String address;

	public Location(int locationID, String type, String name,
			String address) {
		this.locationID = locationID;
		this.type = type;
		this.name = name;
		this.address = address;
	}
	
	public Location(String type, String name,
			String address) {
		this.type = type;
		this.name = name;
		this.address = address;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
