package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.base.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.base.ServiceApiMethodEntity;

public interface ApiMethodDao {
	
	ApiMethodEntity findByExternalId(String apiId);
	public ApiGroupEntity getApiGroup();
	public ApiMethodEntity createApiMethod(ApiMethodEntity apiMethodEntity);
	public ServiceApiMethodEntity createMapServiceWithApi(ServiceApiMethodEntity serviceApiMethodEntity);
	public List<ApiGroupEntity> getApiMethods();
}
