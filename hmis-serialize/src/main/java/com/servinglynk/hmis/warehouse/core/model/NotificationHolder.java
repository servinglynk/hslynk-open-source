package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;




public class NotificationHolder {
	
	@JsonProperty("notification")
	Notification notification;

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	
	

}