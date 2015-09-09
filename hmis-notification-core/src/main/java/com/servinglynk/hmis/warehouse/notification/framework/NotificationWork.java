package com.servinglynk.hmis.warehouse.notification.framework;

import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationLineEntity;



public class NotificationWork {
	
	private NotificationLineEntity notificationLineEntity;
	private Parameters notificationData;
	private String senderFriendly;
	private String sender;
	private String attachment;
	
	

	public NotificationLineEntity getNotificationLineEntity() {
		return notificationLineEntity;
	}
	public void setNotificationLineEntity(
			NotificationLineEntity notificationLineEntity) {
		this.notificationLineEntity = notificationLineEntity;
	}
	
	


	public Parameters getNotificationData() {
		return notificationData;
	}
	public void setNotificationData(Parameters notificationData) {
		this.notificationData = notificationData;
	}
	public String getSenderFriendly() {
		return senderFriendly;
	}
	public void setSenderFriendly(String senderFriendly) {
		this.senderFriendly = senderFriendly;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	


}
