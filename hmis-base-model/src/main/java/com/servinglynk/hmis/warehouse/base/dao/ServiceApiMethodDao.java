package com.servinglynk.hmis.warehouse.base.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ServiceApiMethodEntity;

public interface ServiceApiMethodDao {
	ServiceApiMethodEntity create(ServiceApiMethodEntity serviceApiMethod);
	public ServiceApiMethodEntity findByServiceIdAndApiMethodId(UUID serviceId, UUID apiMethodId);
	public int deleteApiMethodsByServiceId(UUID serviceId);
	
}
