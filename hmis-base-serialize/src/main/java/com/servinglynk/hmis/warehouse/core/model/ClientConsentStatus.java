package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("consentRequestStatus")
public class ClientConsentStatus extends ClientModel {

	@JsonProperty("consentRequestId")
	private UUID consentId;
	@JsonProperty("status")
	private String approvalStatus;
	
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	@JsonProperty("statusEffectiveFrom")
	private LocalDateTime approvalStatusEffectiveFromDate;
	
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	@JsonProperty("statusEffectiveTo")
	private LocalDateTime approvalStatusEffectiveToDate;
	
	private String remarks;
	
	public UUID getConsentId() {
		return consentId;
	}
	public void setConsentId(UUID consentId) {
		this.consentId = consentId;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public LocalDateTime getApprovalStatusEffectiveFromDate() {
		return approvalStatusEffectiveFromDate;
	}
	public void setApprovalStatusEffectiveFromDate(LocalDateTime approvalStatusEffectiveFromDate) {
		this.approvalStatusEffectiveFromDate = approvalStatusEffectiveFromDate;
	}
	public LocalDateTime getApprovalStatusEffectiveToDate() {
		return approvalStatusEffectiveToDate;
	}
	public void setApprovalStatusEffectiveToDate(LocalDateTime approvalStatusEffectiveToDate) {
		this.approvalStatusEffectiveToDate = approvalStatusEffectiveToDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}