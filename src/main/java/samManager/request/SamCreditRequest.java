package samManager.request;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.codehaus.jackson.annotate.JsonIgnore;


public class SamCreditRequest {

	private Long id;
	private String serialNumber;
	private long amount;
	private long ltc;
	private int issuerId;
	@JsonIgnore
	private String apdu;
	@JsonIgnore
	private Date insertionDate;
	@JsonIgnore
	private Date generationDate;

	private int commandCounter;
	private Integer status;

	public int getCommandCounter() {
		return commandCounter;
	}

	public void setCommandCounter(int commandCounter) {
		this.commandCounter = commandCounter;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getApdu() {
		return apdu;
	}

	public void setApdu(String apdu) {
		this.apdu = apdu;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getLtc() {
		return ltc;
	}

	public void setLtc(long ltc) {
		this.ltc = ltc;
	}

	public int getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(int issuerId) {
		this.issuerId = issuerId;
	}

	@PrePersist
	protected void onCreate() {
		this.insertionDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.generationDate = new Date();
	}
}
