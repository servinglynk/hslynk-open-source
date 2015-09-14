package com.servinglynk.hmis.warehouse.sync.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.sync.service.ISyncService;
import com.servinglynk.hmis.warehouse.sync.service.ISyncWorker;



public class SyncParentServiceFactory  implements ISyncParentServiceFactory {

	@Autowired
	ISyncService syncService;

	public ISyncService getSyncService() {
		return syncService;
	}
	
	@Autowired
	ISyncWorker syncWorker;

	public ISyncWorker getSyncWorker() {
		return syncWorker;
	}
}

