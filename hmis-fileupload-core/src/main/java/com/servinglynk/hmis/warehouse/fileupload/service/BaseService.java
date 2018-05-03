package com.servinglynk.hmis.warehouse.fileupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


public abstract class BaseService  {
	

	@Autowired
	protected FileUploadRegistry daoRegistry;
	
	@Autowired
	protected Environment environment;
	

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public FileUploadRegistry getDaoRegistry() {
		return daoRegistry;
	}

	public void setDaoRegistry(FileUploadRegistry daoRegistry) {
		this.daoRegistry = daoRegistry;
	}
	
}