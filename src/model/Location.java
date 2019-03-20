package model;

public class Location {
	private String locationID;
	private String roomNumber;
	private String streetNumber;
	private String streetName;
	private String type;
	private String name;
	public Location(String locationID, String roomNumber, String streetNumber, String streetName, String type,
			String name) {
		this.locationID = locationID;
		this.roomNumber = roomNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.type = type;
		this.name = name;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	
}
