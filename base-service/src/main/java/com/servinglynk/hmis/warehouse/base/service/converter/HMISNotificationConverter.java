package com.servinglynk.hmis.warehouse.base.service.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.xml.ws.Service.Mode;

import com.servinglynk.hmis.warehouse.core.model.AdditionalNotificationInfo;
import com.servinglynk.hmis.warehouse.core.model.HmisNotification;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Recipients;
import com.servinglynk.hmis.warehouse.model.HMISNotificationEntity;

public class HMISNotificationConverter {
	
	
	public static HMISNotificationEntity modelToEntity(HmisNotification model,HMISNotificationEntity entity) throws Exception {
		if(entity==null) {
			entity = new HMISNotificationEntity();
		}

		entity.setMessageType(model.getAdditionalInfo().getMessageType());
		entity.setRecipientId(model.getAdditionalInfo().getRecipientId());
		entity.setRecipientType(model.getAdditionalInfo().getRecipientType());
		
		entity.setMethod(model.getMethod());
		entity.setStatus("CREATED");

		if(model.getData()!=null) {
			entity.setMessage(model.getData().getMessage());
			entity.setSubject(model.getData().getSubject());	
			entity.setRecipients(model.getData().getRecipients().toJSONString());
			entity.setPriority(model.getData().getPriority());			
		}
		return entity;
	}
	
	
	
	public static Notification prepateNotificationObject(HmisNotification model) {
		
		Notification notification = new Notification();
		notification.setMethod("EMAIL");
		notification.setType("HMIS_EMAIL_NOTIFICATION");
		notification.getParameters().addParameter(new Parameter("message", model.getData().getMessage()));
		notification.getParameters().addParameter(new Parameter("subject", model.getData().getSubject()));
		notification.setRecipients(model.getData().getRecipients());
		notification.setPriority(model.getData().getPriority());
		return notification;
		
	}



	public static HmisNotification entityToModel(HMISNotificationEntity entity) throws Exception {
		HmisNotification notification = new HmisNotification();
	
		if(entity.getCreatedAt()!=null) notification.setCreatedTime(LocalDateTime.ofInstant(entity.getCreatedAt().toInstant(), ZoneId.systemDefault()));
		if(entity.getModifiedAt()!=null) notification.setUpdatedTime(LocalDateTime.ofInstant(entity.getModifiedAt().toInstant(), ZoneId.systemDefault()));
		
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		

		Notification data = new Notification();
		data.setStatus(entity.getStatus());
		data.setStatusMessage(entity.getStatusMessage());
		data.setSubject(entity.getSubject());
		data.setMessage(entity.getMessage());
		data.setRecipients(objectMapper.readValue(entity.getRecipients(),Recipients.class));
		
		notification.setData(data);
		
		notification.setMethod(entity.getMethod());
		
		
		AdditionalNotificationInfo info = new AdditionalNotificationInfo();
		
		info.setMessageType(entity.getMessageType());
		info.setRecipientId(entity.getRecipientId());
		info.setRecipientType(entity.getRecipientType());
		
		notification.setAdditionalInfo(info);
		return notification;
	}
	
	

}