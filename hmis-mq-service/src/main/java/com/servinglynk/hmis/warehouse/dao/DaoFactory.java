package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.repository.ClientMetaDataRepository;

public interface DaoFactory {

	ClientMetaDataRepository getClientMetaDataRepository();
	ClientManagementDao getClientManagementDao();
	GlobalHouseHoldDao getGlobalHouseHoldDao();	
}