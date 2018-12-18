package com.servinglynk.report.model;

import java.util.Date;

public class DateOfEngagementModel extends BaseModel {
	
	
	private String dateOfEngagementId;
	private String enrollmentId;
	private Date dateOfEngagement;
	private String sourceSystemId;
	
	public DateOfEngagementModel(String dateOfEngagementId, String enrollmentId, Date dateOfEngagement, String sourceSystemId) {
		super();
		this.dateOfEngagementId = dateOfEngagementId;
		this.enrollmentId = enrollmentId;
		this.dateOfEngagement = dateOfEngagement;
		this.sourceSystemId = sourceSystemId;
	}
	/**
	 * @return the dateOfEngagementId
	 */
	public String getDateOfEngagementId() {
		return dateOfEngagementId;
	}
	/**
	 * @param dateOfEngagementId the dateOfEngagementId to set
	 */
	public void setDateOfEngagementId(String dateOfEngagementId) {
		this.dateOfEngagementId = dateOfEngagementId;
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
	 * @return the dateOfEngagement
	 */
	public Date getDateOfEngagement() {
		return dateOfEngagement;
	}
	/**
	 * @param dateOfEngagement the dateOfEngagement to set
	 */
	public void setDateOfEngagement(Date dateOfEngagement) {
		this.dateOfEngagement = dateOfEngagement;
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
