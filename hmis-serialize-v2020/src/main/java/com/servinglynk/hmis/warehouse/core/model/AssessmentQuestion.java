package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("assessmentQuestion")
public class AssessmentQuestion extends ClientModel{

	@JsonProperty("assessmentQuestionId")
    private UUID assessmentQuestionId;
	private UUID enrollmentid;
	private UUID clientid;
	private UUID dedupClientId;
	private UUID assessmentId;
	private String assessmentQuestionGroup;
	private Integer assessmentQuestionOrder;
	private String assessmentQuestion;
	private String assessmentAnswer;
	/**
	 * @return the assessmentQuestionId
	 */
	public UUID getAssessmentQuestionId() {
		return assessmentQuestionId;
	}
	/**
	 * @param assessmentQuestionId the assessmentQuestionId to set
	 */
	public void setAssessmentQuestionId(UUID assessmentQuestionId) {
		this.assessmentQuestionId = assessmentQuestionId;
	}
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the clientid
	 */
	public UUID getClientid() {
		return clientid;
	}
	/**
	 * @param clientid the clientid to set
	 */
	public void setClientid(UUID clientid) {
		this.clientid = clientid;
	}
	/**
	 * @return the assessmentId
	 */
	public UUID getAssessmentId() {
		return assessmentId;
	}
	/**
	 * @param assessmentId the assessmentId to set
	 */
	public void setAssessmentId(UUID assessmentId) {
		this.assessmentId = assessmentId;
	}
	/**
	 * @return the assessmentQuestionGroup
	 */
	public String getAssessmentQuestionGroup() {
		return assessmentQuestionGroup;
	}
	/**
	 * @param assessmentQuestionGroup the assessmentQuestionGroup to set
	 */
	public void setAssessmentQuestionGroup(String assessmentQuestionGroup) {
		this.assessmentQuestionGroup = assessmentQuestionGroup;
	}
	/**
	 * @return the assessmentQuestionOrder
	 */
	public Integer getAssessmentQuestionOrder() {
		return assessmentQuestionOrder;
	}
	/**
	 * @param assessmentQuestionOrder the assessmentQuestionOrder to set
	 */
	public void setAssessmentQuestionOrder(Integer assessmentQuestionOrder) {
		this.assessmentQuestionOrder = assessmentQuestionOrder;
	}
	/**
	 * @return the assessmentQuestion
	 */
	public String getAssessmentQuestion() {
		return assessmentQuestion;
	}
	/**
	 * @param assessmentQuestion the assessmentQuestion to set
	 */
	public void setAssessmentQuestion(String assessmentQuestion) {
		this.assessmentQuestion = assessmentQuestion;
	}
	/**
	 * @return the assessmentAnswer
	 */
	public String getAssessmentAnswer() {
		return assessmentAnswer;
	}
	/**
	 * @param assessmentAnswer the assessmentAnswer to set
	 */
	public void setAssessmentAnswer(String assessmentAnswer) {
		this.assessmentAnswer = assessmentAnswer;
	}
	/**
	 * @return the dedupClientid
	 */
	public UUID getDedupClientId() {
		return dedupClientId;
	}
	/**
	 * @param dedupClientid the dedupClientid to set
	 */
	public void setDedupClientId(UUID dedupClientid) {
		this.dedupClientId = dedupClientid;
	}
	
 }
