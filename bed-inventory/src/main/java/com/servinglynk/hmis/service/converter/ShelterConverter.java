package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.ShelterEntity;
import com.servinglynk.hmis.model.ShelterModel;

public class ShelterConverter {

	public static ShelterEntity modelToEntity(ShelterModel shelter, ShelterEntity entity) {
		if(entity == null) {
			entity = new ShelterEntity();
		}
		entity.setAddress(shelter.getAddress());
		entity.setDescription(shelter.getDescription());
		entity.setName(shelter.getName());
		entity.setOccupantCapacity(shelter.getOccupantCapacity());
		entity.setProjectId(shelter.getProjectId());
		entity.setProjectType(shelter.getProjectType());
		entity.setUrl(shelter.getUrl());
		return entity;
	}

	public static ShelterModel entityToModel(ShelterEntity entity) {
		ShelterModel model = new ShelterModel();
		
		model.setAddress(entity.getAddress());
		model.setDescription(entity.getDescription());
		model.setName(entity.getName());
		model.setOccupantCapacity(entity.getOccupantCapacity());
		model.setProjectId(entity.getProjectId());
		model.setProjectType(entity.getProjectType());
		model.setUrl(entity.getUrl());
		model.setId(entity.getId());
		return model;
	}

}
