package com.servinglynk.hmis.warehouse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HmisPostingModel {

	private UUID clientId;
	private UUID dedupClientId;
	private UUID surveyId;
	private String entryDate;
	private String submissionDate;
	private String exitDate;
	private String informationDate;
	private String surveyCategory;
	private String projectGroupCode;
	private UUID userId;
	private UUID globalProjectId;
	private UUID globalEnrollmentId;
	private UUID clientSurveySubmissionId;
	private String hmisPostingStatus;
	private String schemaVersion;
	List<QuestionResponseModel> questionResponses = new ArrayList<QuestionResponseModel>();
	
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
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getExitDate() {
		return exitDate;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	public String getInformationDate() {
		return informationDate;
	}
	public void setInformationDate(String informationDate) {
		this.informationDate = informationDate;
	}
	public String getSurveyCategory() {
		return surveyCategory;
	}
	public void setSurveyCategory(String surveyCategory) {
		this.surveyCategory = surveyCategory;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getSchemaVersion() {
		return schemaVersion;
	}
	public void setSchemaVersion(String schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	public List<QuestionResponseModel> getQuestionResponses() {
		return questionResponses;
	}
	public void setQuestionResponses(List<QuestionResponseModel> questionResponses) {
		this.questionResponses = questionResponses;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public UUID getDedupClientId() {
		return dedupClientId;
	}
	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	public String getHmisPostingStatus() {
		return hmisPostingStatus;
	}
	public void setHmisPostingStatus(String hmisPostingStatus) {
		this.hmisPostingStatus = hmisPostingStatus;
	}
	public UUID getGlobalProjectId() {
		return globalProjectId;
	}
	public void setGlobalProjectId(UUID globalProjectId) {
		this.globalProjectId = globalProjectId;
	}
	public UUID getGlobalEnrollmentId() {
		return globalEnrollmentId;
	}
	public void setGlobalEnrollmentId(UUID globalEnrollmentId) {
		this.globalEnrollmentId = globalEnrollmentId;
	}
	public UUID getClientSurveySubmissionId() {
		return clientSurveySubmissionId;
	}
	public void setClientSurveySubmissionId(UUID clientSurveySubmissionId) {
		this.clientSurveySubmissionId = clientSurveySubmissionId;
	}
}
