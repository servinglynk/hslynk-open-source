package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.live.ServiceStatus;

public class ServiceStatusDaoImpl extends QueryExecutorImpl implements
		ServiceStatusDao {

	
	public ServiceStatus create(ServiceStatus serviceStatus){
		insert(serviceStatus);
		return serviceStatus;
	}
	
}
