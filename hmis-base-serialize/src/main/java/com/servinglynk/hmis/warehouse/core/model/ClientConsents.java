package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("consents")
public class ClientConsents extends PaginatedModel {

	@JsonProperty("consents")
	private List<ClientConsent> clientConsents = new ArrayList<ClientConsent>();

	public List<ClientConsent> getClientConsents() {
		return clientConsents;
	}

	public void setClientConsents(List<ClientConsent> clientConsents) {
		this.clientConsents = clientConsents;
	}
	
	public void addClientConsent(ClientConsent clientConsent){
		this.clientConsents.add(clientConsent);
	}
}