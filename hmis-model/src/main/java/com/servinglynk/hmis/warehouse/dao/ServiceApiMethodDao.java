package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.ServiceApiMethodEntity;

public interface ServiceApiMethodDao {

	
	public int deleteByServiceId(UUID serviceId);
	ServiceApiMethodEntity create(ServiceApiMethodEntity serviceApiMethod);
	public ServiceApiMethodEntity findByServiceIdAndApiMethodId(UUID serviceId, UUID apiMethodId);
	public int deleteApiMethodsByServiceId(UUID serviceId);
	
}
