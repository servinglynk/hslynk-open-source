package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.HousingUnitEntity;
import com.servinglynk.hmis.model.HousingUnit;

public class HousingUnitConverter {

	public static HousingUnitEntity modelToEntity(HousingUnit model, HousingUnitEntity entity) {
		if(entity == null) entity = new HousingUnitEntity();
		if(model.getDescription()!=null) entity.setDescription(model.getDescription());
		if(model.getOccupantCapacity()!=null) entity.setOccupantCapacity(model.getOccupantCapacity());
		if(model.getName()!=null) entity.setName(model.getName());
		if(model.getProjectId()!=null) entity.setProjectId(entity.getProjectId());
		if(model.getProjectType()!=null) entity.setProjectType(model.getProjectType());
		
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
		if(entity.getShelter() != null) model.setShelter(ShelterConverter.entityToModel(entity.getShelter(),false));
		return model;
	}

}
