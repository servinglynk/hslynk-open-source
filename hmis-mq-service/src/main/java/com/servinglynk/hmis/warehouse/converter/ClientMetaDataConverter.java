package com.servinglynk.hmis.warehouse.converter;

import java.time.LocalDateTime;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.entity.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;

public class ClientMetaDataConverter {

	public static ClientMetaDataEntity modelToEntity(ClientMetaDataEntity entity,ClientMetaDataModel model) {
		if(entity==null) {
			entity = new ClientMetaDataEntity();
			entity.setId(UUID.randomUUID());
			entity.setDateCreated(LocalDateTime.now());
		}
		entity.setDateUpdated(LocalDateTime.now());		
		if(model.getAdditionalInfo()!=null) entity.setAdditionalInfo(model.getAdditionalInfo());
		if(model.getClientDedupId()!=null) entity.setClientDedupId(model.getClientDedupId());
		if(model.getClientId()!=null) entity.setClientId(model.getClientId());
		if(model.getDate()!=null) entity.setDate(model.getDate());
		if(model.getMetaDataIdentifier()!=null) entity.setMetaDataIdentifier(model.getMetaDataIdentifier());
		if(model.getProjectGroupCode()!=null) entity.setProjectGroupCode(model.getProjectGroupCode());
		if(model.getType()!=null) entity.setType(model.getType());
		if(model.getUserId()!=null) entity.setUserId(model.getUserId());
		return entity;
	}
	
}
