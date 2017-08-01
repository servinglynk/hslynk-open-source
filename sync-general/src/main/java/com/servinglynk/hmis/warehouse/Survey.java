package com.servinglynk.hmis.warehouse;

import java.sql.Date;
import java.util.UUID;

public class Survey {
	
	public Survey(String projectGroupCode, UUID surveyId, String surveyName,
			Date surveyDate) {
		super();
		this.projectGroupCode = projectGroupCode;
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.surveyDate = surveyDate;
	}
	private String projectGroupCode;
	private UUID surveyId;
	private String surveyName;
	private Date surveyDate;
	/**
	 * @return the projectGroupCode
	 */
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	/**
	 * @param projectGroupCode the projectGroupCode to set
	 */
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	/**
	 * @return the surveyId
	 */
	public UUID getSurveyId() {
		return surveyId;
	}
	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(UUID surveyId) {
		this.surveyId = surveyId;
	}
	/**
	 * @return the surveyName
	 */
	public String getSurveyName() {
		return surveyName;
	}
	/**
	 * @param surveyName the surveyName to set
	 */
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	/**
	 * @return the surveyDate
	 */
	public Date getSurveyDate() {
		return surveyDate;
	}
	/**
	 * @param surveyDate the surveyDate to set
	 */
	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}
	
	
}
