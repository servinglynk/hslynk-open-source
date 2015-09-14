package com.servinglynk.hmis.warehouse.sync.business.service.core;

import com.servinglynk.hmis.warehouse.sync.service.ISyncService;

public interface ISyncParentServiceFactory {
	ISyncService getSyncService();
}
