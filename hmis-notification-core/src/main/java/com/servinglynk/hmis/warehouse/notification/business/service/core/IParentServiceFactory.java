package com.servinglynk.hmis.warehouse.notification.business.service.core;

import com.servinglynk.hmis.warehouse.notification.business.service.ICarrierService;
import com.servinglynk.hmis.warehouse.notification.business.service.INotificationWorker;
import com.servinglynk.hmis.warehouse.notification.business.service.ITemplateService;
import com.servinglynk.hmis.warehouse.notification.business.service.IWorkerService;

public interface IParentServiceFactory {
	
	
	ICarrierService getCarrierService();
	ITemplateService getTemplateService();
	INotificationWorker getNotificationWorker();
	IWorkerService getWorkerService();
	
}
