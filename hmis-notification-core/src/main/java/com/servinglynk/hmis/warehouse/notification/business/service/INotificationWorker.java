package com.servinglynk.hmis.warehouse.notification.business.service;

import com.servinglynk.hmis.warehouse.notification.business.service.core.IParentService;


public interface INotificationWorker  extends IParentService  {
	
	
	
	public void processWorkerLine() throws Exception;
	

}
