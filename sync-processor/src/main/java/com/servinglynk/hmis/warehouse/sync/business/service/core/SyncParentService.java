package com.servinglynk.hmis.warehouse.sync.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;

@Component
public  class SyncParentService  implements ISyncParentService{
	
	@Autowired
	protected ISyncParentServiceFactory serviceFactory;
	
	@Autowired
	protected ParentDaoFactory daoFactory;
	
	

	
	public ParentDaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(ParentDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	
	public ISyncParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ISyncParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	



	
}
