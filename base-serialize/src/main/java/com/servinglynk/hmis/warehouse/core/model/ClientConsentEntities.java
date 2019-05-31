package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("consentEntities")
public class ClientConsentEntities {

	@JsonProperty("consentEntities")
	private List<ClientConsentEntityModel> clientConsentEntities = new ArrayList<ClientConsentEntityModel>();

	public List<ClientConsentEntityModel> getClientConsentEntities() {
		return clientConsentEntities;
	}

	public void setClientConsentEntities(List<ClientConsentEntityModel> clientConsentEntities) {
		this.clientConsentEntities = clientConsentEntities;
	}
	
	public void addClientConsentEntity(ClientConsentEntityModel clientConsentEntity){
		this.clientConsentEntities.add(clientConsentEntity);
	}
}