package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.HousingUnitOccupantEntity;
import com.servinglynk.hmis.model.HousingUnitOccupant;

public class HousingUnitOccupantConverter {

	public static HousingUnitOccupant entityToModel(HousingUnitOccupantEntity entity) {
		HousingUnitOccupant model = new HousingUnitOccupant();
		model.setClientId(entity.getClientId());
		model.setEndDate(entity.getOccupancyEndDate());
		model.setStartDate(entity.getOccupancyStartDate());
		model.setId(entity.getId());
		model.setHousingUnit(HousingUnitConverter.entityToModel(entity.getHousingUnit()));
		return model;
	}

	public static HousingUnitOccupantEntity modelToEntity(HousingUnitOccupant model,
			HousingUnitOccupantEntity entity) {
		if(entity == null) entity = new HousingUnitOccupantEntity();
		
		entity.setClientId(model.getClientId());
		entity.setOccupancyEndDate(model.getEndDate());
		entity.setOccupancyStartDate(model.getStartDate());

		return entity;
	}

}
