package com.servinglynk.report.model;

public class DomesticViolenceModel extends BaseModel {
	
	private String domesticviolence_id;
	private String domesticviolencevictim; 
	private String project_entry_id;
	private String whenoccurred;
	private String currently_fleeing;
	private String source_system_id;
	private String date_created_from_source;
	public DomesticViolenceModel(String domesticviolence_id, String domesticviolencevictim, String project_entry_id,
			String whenoccurred, String currently_fleeing, String source_system_id, String date_created_from_source) {
		super();
		this.domesticviolence_id = domesticviolence_id;
		this.domesticviolencevictim = domesticviolencevictim;
		this.project_entry_id = project_entry_id;
		this.whenoccurred = whenoccurred;
		this.currently_fleeing = currently_fleeing;
		this.source_system_id = source_system_id;
		this.date_created_from_source = date_created_from_source;
	}
	/**
	 * @return the domesticviolence_id
	 */
	public String getDomesticviolence_id() {
		return domesticviolence_id;
	}
	/**
	 * @param domesticviolence_id the domesticviolence_id to set
	 */
	public void setDomesticviolence_id(String domesticviolence_id) {
		this.domesticviolence_id = domesticviolence_id;
	}
	/**
	 * @return the domesticviolencevictim
	 */
	public String getDomesticviolencevictim() {
		return domesticviolencevictim;
	}
	/**
	 * @param domesticviolencevictim the domesticviolencevictim to set
	 */
	public void setDomesticviolencevictim(String domesticviolencevictim) {
		this.domesticviolencevictim = domesticviolencevictim;
	}
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
	 * @return the whenoccurred
	 */
	public String getWhenoccurred() {
		return whenoccurred;
	}
	/**
	 * @param whenoccurred the whenoccurred to set
	 */
	public void setWhenoccurred(String whenoccurred) {
		this.whenoccurred = whenoccurred;
	}
	/**
	 * @return the currently_fleeing
	 */
	public String getCurrently_fleeing() {
		return currently_fleeing;
	}
	/**
	 * @param currently_fleeing the currently_fleeing to set
	 */
	public void setCurrently_fleeing(String currently_fleeing) {
		this.currently_fleeing = currently_fleeing;
	}
	/**
	 * @return the source_system_id
	 */
	public String getSource_system_id() {
		return source_system_id;
	}
	/**
	 * @param source_system_id the source_system_id to set
	 */
	public void setSource_system_id(String source_system_id) {
		this.source_system_id = source_system_id;
	}
	/**
	 * @return the date_created_from_source
	 */
	public String getDate_created_from_source() {
		return date_created_from_source;
	}
	/**
	 * @param date_created_from_source the date_created_from_source to set
	 */
	public void setDate_created_from_source(String date_created_from_source) {
		this.date_created_from_source = date_created_from_source;
	}

}
