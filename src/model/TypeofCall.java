package model;

public class TypeofCall {
	private int callID;
	private String reported;
	private String actural;
	private Outcome outcome;
	
	public TypeofCall(){
		
	}
	
	public TypeofCall(int callID, String reported, String actural, Outcome outcome) {
		this.callID = callID;
		this.reported = reported;
		this.actural = actural;
		this.outcome = outcome;
	}
	
	public TypeofCall(String reported, String actural, Outcome outcome) {
		this.reported = reported;
		this.actural = actural;
		this.outcome = outcome;
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

}
