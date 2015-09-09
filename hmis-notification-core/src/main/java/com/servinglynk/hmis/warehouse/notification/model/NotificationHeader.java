package com.servinglynk.hmis.warehouse.notification.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationStatus;
import com.servinglynk.hmis.warehouse.notification.framework.NotificationData;


@JsonRootName(value = "notificationHeader")
public class NotificationHeader extends ClientModel {


	private String externalId;
	

	private Originator originator;
	
	private NotificationStatus status;

	private String statusMessage;
	
	private String notificationSubject;
	
	private NotificationData notificationData;
	
	private String attachment;
	
	

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
	
	public NotificationData getNotificationData() {
		return notificationData;
	}
	public void setNotificationData(NotificationData notificationData) {
		this.notificationData = notificationData;
	}
	public String getNotificationSubject() {
		return notificationSubject;
	}
	public void setNotificationSubject(String notificationSubject) {
		this.notificationSubject = notificationSubject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	
}