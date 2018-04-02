package com.servinglynk.hmis.warehouse.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;






import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.dao.ParentDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.service.Service;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;

public abstract class ServiceBase implements Service {

	/** Logger for this class and subclasses */
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected ParentDaoFactoryImpl daoFactory;

	@Autowired
	protected ParentServiceFactory serviceFactory;

	public ParentDaoFactory getParentDaoFactory() {
		return daoFactory;
	}

	public void setParentDaoFactory(ParentDaoFactoryImpl daoFactory) {
		this.daoFactory = daoFactory;
	}


	public ParentServiceFactory getParentServiceFactory() {
		return serviceFactory;
	}

	public void setParentServiceFactory(ParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
}
