package com.servinglynk.hmis.warehouse.notification.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationStatus;


@JsonRootName("notificationHeader")
public class NotificationLine extends ClientModel {

	private String externalId;
	
	private Originator originator;
	
	private NotificationStatus status;

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
	public NotificationStatus getStatus() {
		return status;
	}
	public void setStatus(NotificationStatus status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}