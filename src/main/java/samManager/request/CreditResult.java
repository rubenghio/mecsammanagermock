package samManager.request;

public class CreditResult {
	private Long transactionId;
	private Integer status;
	private int commandCounter;
	private String apdu;
	
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public int getCommandCounter() {
		return commandCounter;
	}
	public void setCommandCounter(int commandCounter) {
		this.commandCounter = commandCounter;
	}
	public String getApdu() {
		return apdu;
	}
	public void setApdu(String apdu) {
		this.apdu = apdu;
	}
}
