package com.servinglynk.report.model;

public class DisabilitiesModel extends BaseModel{

	public DisabilitiesModel(String dedupClientId, int disabilityCount) {
		super();
		this.dedupClientId = dedupClientId;
		this.disabilityCount = disabilityCount;
	}
	private String dedupClientId;
	private int disabilityCount;
	/**
	 * @return the project_entry_id
	 */
	public String getDedupClientId() {
		return dedupClientId;
	}
	/**
	 * @param project_entry_id the project_entry_id to set
	 */
	public void setDedupClientId(String project_entry_id) {
		this.dedupClientId = project_entry_id;
	}
	/**
	 * @return the disabilityCount
	 */
	public int getDisabilityCount() {
		return disabilityCount;
	}
	/**
	 * @param disabilityCount the disabilityCount to set
	 */
	public void setDisabilityCount(int disabilityCount) {
		this.disabilityCount = disabilityCount;
	}
	
}
