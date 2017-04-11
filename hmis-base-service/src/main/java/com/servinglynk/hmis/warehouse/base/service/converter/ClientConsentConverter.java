package com.servinglynk.hmis.warehouse.base.service.converter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentEntityModel;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.SessionEntity;

public class ClientConsentConverter {

	public static ClientConsentEntity modelToEntity(ClientConsent model,ClientConsentEntity entity){
		if(entity==null) entity = new ClientConsentEntity();
		entity.setClientId(model.getClientId());
		entity.setStartTime(model.getStartTime());
		entity.setEndTime(model.getEndTime());
		entity.setConsentDocument(model.getConsentDocumentLink());
		entity.setEntityGroup(model.getEntityGroup());
		return entity;
	}

	public static ClientConsent entityToModel(ClientConsentEntity entity){
		ClientConsent model = new ClientConsent();
		model.setClientId(entity.getClientId());
		model.setStartTime(entity.getStartTime());
		model.setEndTime(entity.getEndTime());
		model.setConsentDocumentLink(entity.getConsentDocument());
		model.setStatus(entity.getStatus());
		model.setId(entity.getId());
		return model;
	}

	
	
	public static ClientConsentEntitiesEntity modelToEntity(ClientConsentEntityModel model,ClientConsentEntitiesEntity entity){
		if(entity ==null) entity = new ClientConsentEntitiesEntity();		
		entity.setConsentEntityId(model.getConsentEntityId());
		entity.setConsentTypeId(model.getConsentTypeId());
		
		return entity;
	}
	
	
	public static ClientConsentEntityModel entityToModel(ClientConsentEntitiesEntity entity){
		ClientConsentEntityModel model = new 		ClientConsentEntityModel();
		model.setId(entity.getId());
		model.setConsentEntityId(entity.getConsentEntityId());
		model.setConsentTypeId(entity.getConsentTypeId());
		
		return model;
	}
	
}