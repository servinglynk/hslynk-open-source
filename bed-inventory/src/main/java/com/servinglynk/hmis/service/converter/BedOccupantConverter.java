package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.model.BedOccupant;

public class BedOccupantConverter {

	public static BedOccupantEntity modelToEntity(BedOccupant bedUnit, BedOccupantEntity entity) {
		if(entity == null) {
			entity = new BedOccupantEntity();
		}
		if(bedUnit.getIsActive()!=null) entity.setIsActive(bedUnit.getIsActive());
		if(bedUnit.getEndDate()!=null) entity.setOccupancyEndDate(bedUnit.getEndDate());
		if(bedUnit.getStartDate()!=null) entity.setOccupancyStartDate(bedUnit.getStartDate());
		if(bedUnit.getCheckoutDate()!=null) entity.setCheckOutDate(bedUnit.getCheckoutDate());
		return entity;
	}

	public static BedOccupant entityToModel(BedOccupantEntity entity) {
		BedOccupant model = new BedOccupant();
		model.setIsActive(entity.getIsActive());
		model.setEndDate(entity.getOccupancyEndDate());
		model.setStartDate(entity.getOccupancyStartDate());
		model.setClientId(entity.getClientId());
		model.setDedupClientId(entity.getDedupClientId());
		model.setEnrollmentId(entity.getEnrollemntId());
		model.setEnrollmentType(entity.getEnrollmentType());
		model.setCheckoutDate(entity.getCheckOutDate());
		model.setId(entity.getId());
		if(entity.getBedUnit()!=null) model.setBedUnit(BedUnitConverter.entityToModel(entity.getBedUnit()));
		return model;
	}

}
