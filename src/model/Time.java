
package model;

import java.sql.Timestamp;

public class Time {
	private Timestamp time;
	private String timeType;
	public Time(Timestamp time, String timeType) {
		super();
		this.time = time;
		this.timeType = timeType;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getTimeType() {
		return timeType;
	}
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	
}
