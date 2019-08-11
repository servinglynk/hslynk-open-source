package com.servinglynk.hmis.warehouse.notification.business.service;

import com.servinglynk.hmis.warehouse.notification.business.service.core.IParentService;
import com.servinglynk.hmis.warehouse.notification.framework.MergedNotificationContent;
import com.servinglynk.hmis.warehouse.notification.framework.NotificationWork;

public interface ITemplateService extends IParentService{
	
	
	public MergedNotificationContent merge(NotificationWork notificationWork);

}