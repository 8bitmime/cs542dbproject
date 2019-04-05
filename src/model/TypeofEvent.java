package model;

public class TypeofEvent {
	private int id;
	private String eventName;

	public TypeofEvent(int id, String eventName) {
		this.id = id;
		this.eventName = eventName;
	}

	public TypeofEvent(String eventName) {
		this.eventName = eventName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
