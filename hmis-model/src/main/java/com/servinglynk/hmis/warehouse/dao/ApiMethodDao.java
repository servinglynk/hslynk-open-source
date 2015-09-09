package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.entity.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.entity.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.entity.ServiceApiMethodEntity;

public interface ApiMethodDao {
	
	ApiMethodEntity findByExternalId(String apiId);
	public ApiGroupEntity getApiGroup();
	public ApiMethodEntity createApiMethod(ApiMethodEntity apiMethodEntity);
	public ServiceApiMethodEntity createMapServiceWithApi(ServiceApiMethodEntity serviceApiMethodEntity);

}
