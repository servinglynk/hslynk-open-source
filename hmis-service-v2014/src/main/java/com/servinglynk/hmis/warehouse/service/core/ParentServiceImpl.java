package com.servinglynk.hmis.warehouse.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public  class ParentServiceImpl  implements ParentService{
	
	@Autowired
	protected ParentServiceFactory serviceFactory;

	public ParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}


	
}
