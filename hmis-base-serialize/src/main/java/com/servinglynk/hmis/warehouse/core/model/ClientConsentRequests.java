package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("consentRequests")
public class ClientConsentRequests extends PaginatedModel {

	@JsonProperty("consentRequests")
	private List<ClientConsentRequest> clientConsents = new ArrayList<ClientConsentRequest>();

	public List<ClientConsentRequest> getClientConsents() {
		return clientConsents;
	}

	public void setClientConsents(List<ClientConsentRequest> clientConsents) {
		this.clientConsents = clientConsents;
	}
	
	public void addClientConsent(ClientConsentRequest clientConsent){
		this.clientConsents.add(clientConsent);
	}
}