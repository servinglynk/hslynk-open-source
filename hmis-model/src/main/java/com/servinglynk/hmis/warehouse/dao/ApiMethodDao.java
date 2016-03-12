package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2014.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2014.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.v2014.ServiceApiMethodEntity;

public interface ApiMethodDao {
	
	ApiMethodEntity findByExternalId(String apiId);
	public ApiGroupEntity getApiGroup();
	public ApiMethodEntity createApiMethod(ApiMethodEntity apiMethodEntity);
	public ServiceApiMethodEntity createMapServiceWithApi(ServiceApiMethodEntity serviceApiMethodEntity);
	public List<ApiGroupEntity> getApiMethods();
}
