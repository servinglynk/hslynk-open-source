package com.servinglynk.hmis.warehouse.base.service.converter;

import java.util.ArrayList;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.ClientConsentEntityModel;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequest;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentStatus;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentStatusEntity;

public class ClientConsentRequestConverter {

	public static ClientConsentRequestEntity modelToEntity(ClientConsentRequest model,ClientConsentRequestEntity entity){
		if(entity==null) entity = new ClientConsentRequestEntity();
		entity.setClientId(model.getClientId());
		entity.setStartTime(model.getStartTime());
		entity.setEndTime(model.getEndTime());
		entity.setEntityGroup(model.getEntityGroup());
		return entity;
	}

	public static ClientConsentRequest entityToModel(ClientConsentRequestEntity entity){
		ClientConsentRequest model = new ClientConsentRequest();
		model.setClientId(entity.getClientId());
		model.setStartTime(entity.getStartTime());
		model.setEndTime(entity.getEndTime());
		model.setStatus(entity.getStatus());
		model.setId(entity.getId());

		return model;
	}

	
	
	public static ClientConsentRequestEntitiesEntity modelToEntity(ClientConsentEntityModel model,ClientConsentRequestEntitiesEntity entity){
		if(entity ==null) entity = new ClientConsentRequestEntitiesEntity();		
		entity.setConsentEntityId(model.getConsentEntityId());
		entity.setConsentTypeId(model.getConsentTypeId());
		
		return entity;
	}
	
	
	public static ClientConsentStatusEntity entityToModel(ClientConsentStatus model,ClientConsentStatusEntity entity){
		if(entity==null) entity = new ClientConsentStatusEntity();
		entity.setApprovalStatus(model.getApprovalStatus());
		entity.setApprovalStatusEffectiveFromDate(model.getApprovalStatusEffectiveFromDate());
		entity.setApprovalStatusEffectiveToDate(model.getApprovalStatusEffectiveToDate());
		return entity;
	}
	
	
	public static ClientConsentEntityModel entityToModel(ClientConsentRequestEntitiesEntity entity){
		ClientConsentEntityModel model = new 		ClientConsentEntityModel();
		model.setId(entity.getId());
		model.setConsentEntityId(entity.getConsentEntityId());
		model.setConsentTypeId(entity.getConsentTypeId());
		
		return model;
	}
	
	public static ClientConsentEntity consentRequestToConsent(ClientConsentRequestEntity entity, String username){
		ClientConsentEntity clientConsentEntity = new ClientConsentEntity();
		clientConsentEntity.setClientId(entity.getClientId());

		clientConsentEntity.setStartTime(entity.getStartTime());
		clientConsentEntity.setEndTime(entity.getEndTime());
		clientConsentEntity.setProjectGroupCode(entity.getProjectGroupCode());
		return clientConsentEntity;
	}
}