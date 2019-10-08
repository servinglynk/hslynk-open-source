package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("assessmentResult")
public class AssessmentResult extends ClientModel {

	@JsonProperty("assessmentId")
    private UUID assessmentResultId;
	private UUID enrollmentid;
	private UUID clientid;
	private UUID  assessmentId;
	private String assessmentResult;
	private String assessmentResultType;
	/**
	 * @return the assessmentResultId
	 */
	public UUID getAssessmentResultId() {
		return assessmentResultId;
	}
	/**
	 * @param assessmentResultId the assessmentResultId to set
	 */
	public void setAssessmentResultId(UUID assessmentResultId) {
		this.assessmentResultId = assessmentResultId;
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
	 * @return the assessmentResult
	 */
	public String getAssessmentResult() {
		return assessmentResult;
	}
	/**
	 * @param assessmentResult the assessmentResult to set
	 */
	public void setAssessmentResult(String assessmentResult) {
		this.assessmentResult = assessmentResult;
	}
	/**
	 * @return the assessmentResultType
	 */
	public String getAssessmentResultType() {
		return assessmentResultType;
	}
	/**
	 * @param assessmentResultType the assessmentResultType to set
	 */
	public void setAssessmentResultType(String assessmentResultType) {
		this.assessmentResultType = assessmentResultType;
	}
	
 }
