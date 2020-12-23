package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.ShelterEntity;
import com.servinglynk.hmis.model.InventorySummary;
import com.servinglynk.hmis.model.ShelterModel;

public class ShelterConverter {

	public static ShelterEntity modelToEntity(ShelterModel shelter, ShelterEntity entity) {
		if(entity == null) {
			entity = new ShelterEntity();
		}
		if(shelter.getAddress()!=null) entity.setAddress(shelter.getAddress());
		if(shelter.getDescription()!=null) entity.setDescription(shelter.getDescription());
		if(shelter.getName()!=null) entity.setName(shelter.getName());
		if(shelter.getOccupantCapacity()!=null) entity.setOccupantCapacity(shelter.getOccupantCapacity());
		if(shelter.getProjectId()!=null) entity.setProjectId(shelter.getProjectId());
		if(shelter.getProjectType()!=null) entity.setProjectType(shelter.getProjectType());
		if(shelter.getUrl()!=null) entity.setUrl(shelter.getUrl());
		if(shelter.getAddress1()!=null) entity.setAddress1(shelter.getAddress1());
		if(shelter.getAddress2()!=null) entity.setAddress2(shelter.getAddress2());
		if(shelter.getCity()!=null) entity.setCity(shelter.getCity());
		if(shelter.getState()!=null) entity.setState(shelter.getState());
		if(shelter.getZipcode()!=null) entity.setZipcode(shelter.getZipcode());
		if(shelter.getLatitude()!=null) entity.setLatitude(shelter.getLatitude());
		if(shelter.getLongitude()!=null) entity.setLongitude(shelter.getLongitude());
		return entity;
	}

	public static ShelterModel entityToModel(ShelterEntity entity,Boolean includeSummary) {
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
		if(includeSummary) {
			InventorySummary summary = new InventorySummary();
			summary.setTotalRooms(entity.getTotalRooms());
			summary.setTotalBeds(entity.getTotalBeds());
			summary.setTotalAreas(entity.getTotalAreas());
			model.setSummary(summary);
		}
		return model;
	}

}
