package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("notifications")
public class HmisNotifications extends PaginatedModel {

	private List<HmisNotification> notifications = new ArrayList<HmisNotification>();

	public List<HmisNotification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<HmisNotification> notifications) {
		this.notifications = notifications;
	}
	
	public void addNotification(HmisNotification notification) {
		this.notifications.add(notification);
	}
}