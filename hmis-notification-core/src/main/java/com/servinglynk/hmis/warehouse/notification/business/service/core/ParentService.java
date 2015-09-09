package com.servinglynk.hmis.warehouse.notification.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.IParentDaoFactory;

@Component
public  class ParentService  implements IParentService{
	
	@Autowired
	protected IParentServiceFactory serviceFactory;
	
	public IParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(IParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	public IParentDaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(IParentDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Autowired
	protected IParentDaoFactory daoFactory;
	
	


	



	
}
