package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.servinglynk.hmis.warehouse.annotations.AllowedValues;

@JsonRootName("consent")
public class ClientConsent extends ClientModel {
	
	@JsonProperty("consentId")
	private UUID id;
	private UUID clientId;
	
	@AllowedValues(values={"APPROVED","REJECTED"},message="Allowed values for status value are APPROVED,REJECTED")
	private String status;
	
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	private LocalDateTime startTime;
	
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	private LocalDateTime endTime;
	
	private String consentDocumentLink;
	private String entityGroup;
	
	private UUID consentUserId;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getConsentDocumentLink() {
		return consentDocumentLink;
	}
	public void setConsentDocumentLink(String consentDocumentLink) {
		this.consentDocumentLink = consentDocumentLink;
	}
	public String getEntityGroup() {
		return entityGroup;
	}
	public void setEntityGroup(String entityGroup) {
		this.entityGroup = entityGroup;
	}
	public UUID getConsentUserId() {
		return consentUserId;
	}
	public void setConsentUserId(UUID consentUserId) {
		this.consentUserId = consentUserId;
	}
	
}