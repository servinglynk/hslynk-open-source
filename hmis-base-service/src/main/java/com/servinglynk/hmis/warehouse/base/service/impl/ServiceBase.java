package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.base.service.Service;
import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.model.base.SessionEntity;

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
	
	public UUID getUser() {
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		if(authentication.getPrincipal()!=null){
			SessionEntity entity = (SessionEntity) authentication.getPrincipal();
			return entity.getAccount().getId();
		}
		return null;
	}
	
	public String getProjectGroup() {
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		if(authentication.getPrincipal()!=null){
			SessionEntity entity = (SessionEntity) authentication.getPrincipal();
			return entity.getAccount().getProjectGroupEntity().getProjectGroupCode();
		}
		return null;
	}
}