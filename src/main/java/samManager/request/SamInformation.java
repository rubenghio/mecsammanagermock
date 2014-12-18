package samManager.request;

import java.util.HashMap;
import java.util.Map;


public class SamInformation {

	private Map<Integer, Long> emisores = new HashMap<Integer, Long>();
	private long operations;
	
	public Map<Integer, Long> getEmisores() {
		return emisores;
	}
	public void setEmisores(Map<Integer, Long> emisores) {
		this.emisores = emisores;
	}
	public long getOperations() {
		return operations;
	}
	public void setOperations(long operations) {
		this.operations = operations;
	}
}
