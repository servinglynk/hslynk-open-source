package com.servinglynk.hmis.warehouse.client.notificationservice;

import com.servinglynk.hmis.warehouse.client.exception.RestClientHttpException;
import com.servinglynk.hmis.warehouse.client.model.Notification;




public interface INotificationServiceClient {

	public Notification createNotification(Notification notification) throws RestClientHttpException;
	
	
}
