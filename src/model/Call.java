package model;

import java.util.List;

public class Call {
	private int callID;
	private TypeofEvent reported;
	private TypeofEvent actural;
	private Outcome outcome;
	private List<TTime> timeList;
	private List<Staff> staffList;
	private Location location;

	public Call(int callID, TypeofEvent reported, TypeofEvent actural,
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

	public Call(TypeofEvent reported, TypeofEvent actural, Outcome outcome,
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

	public TypeofEvent getReported() {
		return reported;
	}

	public void setReported(TypeofEvent reported) {
		this.reported = reported;
	}

	public TypeofEvent getActural() {
		return actural;
	}

	public void setActural(TypeofEvent actural) {
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