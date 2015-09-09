package com.servinglynk.hmis.warehouse.notification.business.converter;

import com.servinglynk.hmis.warehouse.core.model.NotificationHeader;
import com.servinglynk.hmis.warehouse.core.model.NotificationLine;
import com.servinglynk.hmis.warehouse.core.model.Recipient;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationHeaderEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationLineEntity;

public class NotificationConverter {

	
	public static NotificationHeader convertEntityToModel(NotificationHeaderEntity notificationHeaderEntity) {
		NotificationHeader nh = new NotificationHeader();
		return nh;
	}
	
	public static NotificationLine convertEntityToModel(NotificationLineEntity notificationLineEntity) {
		NotificationLine nl = new NotificationLine();
		return nl;
	}
	
	public static NotificationHeaderEntity convertModelToEntity(NotificationHeader nhModel,NotificationHeaderEntity nhEntity) {
		NotificationHeaderEntity nhe = new NotificationHeaderEntity();
		nhe.setSender(nhModel.getOriginator().getSender());
		nhe.setSenderFriendly(nhModel.getOriginator().getSenderFriendly());
		
		return nhe;
	}
	
	public static NotificationHeaderEntity convertModelToEntity(NotificationHeader nhModel) {
		return convertModelToEntity(nhModel, new NotificationHeaderEntity());
	}
	
	public static NotificationLineEntity convertModelToEntity(NotificationLine companyModel,NotificationLineEntity nlEntity) {
	return nlEntity;
	}
	
	public static NotificationLineEntity toNotificationLineEntity(Recipient recipient)	{
		NotificationLineEntity notificationLineEntity = new NotificationLineEntity();
		notificationLineEntity.setDeliverTo(recipient.getDeliverTo());
		notificationLineEntity.setDeliveryMethod(recipient.getDeliveryMethod());
		
		if ((recipient.getTemplateId() == null))	{
			throw new IllegalArgumentException("Template info is missing for recipient " + recipient.getDeliverTo());
		}
		
		notificationLineEntity.setUsername(recipient.getUsername());
		return notificationLineEntity;
	}	
}