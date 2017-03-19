package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.model.base.ServiceStatus;

public class ServiceStatusDaoImpl extends QueryExecutorImpl implements
		ServiceStatusDao {

	
	public ServiceStatus create(ServiceStatus serviceStatus){
		insert(serviceStatus);
		return serviceStatus;
	}
	
}
