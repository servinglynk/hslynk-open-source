package com.servinglynk.hmis.warehouse.notification.business.service;

import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Notifications;
import com.servinglynk.hmis.warehouse.core.model.SearchRequest;

public interface INotificationService {

	public void createNotificationJob(Notification notification);
	public Notifications searchNotifications(SearchRequest searchRequest);
	
}
