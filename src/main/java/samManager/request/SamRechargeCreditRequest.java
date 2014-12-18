package samManager.request;
//imports ---------------------------------------------------------------------------
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.codehaus.jackson.annotate.JsonIgnore;
//-----------------------------------------------------------------------------------

//Clase correspondiente al mapeo de la Entidad MOISES.SAM.RECHARGE_CREDIT_REQUEST
public class SamRechargeCreditRequest {
	private Long id;
	private String serialNumber;
	private long amount;
	private long ltc;
	private int issuerId;
	private int applicationId;
	@JsonIgnore
	private String apdu;
	@JsonIgnore
	private Date insertionDate;
	@JsonIgnore
	private Date generationDate;
	@JsonIgnore
	private Integer status;
	
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.APPLICATION_ID
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.APDU
	public String getApdu() {
		return apdu;
	}
	public void setApdu(String apdu) {
		this.apdu = apdu;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.INSERTION_DATE
	public Date getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.GENERATION_DATE
	public Date getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.STATUS
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.ID
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.SERIAL_NUMBER
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.AMOUNT
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.LTC
	public long getLtc() {
		return ltc;
	}
	public void setLtc(long ltc) {
		this.ltc = ltc;
	}
	// MOISES.SAM_RECHARGE_CREDIT_REQUEST.ISSUER_ID
	public int getIssuerId() {
		return issuerId;
	}
	public void setIssuerId(int issuerId) {
		this.issuerId = issuerId;
	}
	
	// Mapea a la Clase: SAM
	//-----------------------------------------------------------------------------------
	
	// Valor de la fecha en el momento del insert
	@PrePersist
	protected void onCreate() {
		this.insertionDate = new Date();
	}
	// Valor de la fecha en el momento del update
	@PreUpdate
	protected void onUpdate() {
		this.generationDate = new Date();
	}
}