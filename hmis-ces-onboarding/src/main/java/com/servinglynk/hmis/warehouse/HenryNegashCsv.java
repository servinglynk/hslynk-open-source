package com.servinglynk.hmis.warehouse;

import org.apache.commons.lang3.StringUtils;

import com.googlecode.jcsv.annotations.MapToColumn;

public class HenryNegashCsv {

	@MapToColumn(column=0)
	private String sourceSystemId;
	@MapToColumn(column=1)
	private String firstName;
	@MapToColumn(column=2)
	private String lastName;
	@MapToColumn(column=3)
	private String contactDate;
	@MapToColumn(column=4)
	private String time;
	@MapToColumn(column=5)
	private String serviceCategory;
	@MapToColumn(column=6)
	private String serviceValue;
	@MapToColumn(column=7)
	private String internalExtertnal;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		this.firstName = firstName != null ? firstName.replaceAll("\"", "").trim().toLowerCase() : firstName;
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		this.lastName = lastName != null ? lastName.replaceAll("\"", "").trim().toLowerCase() : lastName;
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the contactDate
	 */
	public String getContactDate() {
		return contactDate;
	}
	/**
	 * @param contactDate the contactDate to set
	 */
	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
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
	 * @return the serviceCategory
	 */
	public String getServiceCategory() {
		this.serviceCategory = StringUtils.isNotBlank(serviceCategory) ? serviceCategory.replace(" ", "").trim() : serviceCategory;
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
		this.serviceValue = StringUtils.isNotBlank(serviceValue) ? serviceValue.replace(" ", "").trim() : serviceValue;
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
		this.internalExtertnal = StringUtils.isNotBlank(internalExtertnal) ? internalExtertnal.replace(" ", "").trim() : internalExtertnal;
		return internalExtertnal;
	}
	/**
	 * @param internalExtertnal the internalExtertnal to set
	 */
	public void setInternalExtertnal(String internalExtertnal) {
		this.internalExtertnal = internalExtertnal;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
