package com.servinglynk.hmis.warehouse.sync.service;

import com.servinglynk.hmis.warehouse.model.live.Sync;
import com.servinglynk.hmis.warehouse.sync.business.service.core.ISyncParentService;


public interface ISyncService extends ISyncParentService {

	public void createSyncInit();
	public Sync performSync() throws Exception;
}
