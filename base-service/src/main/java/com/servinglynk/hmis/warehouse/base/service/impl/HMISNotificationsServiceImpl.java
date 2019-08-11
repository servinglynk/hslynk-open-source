package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.NotificationSearchRequest;
import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.converter.HMISNotificationConverter;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.HmisNotification;
import com.servinglynk.hmis.warehouse.core.model.HmisNotifications;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.model.HMISNotificationEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

public class HMISNotificationsServiceImpl extends ServiceBase implements HMISNotificationsService {
	
	
	@Autowired
	NotificationServiceClient notificationServiceClient;

	@Transactional
	public HmisNotification sendHmisNotification(HmisNotification hmisNotification, Account account) throws Exception {
		
		HMISNotificationEntity entity = HMISNotificationConverter.modelToEntity(hmisNotification, null);
		entity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		entity.setCreatedAt(new Date());
		entity.setUser(account.getAccountId());
		daoFactory.getHmisNotificationsDao().saveNotification(entity);
		
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(account.getProjectGroup().getProjectGroupCode());

		Notification notification =HMISNotificationConverter.prepateNotificationObject(hmisNotification);
		notification.setHmisNotificationId(entity.getId());
		notification.setSender(projectGroupEntity.getSenderEmail());
		notificationServiceClient.createNotification(notification);
		
		return hmisNotification;
	}

	
	@Transactional
	public HmisNotifications getEmailNotifications(NotificationSearchRequest searchRequest) throws Exception  {
		HmisNotifications notifications = new HmisNotifications();
		
		List<HMISNotificationEntity> entities  = daoFactory.getHmisNotificationsDao().getEmailNotifications(searchRequest);
		for(HMISNotificationEntity entity : entities) {
			notifications.addNotification(HMISNotificationConverter.entityToModel(entity));
		}
		
		
		 SortedPagination pagination = new SortedPagination();
		    pagination.setFrom(searchRequest.getStartIndex());
		    pagination.setMaximum(searchRequest.getMaxItems());
		    pagination.setTotal(daoFactory.getHmisNotificationsDao().getEmailNotificationsCount(searchRequest).intValue());
		    notifications.setPagination(pagination);
		
		return notifications;
	}
	
}
