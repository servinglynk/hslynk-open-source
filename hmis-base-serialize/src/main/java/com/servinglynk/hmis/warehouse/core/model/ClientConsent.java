package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("clientConsent")
public class ClientConsent extends ClientModel {
	
	private UUID id;
	private UUID clientId;
	private String status;
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	private LocalDateTime startTime;
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	private LocalDateTime endTime;
	private String consentDocumentLink;
	
	@JsonProperty("clientConsentEntities")
	ClientConsentEntities clientConsentEntities= new ClientConsentEntities();
	
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
	public ClientConsentEntities getClientConsentEntities() {
		return clientConsentEntities;
	}
	public void setClientConsentEntities(ClientConsentEntities clientConsentEntities) {
		this.clientConsentEntities = clientConsentEntities;
	}
}