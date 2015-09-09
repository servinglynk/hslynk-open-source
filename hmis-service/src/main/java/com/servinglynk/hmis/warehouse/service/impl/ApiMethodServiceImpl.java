package com.servinglynk.hmis.warehouse.service.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.entity.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.entity.DeveloperServiceEntity;
import com.servinglynk.hmis.warehouse.entity.ServiceApiMethodEntity;
import com.servinglynk.hmis.warehouse.service.ApiMethodService;

public class ApiMethodServiceImpl extends ServiceBase implements ApiMethodService {

	@Transactional
	public ApiMethod createApiMehod(ApiMethod apiMethod){
		
		
		ApiMethodEntity apiMethodEntity = new ApiMethodEntity();
		apiMethodEntity.setAccountConsentMsg(apiMethod.getAuthorizationMsg());
		apiMethodEntity.setAccountConsentMsgOrder(apiMethod.getMethodSequence());
		apiMethodEntity.setFriendlyName(apiMethod.getFriendlyName());
		apiMethodEntity.setDescription(apiMethod.getDescription());
		apiMethodEntity.setType(apiMethod.getType());
		apiMethodEntity.initializeExternalId();		
		apiMethodEntity.setApiGroup(daoFactory.getApiMethodDao().getApiGroup());
		apiMethodEntity.setCreatedBy(Constants.AUDIT_USER_UNIT_TEST);
		apiMethodEntity.setCreatedAt(new Date());
		
		apiMethodEntity = daoFactory.getApiMethodDao().createApiMethod(apiMethodEntity);
		apiMethod.setExternalId(apiMethodEntity.getExternalId());
		
		return apiMethod;
		
	}
	
	
	@Transactional
	public void mapServiceWithApiMethod(String serviceId,String apiMethodId) {
		
		DeveloperServiceEntity  pService = daoFactory.getDeveloperServiceDao().findByExternalId(serviceId);
		
		ApiMethodEntity apiMethodEntity = daoFactory.getApiMethodDao().findByExternalId(apiMethodId);
		
		ServiceApiMethodEntity serviceApiMethodEntity = new ServiceApiMethodEntity();
		serviceApiMethodEntity.setApiMethod(apiMethodEntity);
		serviceApiMethodEntity.setService(pService);
		
		serviceApiMethodEntity.setCreatedAt(new Date());
		serviceApiMethodEntity.setCreatedBy(Constants.AUDIT_USER_UNIT_TEST);
		daoFactory.getApiMethodDao().createMapServiceWithApi(serviceApiMethodEntity);
		
		
		
	}
}
