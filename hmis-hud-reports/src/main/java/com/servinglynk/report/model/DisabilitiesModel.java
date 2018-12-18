package com.servinglynk.report.model;

public class DisabilitiesModel extends BaseModel{

	public DisabilitiesModel(String project_entry_id, int disabilityCount) {
		super();
		this.project_entry_id = project_entry_id;
		this.disabilityCount = disabilityCount;
	}
	private String project_entry_id;
	private int disabilityCount;
	/**
	 * @return the project_entry_id
	 */
	public String getProject_entry_id() {
		return project_entry_id;
	}
	/**
	 * @param project_entry_id the project_entry_id to set
	 */
	public void setProject_entry_id(String project_entry_id) {
		this.project_entry_id = project_entry_id;
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
