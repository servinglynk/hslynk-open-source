package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodGroup;
import com.servinglynk.hmis.warehouse.core.model.ApiMethods;
import com.servinglynk.hmis.warehouse.model.v2014.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2014.ApiMethodEntity;

public class ApiMethodConverter {

	public static ApiMethod entityToModel(ApiMethodEntity entity){
		ApiMethod apiMethod=new ApiMethod();
		apiMethod.setType(entity.getType());
		apiMethod.setFriendlyName(entity.getFriendlyName());
		apiMethod.setAuthorizationMsg(entity.getAccountConsentMsg());
		apiMethod.setApiMethodId(entity.getExternalId());
		apiMethod.setExternalId(entity.getExternalId());
		return apiMethod;
	}
	
	
	public static ApiMethodGroup entityToModelFull(ApiGroupEntity entity){
		
		ApiMethodGroup apiMethodGroup = new ApiMethodGroup();
		apiMethodGroup.setDescription(entity.getDescription());
		apiMethodGroup.setFriendlyName(entity.getFriendlyName());
		apiMethodGroup.setExternalId(entity.getExternalId());
		apiMethodGroup.setMethodId(entity.getId());
		
		ApiMethods apiMethods = new ApiMethods();
				
		for(ApiMethodEntity methodEntity : entity.getApiMethods()){
			apiMethods.addApiMethod(entityToModel(methodEntity));
		}
		apiMethodGroup.setApiMethods(apiMethods);
		return apiMethodGroup;
	}
	
	public static ApiMethod convertToApiMethod(ApiMethodEntity pApiMethod) {
		
		ApiMethod apiMethod = new ApiMethod();
		apiMethod.setAuthorizationMsg(pApiMethod.getAccountConsentMsg());
		apiMethod.setDescription(pApiMethod.getDescription());
		apiMethod.setApiMethodId(pApiMethod.getExternalId());
		apiMethod.setFriendlyName(pApiMethod.getFriendlyName());
		apiMethod.setMethodSequence(pApiMethod.getAccountConsentMsgOrder());
		apiMethod.setType(pApiMethod.getType());
		
		return apiMethod;
	}
}
