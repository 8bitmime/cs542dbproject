package model;

public class Outcome {
	private int outcomeID;
	private String result;
	private ReceivingService receivingService;
	private ReceivingHospital recvHosptial;

	public Outcome(int outcomeID, String result,
			ReceivingService receivingService, ReceivingHospital recvHosptial) {
		this.outcomeID = outcomeID;
		this.result = result;
		this.receivingService = receivingService;
		this.recvHosptial = recvHosptial;
	}

	public Outcome(String result, ReceivingService receivingService,
			ReceivingHospital recvHosptial) {

		this.result = result;
		this.receivingService = receivingService;
		this.recvHosptial = recvHosptial;
	}

	public int getOutcomeID() {
		return outcomeID;
	}

	public void setOutcomeID(int outcomeID) {
		this.outcomeID = outcomeID;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ReceivingService getReceivingService() {
		return receivingService;
	}

	public void setReceivingService(ReceivingService receivingService) {
		this.receivingService = receivingService;
	}

	public ReceivingHospital getRecvHosptial() {
		return recvHosptial;
	}

	public void setRecvHosptial(ReceivingHospital recvHosptial) {
		this.recvHosptial = recvHosptial;
	}

}
