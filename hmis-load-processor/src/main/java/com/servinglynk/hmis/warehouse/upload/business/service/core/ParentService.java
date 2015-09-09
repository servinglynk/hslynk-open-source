package com.servinglynk.hmis.warehouse.upload.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;

@Component
public  class ParentService  implements IParentService{
	
	@Autowired
	protected IParentServiceFactory serviceFactory;
	
	@Autowired
	protected ParentDaoFactory daoFactory;
	
	

	
	public ParentDaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(ParentDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	
	public IParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(IParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	



	
}
