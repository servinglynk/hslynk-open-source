package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.AreaEntity;
import com.servinglynk.hmis.model.AreaModel;

public class AreaConverter {

	public static AreaEntity modelToEntity(AreaModel area, AreaEntity entity) {
		if(entity==null) {
			entity = new AreaEntity();
		}
		entity.setDescription(area.getDescription());
		entity.setName(area.getName());
		entity.setIsActive(area.getIsActive());
		entity.setOccupantCapacity(area.getOccupantCapacity());
		return entity;
	}

	public static AreaModel entityToModel(AreaEntity entity) {
		AreaModel model = new AreaModel();
		model.setDescription(entity.getDescription());
		model.setName(entity.getName());
		model.setIsActive(entity.getIsActive());
		model.setOccupantCapacity(entity.getOccupantCapacity());
		model.setId(entity.getId());
		model.setShelter(ShelterConverter.entityToModel(entity.getShelter()));
		return model;
	}

}
