package model;

public class ReceivingService {
	private int id;
	private String name;
	
	public ReceivingService(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public ReceivingService(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
