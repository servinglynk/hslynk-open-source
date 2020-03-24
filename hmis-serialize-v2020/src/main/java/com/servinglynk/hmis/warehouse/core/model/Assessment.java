package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonRootName("assessment")
public class Assessment extends ClientModel{

	@JsonProperty("assessmentId")
    private UUID assessmentId;
	private UUID enrollmentid;
	private UUID clientid;
	private UUID dedupClientId;
	 @JsonSerialize(using=JsonDateSerializer.class)
     @JsonDeserialize(using=JsonDateDeserializer.class)
	private LocalDateTime assessmentDate;
	private String assessmentLocation;
	private String assessmentType;
	private String assessmentLevel;
	private String prioritizationStatus;
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
	 * @return the assessmentDate
	 */
	public LocalDateTime getAssessmentDate() {
		return assessmentDate;
	}
	/**
	 * @param assessmentDate the assessmentDate to set
	 */
	public void setAssessmentDate(LocalDateTime assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	/**
	 * @return the assessmentLocation
	 */
	public String getAssessmentLocation() {
		return assessmentLocation;
	}
	/**
	 * @param assessmentLocation the assessmentLocation to set
	 */
	public void setAssessmentLocation(String assessmentLocation) {
		this.assessmentLocation = assessmentLocation;
	}
	/**
	 * @return the assessmentType
	 */
	public String getAssessmentType() {
		return assessmentType;
	}
	/**
	 * @param assessmentType the assessmentType to set
	 */
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	/**
	 * @return the assessmentLevel
	 */
	public String getAssessmentLevel() {
		return assessmentLevel;
	}
	/**
	 * @param assessmentLevel the assessmentLevel to set
	 */
	public void setAssessmentLevel(String assessmentLevel) {
		this.assessmentLevel = assessmentLevel;
	}
	/**
	 * @return the prioritizationStatus
	 */
	public String getPrioritizationStatus() {
		return prioritizationStatus;
	}
	/**
	 * @param prioritizationStatus the prioritizationStatus to set
	 */
	public void setPrioritizationStatus(String prioritizationStatus) {
		this.prioritizationStatus = prioritizationStatus;
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
