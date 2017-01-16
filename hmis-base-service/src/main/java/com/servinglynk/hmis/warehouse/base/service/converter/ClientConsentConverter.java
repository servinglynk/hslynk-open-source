package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentEntityModel;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;

public class ClientConsentConverter {

	public static ClientConsentEntity modelToEntity(ClientConsent model,ClientConsentEntity entity){
		if(entity==null) entity = new ClientConsentEntity();
		entity.setClientId(model.getClientId());
		entity.setStartTime(model.getStartTime());
		entity.setEndTime(model.getEndTime());
		entity.setConsentDocument(model.getConsentDocumentLink());
		entity.setStatus(model.getStatus());

		for(ClientConsentEntityModel entityModel : model.getClientConsentEntities().getClientConsentEntities()){
			ClientConsentEntitiesEntity consentEntitiesEntity = ClientConsentConverter.modelToEntity(entityModel, null);
			consentEntitiesEntity.setClientConsentEntity(entity);
			entity.addConsentEntities(consentEntitiesEntity);
		}
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
		for(ClientConsentEntitiesEntity clientConsentEntitiesEntity : entity.getConsentEntities()){
			model.getClientConsentEntities().addClientConsentEntity(ClientConsentConverter.entityToModel(clientConsentEntitiesEntity));			
		}
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