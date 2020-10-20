package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("clientsurveysubmission")
public class ClientSurveySubmission {


	private UUID id;
	private UUID clientId;
	private UUID surveyId; 
	private UUID submissionId;
   	private UUID globalEnrollmentId;
	private UUID globalProjectId;
	private String hmisLink;
   	private String hmisPostingStatus;
   	private String surveyCategory;
   	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public UUID getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(UUID surveyId) {
		this.surveyId = surveyId;
	}
	public UUID getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(UUID submissionId) {
		this.submissionId = submissionId;
	}
	public UUID getGlobalEnrollmentId() {
		return globalEnrollmentId;
	}
	public void setGlobalEnrollmentId(UUID globalEnrollmentId) {
		this.globalEnrollmentId = globalEnrollmentId;
	}
	public UUID getGlobalProjectId() {
		return globalProjectId;
	}
	public void setGlobalProjectId(UUID globalProjectId) {
		this.globalProjectId = globalProjectId;
	}
	public String getHmisPostingStatus() {
		return hmisPostingStatus;
	}
	public void setHmisPostingStatus(String hmisPostingStatus) {
		this.hmisPostingStatus = hmisPostingStatus;
	}
	public String getSurveyCategory() {
		return surveyCategory;
	}
	public void setSurveyCategory(String surveyCategory) {
		this.surveyCategory = surveyCategory;
	}
	public String getHmisLink() {
		return hmisLink;
	}
	public void setHmisLink(String hmisLink) {
		this.hmisLink = hmisLink;
	}  
}