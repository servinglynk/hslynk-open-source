package com.servinglynk.hmis.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactoryImpl implements ServiceFactory {

	@Autowired private ClientMetaDataService clientMetaDataService;
	
	@Autowired private ClientManagementService clientManagementService;

	public ClientMetaDataService getClientMetaDataService() {
		return clientMetaDataService;
	}

	public void setClientMetaDataService(ClientMetaDataService clientMetaDataService) {
		this.clientMetaDataService = clientMetaDataService;
	}

	public ClientManagementService getClientManagementService() {
		return clientManagementService;
	}

	public void setClientManagementService(ClientManagementService clientManagementService) {
		this.clientManagementService = clientManagementService;
	}
}