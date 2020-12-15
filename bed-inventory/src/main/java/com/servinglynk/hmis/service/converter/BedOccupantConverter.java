package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.model.BedOccupant;

public class BedOccupantConverter {

	public static BedOccupantEntity modelToEntity(BedOccupant bedUnit, BedOccupantEntity entity) {
		if(entity == null) {
			entity = new BedOccupantEntity();
		}
		entity.setIsActive(bedUnit.getIsActive());
		entity.setOccupancyEndDate(bedUnit.getOccupancyEndDate());
		entity.setOccupancyStartDate(bedUnit.getOccupancyStartDate());
		return entity;
	}

	public static BedOccupant entityToModel(BedOccupantEntity entity) {
		BedOccupant model = new BedOccupant();
		model.setIsActive(entity.getIsActive());
		model.setOccupancyEndDate(entity.getOccupancyEndDate());
		model.setOccupancyStartDate(entity.getOccupancyStartDate());
		model.setClientId(entity.getClientId());
		model.setDedupClientId(entity.getDedupClientId());
		model.setEnrollmentId(entity.getEnrollemntId());
		model.setEnrollmentType(entity.getEnrollmentType());
		model.setId(entity.getId());
		return model;
	}

}
