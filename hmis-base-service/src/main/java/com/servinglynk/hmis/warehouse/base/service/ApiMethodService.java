package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodGroups;

public interface ApiMethodService {

	
	public ApiMethod createApiMehod(ApiMethod apiMethod);
	public void mapServiceWithApiMethod(String serviceId,String apiMethodId);
	public ApiMethodGroups getApiMethods();
	ApiMethod getApiMethod(String externalId);
}
