package com.servinglynk.hmis.warehouse.base.dao;


import java.util.List;

import com.servinglynk.hmis.warehouse.NotificationSearchRequest;
import com.servinglynk.hmis.warehouse.model.HMISNotificationEntity;

public interface HMISNotificationsDao {
	
	HMISNotificationEntity saveNotification(HMISNotificationEntity entity);

	List<HMISNotificationEntity> getEmailNotifications(NotificationSearchRequest searchRequest);
	Long getEmailNotificationsCount(NotificationSearchRequest searchRequest);
}