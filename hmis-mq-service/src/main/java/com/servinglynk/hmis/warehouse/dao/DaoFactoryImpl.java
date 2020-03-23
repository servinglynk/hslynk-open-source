package com.servinglynk.hmis.warehouse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.repository.ClientMetaDataRepository;

@Component
public class DaoFactoryImpl implements DaoFactory {

	@Autowired private ClientMetaDataRepository clientMetaDataRepository;
	
	@Autowired private ClientManagementDao clientManagementDao;
	
	@Autowired private GlobalHouseHoldDao globalHouseHoldDao;

	public ClientMetaDataRepository getClientMetaDataRepository() {
		return clientMetaDataRepository;
	}

	public void setClientMetaDataRepository(ClientMetaDataRepository clientMetaDataRepository) {
		this.clientMetaDataRepository = clientMetaDataRepository;
	}

	public ClientManagementDao getClientManagementDao() {
		return clientManagementDao;
	}

	public void setClientManagementDao(ClientManagementDao clientManagementDao) {
		this.clientManagementDao = clientManagementDao;
	}

	public GlobalHouseHoldDao getGlobalHouseHoldDao() {
		return globalHouseHoldDao;
	}

	public void setGlobalHouseHoldDao(GlobalHouseHoldDao globalHouseHoldDao) {
		this.globalHouseHoldDao = globalHouseHoldDao;
	}
}