package com.servinglynk.hmis.warehouse.sync.service;

import com.servinglynk.hmis.warehouse.sync.business.service.core.ISyncParentService;


public interface ISyncWorker  extends ISyncParentService  {
	
	
	
	public void processWorkerLine() throws Exception;
	

}
