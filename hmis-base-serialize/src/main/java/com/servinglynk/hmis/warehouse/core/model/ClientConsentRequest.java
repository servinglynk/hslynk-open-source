package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.servinglynk.hmis.warehouse.annotations.AllowedValues;

@JsonRootName("consentRequest")
public class ClientConsentRequest extends ClientModel {
	
	private UUID  consentRequestid;
	private UUID clientId;
	
	@AllowedValues(values={"APPROVED","REJECTED"},message="Allowed values for status value are APPROVED,REJECTED")
	private String status;
	
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	@JsonProperty("consentRequestedFrom")
	private LocalDateTime startTime;
	
	@JsonDeserialize(using=JsonTimestampDeserializer.class)
	@JsonSerialize(using=JsonTimestampSerializer.class)
	@JsonProperty("consentRequestedTo")
	private LocalDateTime endTime;
	
	private String consentDocumentLink;
	
	@JsonProperty("consentRequestEntities")
	ClientConsentRequestEntities clientConsentEntities= new ClientConsentRequestEntities();
	
	public UUID getConsentRequestid() {
		return consentRequestid;
	}
	public void setConsentRequestid(UUID consentRequestid) {
		this.consentRequestid = consentRequestid;
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
	public ClientConsentRequestEntities getClientConsentEntities() {
		return clientConsentEntities;
	}
	public void setClientConsentEntities(ClientConsentRequestEntities clientConsentEntities) {
		this.clientConsentEntities = clientConsentEntities;
	}
}