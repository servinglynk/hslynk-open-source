package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.core.model.ApiMethod;

public interface ApiMethodService {

	
	public ApiMethod createApiMehod(ApiMethod apiMethod);
	public void mapServiceWithApiMethod(String serviceId,String apiMethodId);
}
