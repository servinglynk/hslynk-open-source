package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("clientConsentEntity")
public class ClientConsentEntityModel extends ClientModel  {

	private UUID id;
	private UUID clientConsentId;
	private UUID consentTypeId;
	private UUID consentEntityId;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getClientConsentId() {
		return clientConsentId;
	}
	public void setClientConsentId(UUID clientConsentId) {
		this.clientConsentId = clientConsentId;
	}
	public UUID getConsentTypeId() {
		return consentTypeId;
	}
	public void setConsentTypeId(UUID consentTypeId) {
		this.consentTypeId = consentTypeId;
	}
	public UUID getConsentEntityId() {
		return consentEntityId;
	}
	public void setConsentEntityId(UUID consentEntityId) {
		this.consentEntityId = consentEntityId;
	}
}