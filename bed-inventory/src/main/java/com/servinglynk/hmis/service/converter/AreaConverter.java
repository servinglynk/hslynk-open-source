package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.AreaEntity;
import com.servinglynk.hmis.model.AreaModel;

public class AreaConverter {

	public static AreaEntity modelToEntity(AreaModel area, AreaEntity entity) {
		if(entity==null) {
			entity = new AreaEntity();
		}
		if(area.getDescription()!=null) entity.setDescription(area.getDescription());
		if(area.getName()!=null) entity.setName(area.getName());
		if(area.getIsActive()!=null) entity.setIsActive(area.getIsActive());
		if(area.getOccupantCapacity()!=null) entity.setOccupantCapacity(area.getOccupantCapacity());
		return entity;
	}

	public static AreaModel entityToModel(AreaEntity entity) {
		AreaModel model = new AreaModel();
		model.setDescription(entity.getDescription());
		model.setName(entity.getName());
		model.setIsActive(entity.getIsActive());
		model.setOccupantCapacity(entity.getOccupantCapacity());
		model.setId(entity.getId());
		model.setShelter(ShelterConverter.entityToModel(entity.getShelter(),false));
		return model;
	}

}
