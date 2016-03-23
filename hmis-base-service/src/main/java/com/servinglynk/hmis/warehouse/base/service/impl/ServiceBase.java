package com.servinglynk.hmis.warehouse.base.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.base.service.Service;
import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;

public abstract class ServiceBase implements Service {

	/** Logger for this class and subclasses */
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected BaseDaoFactoryImpl daoFactory;

	@Autowired
	protected BaseServiceFactory serviceFactory;

	public BaseDaoFactoryImpl getParentDaoFactory() {
		return daoFactory;
	}

	public void setParentDaoFactory(BaseDaoFactoryImpl daoFactory) {
		this.daoFactory = daoFactory;
	}


	public BaseServiceFactory getParentServiceFactory() {
		return serviceFactory;
	}

	public void setParentServiceFactory(BaseServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
}
