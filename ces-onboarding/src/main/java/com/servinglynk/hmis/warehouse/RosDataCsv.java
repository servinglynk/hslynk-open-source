package com.servinglynk.hmis.warehouse;

import org.apache.commons.lang3.StringUtils;

import com.googlecode.jcsv.annotations.MapToColumn;

public class RosDataCsv {


	@MapToColumn(column=0)
	private String sourceSystemId;
	@MapToColumn(column=1)
	private String name;
	@MapToColumn(column=2)
	private String contactDate;
	@MapToColumn(column=3)
	private String staffingAgent;
	@MapToColumn(column=4)
	private String serviceCategory;
	@MapToColumn(column=5)
	private String serviceValue;
	@MapToColumn(column=6)
	private String internalExtertnal;
	@MapToColumn(column=7)
	private String time;
	@MapToColumn(column=8)
	private String notes;
	/**
	 * @return the sourceSystemId
	 */
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	/**
	 * @param sourceSystemId the sourceSystemId to set
	 */
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		this.name = name != null ? name.replaceAll("\"", "").trim().toLowerCase() : name;
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the date
	 */
	public String getContactDate() {
		return contactDate;
	}
	/**
	 * @param date the date to set
	 */
	public void setContactDate(String date) {
		this.contactDate = date;
	}
	/**
	 * @return the staffingAgent
	 */
	public String getStaffingAgent() {
		this.staffingAgent= StringUtils.isNotBlank(staffingAgent) ? staffingAgent.replaceAll("\"", "").trim().toLowerCase() : staffingAgent;
		return staffingAgent;
	}
	/**
	 * @param staffingAgent the staffingAgent to set
	 */
	public void setStaffingAgent(String staffingAgent) {
		this.staffingAgent = staffingAgent;
	}
	/**
	 * @return the serviceCategory
	 */
	public String getServiceCategory() {
		this.serviceCategory = StringUtils.isNotBlank(serviceCategory) ? String.valueOf(serviceCategory.charAt(0)) : serviceCategory;
		return serviceCategory;
	}
	/**
	 * @param serviceCategory the serviceCategory to set
	 */
	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	/**
	 * @return the serviceValue
	 */
	public String getServiceValue() {
		this.serviceValue = StringUtils.isNotBlank(serviceValue) ? serviceValue.substring(0, 3).replace(" ", "").trim() : serviceValue;
		return serviceValue;
	}
	/**
	 * @param serviceValue the serviceValue to set
	 */
	public void setServiceValue(String serviceValue) {
		this.serviceValue = serviceValue;
	}
	/**
	 * @return the internalExtertnal
	 */
	public String getInternalExtertnal() {
		return internalExtertnal;
	}
	/**
	 * @param internalExtertnal the internalExtertnal to set
	 */
	public void setInternalExtertnal(String internalExtertnal) {
		this.internalExtertnal = internalExtertnal;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the Notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param Notes the Notes to set
	 */
	public void setNotes(String Notes) {
		this.notes = notes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RosDataCsv [sourceSystemId=" + sourceSystemId + ", name=" + name + ", contactDate=" + contactDate + ", staffingAgent="
				+ staffingAgent + ", serviceCategory=" + serviceCategory + ", serviceValue=" + serviceValue
				+ ", internalExtertnal=" + internalExtertnal + ", time=" + time + ", Notes=" + notes + "]";
	}
	
}

