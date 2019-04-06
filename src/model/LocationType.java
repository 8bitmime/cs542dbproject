package model;

public class LocationType {
	private int id;
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocationType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

}
