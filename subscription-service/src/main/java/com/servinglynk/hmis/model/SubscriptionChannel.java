package com.servinglynk.hmis.model;

import javax.validation.constraints.NotNull;

import com.servinglynk.hmis.warehouse.annotations.AllowedValues;

public class SubscriptionChannel extends ClientModel {

	@NotNull(message = "Channel type is required")
	@AllowedValues(values = {"rest-hook","email"},message= "Allowed values for channel type are rest-hook,email")
	private String type;
	@NotNull(message = "Endpoint is required")
	private String endpoint;
	@NotNull(message = "Payload is required")
	private String payload;

	private String header;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
}