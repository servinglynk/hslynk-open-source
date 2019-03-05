package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class Notifications extends PaginatedModel {

	
	private List<Notification> notifications = new ArrayList<Notification>();

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public void addNotification(Notification notification){
		this.notifications.add(notification);
	}
	
	public Notification getNotification(int index){
		return this.notifications.get(index);
	}
}
