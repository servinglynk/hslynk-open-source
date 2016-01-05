package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.live.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.ServiceApiMethodEntity;

public interface ApiMethodDao {
	
	ApiMethodEntity findByExternalId(String apiId);
	public ApiGroupEntity getApiGroup();
	public ApiMethodEntity createApiMethod(ApiMethodEntity apiMethodEntity);
	public ServiceApiMethodEntity createMapServiceWithApi(ServiceApiMethodEntity serviceApiMethodEntity);
	public List<ApiGroupEntity> getApiMethods();
}
