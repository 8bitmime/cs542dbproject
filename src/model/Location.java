package model;

public class Location {
	private int locationID;
	private int roomNumber;
	private int streetNumber;
	private String streetName;
	private String type;
	private String name;
	
	public Location(){
		
	}
	public Location(int locationID, int roomNumber, int streetNumber, String streetName, String type,
			String name) {
		this.locationID = locationID;
		this.roomNumber = roomNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.type = type;
		this.name = name;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
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
