package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.entity.ServiceApiMethodEntity;

public interface ServiceApiMethodDao {

	
	public int deleteByServiceId(UUID serviceId);
	ServiceApiMethodEntity create(ServiceApiMethodEntity serviceApiMethod);
	public ServiceApiMethodEntity findByServiceIdAndApiMethodId(UUID serviceId, UUID apiMethodId);
	
}
