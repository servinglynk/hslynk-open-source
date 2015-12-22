package com.servinglynk.hmis.warehouse.notification.framework;

import com.servinglynk.hmis.warehouse.notification.carrier.CarrierNotification;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationLineEntity;


public class NotificationThread {

	
	NotificationWork notificationWork;
	
	
	NotificationEngineContext notificationEngineContext;
	
	public NotificationEngineContext getNotificationEngineContext() {
		return notificationEngineContext;
	}

	
	public void setNotificationEngineContext(
			NotificationEngineContext notificationEngineContext) {
		this.notificationEngineContext = notificationEngineContext;
	}


	public NotificationWork getNotificationWork() {
		return notificationWork;
	}

	
	public void setNotificationWork(NotificationWork notificationWork) {
		this.notificationWork = notificationWork;
	}


   
	public NotificationThread(NotificationWork notificationWork, NotificationEngineContext notificationEngineContext)	{
		this.notificationWork = notificationWork;
		this.notificationEngineContext = notificationEngineContext;
	}
	
	
	public void run() {
		MergedNotificationContent notificationContent = getNotificationEngineContext().getTemplateService().merge(notificationWork);
		CarrierNotification carrierNotification = createCarrierNotification(notificationWork,notificationContent);
		getNotificationEngineContext().getCarrierService().send(carrierNotification,notificationWork.getNotificationLineEntity());
		
	}
	
	
	private CarrierNotification createCarrierNotification(NotificationWork notificationWork,MergedNotificationContent notificationContent)  {
		NotificationLineEntity notificationLineEntity = notificationWork.getNotificationLineEntity();
		
		CarrierNotification carrierNotification = new CarrierNotification();
		
		carrierNotification.setRecipient(notificationLineEntity.getDeliverTo());  //recipient information
		carrierNotification.setRecipient(notificationLineEntity.getDeliverTo());  //recipient information
		carrierNotification.setId(notificationLineEntity.getId().toString());  //recipient information
		carrierNotification.setPriority(notificationWork.getPriority());
		
		carrierNotification.setSenderFriendly(notificationWork.getSenderFriendly()); // sender information
		carrierNotification.setSender(notificationWork.getSender());  // sender information
		carrierNotification.setAttachment(notificationWork.getAttachment());
		
		carrierNotification.setContent(notificationContent.getBody()); //merged data 
		carrierNotification.setSubject(notificationContent.getSubject()); //merged data
		
		return carrierNotification;
	}
	
	
	
}
