package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("apiMethod")
public class ApiMethod	extends ClientModel {

	private String externalId;
	private String friendlyName;
	private String description;
	private String type;
	private String authorizationMsg;
	private Long methodSequence;

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
	public String getAuthorizationMsg() {
		return authorizationMsg;
	}
	public void setAuthorizationMsg(String authorizationMsg) {
		this.authorizationMsg = authorizationMsg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getMethodSequence() {
		return methodSequence;
	}
	public void setMethodSequence(Long methodSequence) {
		this.methodSequence = methodSequence;
	}
}
