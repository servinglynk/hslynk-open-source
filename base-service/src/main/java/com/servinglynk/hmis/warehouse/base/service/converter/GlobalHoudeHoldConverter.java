package com.servinglynk.hmis.warehouse.base.service.converter;

import java.time.LocalDateTime;

import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHold;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHoldMap;
import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldMapEntity;

public class GlobalHoudeHoldConverter {

	
	public static GlobalHouseHoldMap entityToModel(GlobalHouseHoldMapEntity entity) {
		GlobalHouseHoldMap model = new GlobalHouseHoldMap();
		model.setDateCreated(entity.getDateCreated());
		model.setDateUpdated(entity.getDateUpdated());
		model.setHmisHouseHoldId(entity.getHmisHouseHoldId());
		model.setGenericHouseHoldId(entity.getGenericHouseHoldId());
		model.setId(entity.getId());		
		if(entity.getHmisHouseHoldId()!=null) {
			model.setLink("/hmis-clientapi/rest/"+model.getShemaYear()+"/hmishouseholds/"+entity.getHmisHouseHoldId());
		}
		return model;
	}
	
	
	public static GlobalHouseHold entityToModel(GlobalHouseHoldEntity entity) {
		GlobalHouseHold model = new GlobalHouseHold();
		model.setDateCreated(entity.getDateCreated());
		model.setDateUpdated(entity.getDateUpdated());
		model.setId(entity.getId());		
		return model;
	}
	
	public static GlobalHouseHoldMapEntity  modelToEntity(GlobalHouseHoldMapEntity entity,GlobalHouseHoldMap model) {
		if(entity==null) {
			entity = new GlobalHouseHoldMapEntity();
			entity.setDateCreated(LocalDateTime.now());
		}
		entity.setGenericHouseHoldId(model.getGenericHouseHoldId());
		entity.setHmisHouseHoldId(model.getHmisHouseHoldId());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setSchemaYear(model.getShemaYear());
		return entity;
	}
}
