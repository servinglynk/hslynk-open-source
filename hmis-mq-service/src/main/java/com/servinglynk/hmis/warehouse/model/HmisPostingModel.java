package com.servinglynk.hmis.warehouse.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("hmisPosting")
public class HmisPostingModel {

	private UUID clientId;
	private UUID surveyId;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private LocalDateTime informationDate;
	private String surveyCategory;
	private String projectGroupCode;
	private String userId;
	private String schemaVersion;
	private UUID globalProjectId;
	private String hmisPostingStatus;
	List<QuestionResponseModel> questionResponses = new ArrayList<>();
	
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
	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}
	public LocalDateTime getExitDate() {
		return exitDate;
	}
	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}
	public LocalDateTime getInformationDate() {
		return informationDate;
	}
	public void setInformationDate(LocalDateTime informationDate) {
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
}
