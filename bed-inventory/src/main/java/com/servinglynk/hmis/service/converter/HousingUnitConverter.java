package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.HousingUnitEntity;
import com.servinglynk.hmis.model.HousingUnit;

public class HousingUnitConverter {

	public static HousingUnitEntity modelToEntity(HousingUnit model, HousingUnitEntity entity) {
		if(entity == null) entity = new HousingUnitEntity();
		entity.setDescription(model.getDescription());
		entity.setOccupantCapacity(model.getOccupantCapacity());
		entity.setName(model.getName());
		entity.setProjectId(entity.getProjectId());
		entity.setProjectType(model.getProjectType());
		
		return entity;
	}

	public static HousingUnit entityToModel(HousingUnitEntity entity) {
		HousingUnit model = new HousingUnit();
		
		model.setDescription(entity.getDescription());
		model.setOccupantCapacity(entity.getOccupantCapacity());
		model.setName(entity.getName());
		model.setProjectId(entity.getProjectId());
		model.setProjectType(entity.getProjectType());
		model.setId(entity.getId());
		if(entity.getShelter() != null) model.setShelter(ShelterConverter.entityToModel(entity.getShelter()));
		return model;
	}

}
