package com.servinglynk.report.model;

import java.util.Date;

public class ContactModel extends BaseModel{
	
public ContactModel() {}

	public ContactModel(String contactId, String enrollmentId, Date contactDate, String contactLocation,String sourceSystemId) {
	
	super();
	this.contactId = contactId;
	this.enrollmentId = enrollmentId;
	this.contactDate = contactDate;
	this.contactLocation = contactLocation;
	this.sourceSystemId = sourceSystemId;
}


	private String contactId;
	private String enrollmentId;
	private Date contactDate;
	private String contactLocation;
	private String sourceSystemId;
	
	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the enrollmentId
	 */
	public String getEnrollmentId() {
		return enrollmentId;
	}
	/**
	 * @param enrollmentId the enrollmentId to set
	 */
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	/**
	 * @return the contactDate
	 */
	public Date getContactDate() {
		return contactDate;
	}
	/**
	 * @param contactDate the contactDate to set
	 */
	public void setContactDate(Date contactDate) {
		this.contactDate = contactDate;
	}
	/**
	 * @return the contactLocation
	 */
	public String getContactLocation() {
		return contactLocation;
	}
	/**
	 * @param contactLocation the contactLocation to set
	 */
	public void setContactLocation(String contactLocation) {
		this.contactLocation = contactLocation;
	}

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
	
}

