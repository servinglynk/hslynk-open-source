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
		entity.setAddress1(shelter.getAddress1());
		entity.setAddress2(shelter.getAddress2());
		entity.setCity(shelter.getCity());
		entity.setState(shelter.getState());
		entity.setZipcode(shelter.getZipcode());
		entity.setLatitude(shelter.getLatitude());
		entity.setLongitude(shelter.getLongitude());
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
		model.setAddress1(entity.getAddress1());
		model.setAddress2(entity.getAddress2());
		model.setCity(entity.getCity());
		model.setState(entity.getState());
		model.setZipcode(entity.getZipcode());
		model.setLatitude(entity.getLatitude());
		model.setLongitude(entity.getLongitude());
		return model;
	}

}
