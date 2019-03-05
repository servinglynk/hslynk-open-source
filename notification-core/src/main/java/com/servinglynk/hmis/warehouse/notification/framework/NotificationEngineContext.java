package com.servinglynk.hmis.warehouse.notification.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.notification.business.service.ICarrierService;
import com.servinglynk.hmis.warehouse.notification.business.service.ITemplateService;


@Component
public class NotificationEngineContext implements INotificationEngineContext{

	@Autowired
	ITemplateService templateService;
	
	@Autowired
	ICarrierService carrierService;

	
	public ICarrierService getCarrierService() {
		return carrierService;
	}

	public void setCarrierService(ICarrierService carrierService) {
		this.carrierService = carrierService;
	}


	public ITemplateService getTemplateService() {
		return templateService;
	}

	public void setTemplateService(ITemplateService templateService) {
		this.templateService = templateService;
	}
	
	

}
