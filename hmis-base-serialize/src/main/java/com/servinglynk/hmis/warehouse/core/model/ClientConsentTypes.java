package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("clientConsentTypes")
public class ClientConsentTypes extends PaginatedModel {

	@JsonProperty("clientConsentTypes")
	List<ClientConsentType> clientConsentTypes = new ArrayList<ClientConsentType>();

	public List<ClientConsentType> getClientConsentTypes() {
		return clientConsentTypes;
	}

	public void setClientConsentTypes(List<ClientConsentType> clientConsentTypes) {
		this.clientConsentTypes = clientConsentTypes;
	}
	
	public void addClientConsentType(ClientConsentType clientConsentType){
		this.clientConsentTypes.add(clientConsentType);
	}
}