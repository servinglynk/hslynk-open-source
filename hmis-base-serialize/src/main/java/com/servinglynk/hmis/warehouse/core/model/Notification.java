package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("notification")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification extends ClientModel {
	

	@JsonProperty("type")
	private String type;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("statusMessage")
	private String statusMessage;
	
	@JsonProperty("attachment")
	private String attachment;
	
	@JsonProperty("method")
	private String method;
	
/*	@JsonProperty("recipients")
	private List<String> recipients;*/
	
	@JsonProperty("recipients")
	private Recipients recipients = new Recipients();
	
	
	@JsonProperty("parameters")
	Parameters parameters=new Parameters();
	
	private Integer priority;

	
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
/*	public List<String> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}*/
	
	
	
	
	
	public String getMethod() {
		return method;
	}
	public Recipients getRecipients() {
		return recipients;
	}
	public void setRecipients(Recipients recipients) {
		this.recipients = recipients;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	

}