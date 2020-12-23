package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.BedUnitReservationEntity;
import com.servinglynk.hmis.model.BedUnitReservation;

public class BedUnitReservationConverter {

	public static BedUnitReservationEntity modelToEntity(BedUnitReservation room, BedUnitReservationEntity entity) {
		if(entity == null) entity = new BedUnitReservationEntity();
		if(room.getEndDate()!=null) entity.setReservationEndDateDate(room.getEndDate());
		if(room.getStartDate()!=null) entity.setReservationStateDate(room.getStartDate());
		if(room.getReservedClientId()!=null) entity.setReservedCleintId(room.getReservedClientId());
		if(room.getReservedHouseholdId()!=null)entity.setReservedHouseholdId(room.getReservedHouseholdId());
		return entity;
	}

	public static BedUnitReservation entityToModel(BedUnitReservationEntity entity) {
		BedUnitReservation model = new BedUnitReservation();
		model.setEndDate(entity.getReservationEndDateDate());
		model.setStartDate(entity.getReservationStateDate());
		model.setReservedClientId(entity.getReservedCleintId());
		model.setReservedHouseholdId(entity.getReservedHouseholdId());
		if(entity.getBedUnit()!=null) model.setBedUnit(BedUnitConverter.entityToModel(entity.getBedUnit()));
		model.setId(entity.getId());
		return model;
	}

}
