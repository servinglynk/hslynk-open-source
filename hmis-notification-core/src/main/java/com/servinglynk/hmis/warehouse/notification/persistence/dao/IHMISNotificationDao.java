package com.servinglynk.hmis.warehouse.notification.persistence.dao;

import com.servinglynk.hmis.warehouse.notification.persistence.entity.HMISNotificationEntity;

public interface IHMISNotificationDao {

	void updateNotificationStatus(HMISNotificationEntity entity,String status,String statusMessage);
	HMISNotificationEntity getHmisNotification(Long id);
}
