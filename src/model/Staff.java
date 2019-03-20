package model;

import java.sql.Timestamp;

public class Staff {
	private String staffID;
	private String name;
	private String badgeID;
	private Timestamp dateofBirth;
	
	public Staff(String staffID, String name, String badgeID, Timestamp dateofBirth) {
		super();
		this.staffID = staffID;
		this.name = name;
		this.badgeID = badgeID;
		this.dateofBirth = dateofBirth;
	}
	
	public Staff(String name, String badgeID) {
		this.name = name;
		this.badgeID = badgeID;
	}
	
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBadgeID() {
		return badgeID;
	}
	public void setBadgeID(String badgeID) {
		this.badgeID = badgeID;
	}
	public Timestamp getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Timestamp dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	
	
}
