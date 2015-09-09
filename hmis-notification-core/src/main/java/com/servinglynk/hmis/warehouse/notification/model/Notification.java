package com.servinglynk.hmis.warehouse.notification.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationStatus;


@JsonRootName("notification")
public class Notification extends ClientModel {
	
	private String externalId;
	private String type;
	
	private NotificationStatus status;
	private String statusMessage;
	private String attachment;
	private String method;
	private List<String> recipients;
	private Parameters notificationData;
	
	public void setExternalId(String externalId)	{
		this.externalId = externalId;
	}
	public String getExternalId() {
		return externalId;
	}


	
	public Parameters getNotificationData() {
		return notificationData;
	}
	public void setNotificationData(Parameters notificationData) {
		this.notificationData = notificationData;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}
	public String getMethod() {
		return method;
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
	
	

}