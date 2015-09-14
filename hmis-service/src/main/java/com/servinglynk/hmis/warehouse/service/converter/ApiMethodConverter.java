package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.model.live.ApiMethodEntity;

public class ApiMethodConverter {

	public static ApiMethod entityToModel(ApiMethodEntity entity){
		ApiMethod apiMethod=new ApiMethod();
		apiMethod.setType(entity.getType());
		apiMethod.setFriendlyName(entity.getFriendlyName());
		apiMethod.setAuthorizationMsg(entity.getAccountConsentMsg());
		apiMethod.setExternalId(entity.getExternalId());
		return apiMethod;
	}
	
	
}
