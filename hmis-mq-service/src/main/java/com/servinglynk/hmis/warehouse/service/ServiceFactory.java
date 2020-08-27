package com.servinglynk.hmis.warehouse.service;

public interface ServiceFactory {

	ClientMetaDataService getClientMetaDataService() ;
	ClientManagementService getClientManagementService();
	GlobalHouseHoldService getGlobalHouseHoldService();
	EnrollmentService getEnrollmentService();
	HmisPostingService getHmisPostingService();
}
