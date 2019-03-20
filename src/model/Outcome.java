package model;

public class Outcome {
	private String outcomeID;
	private String result;
	private String receivingService;

	public Outcome(String outcomeID, String result, String receivingService) {
		this.outcomeID = outcomeID;
		this.result = result;
		this.receivingService = receivingService;
	}

	public Outcome(String result, String receivingService) {
		this.result = result;
		this.receivingService = receivingService;
	}

	public String getOutcomeID() {
		return outcomeID;
	}

	public void setOutcomeID(String outcomeID) {
		this.outcomeID = outcomeID;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getReceivingService() {
		return receivingService;
	}

	public void setReceivingService(String receivingService) {
		this.receivingService = receivingService;
	}

}
