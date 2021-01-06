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
		if(model.getAddress1()!=null) entity.setAddress1(model.getAddress1());
		if(model.getAddress2()!=null) entity.setAddress2(model.getAddress2());
		if(model.getCity()!=null) entity.setCity(model.getCity());
		if(model.getState()!=null) entity.setState(model.getState());
		if(model.getZipcode()!=null) entity.setZipcode(model.getZipcode());
		if(model.getLatitude()!=null) entity.setLatitude(model.getLatitude());
		if(model.getLongitude()!=null) entity.setLongitude(model.getLongitude());
		
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
		model.setAddress1(entity.getAddress1());
		model.setAddress2(entity.getAddress2());
		model.setCity(entity.getCity());
		model.setState(entity.getState());
		model.setZipcode(entity.getZipcode());
		model.setLatitude(entity.getLatitude());
		model.setLongitude(entity.getLongitude());
		if(entity.getShelter() != null) model.setShelter(ShelterConverter.entityToModel(entity.getShelter(),false));
		return model;
	}

}
