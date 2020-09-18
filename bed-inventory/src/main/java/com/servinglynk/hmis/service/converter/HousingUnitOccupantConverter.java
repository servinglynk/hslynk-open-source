package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.HousingUnitOccupantEntity;
import com.servinglynk.hmis.model.HousingUnitOccupant;

public class HousingUnitOccupantConverter {

	public static HousingUnitOccupant entityToModel(HousingUnitOccupantEntity entity) {
		HousingUnitOccupant model = new HousingUnitOccupant();
		model.setClientId(entity.getClientId());
		model.setOccupancyEndDate(entity.getOccupancyEndDate());
		model.setOccupancyStartDate(entity.getOccupancyStartDate());
		model.setId(entity.getId());
		model.setHousingUnit(HousingUnitConverter.entityToModel(entity.getHousingUnit()));
		return null;
	}

	public static HousingUnitOccupantEntity modelToEntity(HousingUnitOccupant model,
			HousingUnitOccupantEntity entity) {
		if(entity == null) entity = new HousingUnitOccupantEntity();
		
		entity.setClientId(model.getClientId());
		entity.setOccupancyEndDate(model.getOccupancyEndDate());
		entity.setOccupancyStartDate(model.getOccupancyStartDate());

		return null;
	}

}
