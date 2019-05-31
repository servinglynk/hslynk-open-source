package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;



@JsonRootName("template")
public class Template {
	
	private String externalId;
	
	private String friendlyName;

	private String body;


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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
