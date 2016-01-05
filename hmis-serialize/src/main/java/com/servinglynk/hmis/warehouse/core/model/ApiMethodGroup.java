package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.ClientModel;

public class ApiMethodGroup extends ClientModel {

	
	private UUID methodId;
	private String externalId;
	private String friendlyName;
	private String description;
	
	private ApiMethods apiMethods = new ApiMethods();
	
	public UUID getMethodId() {
		return methodId;
	}
	public void setMethodId(UUID methodId) {
		this.methodId = methodId;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ApiMethods getApiMethods() {
		return apiMethods;
	}
	public void setApiMethods(ApiMethods apiMethods) {
		this.apiMethods = apiMethods;
	}	
}