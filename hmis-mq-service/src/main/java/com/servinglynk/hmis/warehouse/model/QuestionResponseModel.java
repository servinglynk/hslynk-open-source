package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

public class QuestionResponseModel {

	private UUID questionId;
	private String questionText;
	private String responseText;
	private String pickListValueCode;
	private UUID responseId;
	private String questionClassification;
	private String updateUrlTemplate;
	private String uriObjectField;
	private String hmisLink;
	
	public UUID getQuestionId() {
		return questionId;
	}
	public void setQuestionId(UUID questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getResponseText() {
		return responseText;
	}
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	public UUID getResponseId() {
		return responseId;
	}
	public void setResponseId(UUID responseId) {
		this.responseId = responseId;
	}
	public String getQuestionClassification() {
		return questionClassification;
	}
	public void setQuestionClassification(String questionClassification) {
		this.questionClassification = questionClassification;
	}
	public String getUpdateUrlTemplate() {
		return updateUrlTemplate;
	}
	public void setUpdateUrlTemplate(String updateUrlTemplate) {
		this.updateUrlTemplate = updateUrlTemplate;
	}
	public String getUriObjectField() {
		return uriObjectField;
	}
	public void setUriObjectField(String uriObjectField) {
		this.uriObjectField = uriObjectField;
	}
	public String getHmisLink() {
		return hmisLink;
	}
	public void setHmisLink(String hmisLink) {
		this.hmisLink = hmisLink;
	}
	public String getPickListValueCode() {
		return pickListValueCode;
	}
	public void setPickListValueCode(String pickListValueCode) {
		this.pickListValueCode = pickListValueCode;
	}
}
