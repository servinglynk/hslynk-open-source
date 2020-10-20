package com.servinglynk.hmis.warehouse.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("clientSurveySubmissions")
public class ClientSurveySubmissions extends PaginatedModel{

	@JsonProperty("clientSurveySubmissions")
	private List<ClientSurveySubmission> clientSurveySubmissions = new ArrayList<ClientSurveySubmission>();

	public List<ClientSurveySubmission> getClientSurveySubmissions() {
		return clientSurveySubmissions;
	}

	public void setClientSurveySubmissions(List<ClientSurveySubmission> clientSurveySubmissions) {
		this.clientSurveySubmissions = clientSurveySubmissions;
	}
	
	public void addClientSurveySubmission(ClientSurveySubmission clientSurveySubmission) {
		this.clientSurveySubmissions.add(clientSurveySubmission);
	}
	
}