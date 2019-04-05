
package model;

import java.sql.Timestamp;

public class TTime {
	
	private Timestamp time;
	private String timeType;
	
	public TTime(Timestamp time, String timeType) {
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
