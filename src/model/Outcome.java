package model;

public class Outcome {
	private String outcomeID;
	private String result;
	private String receivingService;
	private RecievingHospital recvHosptial;

	public Outcome(String outcomeID, String result, String receivingService,RecievingHospital recvHosptial) {
		this.outcomeID = outcomeID;
		this.result = result;
		this.receivingService = receivingService;
		this.recvHosptial = recvHosptial;
	}

	public RecievingHospital getRecvHosptial() {
		return recvHosptial;
	}

	public void setRecvHosptial(RecievingHospital recvHosptial) {
		this.recvHosptial = recvHosptial;
	}

	public Outcome(String result, String receivingService,RecievingHospital recvHosptial) {
		this.result = result;
		this.receivingService = receivingService;
		this.recvHosptial = recvHosptial;
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
