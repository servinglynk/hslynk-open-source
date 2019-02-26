package com.servinglynk.hmis.warehouse.core.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("notificationHeader")
public class NotificationLine extends ClientModel {

	private String externalId;
	
	private Originator originator;
	
	private String status;

	private String statusMessage;
	
		
	private List<Recipient> recipients;
	
	public void setExternalId(String externalId)	{
		this.externalId = externalId;
	}
	public String getExternalId() {
		return externalId;
	}
	public Originator getOriginator() {
		return originator;
	}
	public void setOriginator(Originator originator) {
		this.originator = originator;
	}

	public List<Recipient> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<Recipient> recipients) {
		this.recipients = recipients;
	}

	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}