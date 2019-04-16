package model;

import java.util.List;

public class Call {
	private int callID;
	private String reported;
	private String actural;
	private Outcome outcome;
	private List<TTime> timeList;
	private List<Staff> staffList;
	private Location location;

	public Call(int callID, String reported, String actural,
			Outcome outcome, List<TTime> timeList, List<Staff> staffList,
			Location location) {
		this.callID = callID;
		this.reported = reported;
		this.actural = actural;
		this.outcome = outcome;
		this.timeList = timeList;
		this.staffList = staffList;
		this.location = location;
	}

	public Call(String reported, String actural, Outcome outcome,
			List<TTime> timeList, List<Staff> staffList, Location location) {

		this.reported = reported;
		this.actural = actural;
		this.outcome = outcome;
		this.timeList = timeList;
		this.staffList = staffList;
		this.location = location;
	}

	public int getCallID() {
		return callID;
	}

	public void setCallID(int callID) {
		this.callID = callID;
	}

	public String getReported() {
		return reported;
	}

	public void setReported(String reported) {
		this.reported = reported;
	}

	public String getActural() {
		return actural;
	}

	public void setActural(String actural) {
		this.actural = actural;
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public List<TTime> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<TTime> timeList) {
		this.timeList = timeList;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}