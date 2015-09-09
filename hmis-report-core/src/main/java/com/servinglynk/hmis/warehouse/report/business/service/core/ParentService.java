package com.servinglynk.hmis.warehouse.report.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.report.persistence.dao.core.IParentDaoFactory;

@Component
public  class ParentService  implements IParentService{
	
	@Autowired
	protected IParentServiceFactory serviceFactory;
	
	@Autowired
	protected IParentDaoFactory daoFactory;
	
	

	
	public IParentDaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(IParentDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	
	public IParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(IParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	



	
}
