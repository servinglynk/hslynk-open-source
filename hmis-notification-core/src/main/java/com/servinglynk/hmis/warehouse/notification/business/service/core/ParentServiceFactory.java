package com.servinglynk.hmis.warehouse.notification.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.notification.business.service.ICarrierService;
import com.servinglynk.hmis.warehouse.notification.business.service.INotificationWorker;
import com.servinglynk.hmis.warehouse.notification.business.service.ITemplateService;
import com.servinglynk.hmis.warehouse.notification.business.service.IWorkerService;


@Component
public class ParentServiceFactory  implements IParentServiceFactory {

	@Autowired
	ICarrierService carrierService;
	
	
	public ICarrierService getCarrierService() {
		return carrierService;
	}

	public void setCarrierService(ICarrierService carrierService) {
		this.carrierService = carrierService;
	}

	@Autowired
	ITemplateService templateService;


	public ITemplateService getTemplateService() {
		return templateService;
	}

	public void setTemplateService(ITemplateService templateService) {
		this.templateService = templateService;
	}
	
	@Autowired
	IWorkerService workerService;

	
	public IWorkerService getWorkerService() {
		return workerService;
	}

	public void setWorkerService(IWorkerService workerService) {
		this.workerService = workerService;
	}
	
	@Autowired
	INotificationWorker notificationWorker;


	public INotificationWorker getNotificationWorker() {
		return notificationWorker;
	}

	public void setNotificationWorker(INotificationWorker notificationWorker) {
		this.notificationWorker = notificationWorker;
	}
	
	
	
}

