package model;

import java.sql.Timestamp;

public class Staff {
	private int staffID;
	private String name;
	private int badgeID;
	private Timestamp dateofBirth;
	
	public Staff(int staffID, String name, int badgeID, Timestamp dateofBirth) {
		this.staffID = staffID;
		this.name = name;
		this.badgeID = badgeID;
		this.dateofBirth = dateofBirth;
	}
	
	public Staff(String name, int badgeID) {
		this.name = name;
		this.badgeID = badgeID;
	}
	
	public Staff(String name, int badgeID, Timestamp dateofBirth) {

		this.name = name;
		this.badgeID = badgeID;
		this.dateofBirth = dateofBirth;
	}
	
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBadgeID() {
		return badgeID;
	}
	public void setBadgeID(int badgeID) {
		this.badgeID = badgeID;
	}
	public Timestamp getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Timestamp dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Override
	public String toString() {
		return  staffID+","+name.replaceAll("\\s+","") + ","+ badgeID + "," + dateofBirth;
	}
	
	
}
