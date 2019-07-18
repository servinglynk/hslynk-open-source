package com.servinglynk.hmis.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactoryImpl implements ServiceFactory {

	@Autowired private ClientMetaDataService clientMetaDataService;

	public ClientMetaDataService getClientMetaDataService() {
		return clientMetaDataService;
	}

	public void setClientMetaDataService(ClientMetaDataService clientMetaDataService) {
		this.clientMetaDataService = clientMetaDataService;
	}
	
	
}
