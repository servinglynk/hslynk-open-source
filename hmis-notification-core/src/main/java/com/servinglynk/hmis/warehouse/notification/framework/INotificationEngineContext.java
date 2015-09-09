package com.servinglynk.hmis.warehouse.notification.framework;

import com.servinglynk.hmis.warehouse.notification.business.service.ICarrierService;
import com.servinglynk.hmis.warehouse.notification.business.service.ITemplateService;




public interface INotificationEngineContext{
	
	
	public ICarrierService getCarrierService();
	public ITemplateService getTemplateService();
	

}
