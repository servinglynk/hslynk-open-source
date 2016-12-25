package com.servinglynk.servey.views;

public class Response {
	
public Response(String submissionId, String questionId, String clientId,String responseText) {
		super();
		this.submissionId = submissionId;
		this.questionId = questionId;
		this.clientId = clientId;
	}
private String submissionId;
private String questionId;
private String clientId;
private String responseText;
/**
 * @return the submissionId
 */
public String getSubmissionId() {
	return submissionId;
}
/**
 * @param submissionId the submissionId to set
 */
public void setSubmissionId(String submissionId) {
	this.submissionId = submissionId;
}
/**
 * @return the questionId
 */
public String getQuestionId() {
	return questionId;
}
/**
 * @param questionId the questionId to set
 */
public void setQuestionId(String questionId) {
	this.questionId = questionId;
}
/**
 * @return the clientId
 */
public String getClientId() {
	return clientId;
}
/**
 * @param clientId the clientId to set
 */
public void setClientId(String clientId) {
	this.clientId = clientId;
}
/**
 * @return the responseText
 */
public String getResponseText() {
	return responseText;
}
/**
 * @param responseText the responseText to set
 */
public void setResponseText(String responseText) {
	this.responseText = responseText;
}

}
