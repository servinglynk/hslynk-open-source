package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.BedUnitReservationEntity;
import com.servinglynk.hmis.model.BedUnitReservation;

public class BedUnitReservationConverter {

	public static BedUnitReservationEntity modelToEntity(BedUnitReservation room, BedUnitReservationEntity entity) {
		if(entity == null) entity = new BedUnitReservationEntity();
		entity.setReservationEndDateDate(room.getReservationEndDateDate());
		entity.setReservationStateDate(room.getReservationStateDate());
		entity.setReservedCleintId(room.getReservedCleintId());
		entity.setReservedHouseholdId(room.getReservedHouseholdId());
		return entity;
	}

	public static BedUnitReservation entityToModel(BedUnitReservationEntity entity) {
		BedUnitReservation model = new BedUnitReservation();
		model.setReservationEndDateDate(entity.getReservationEndDateDate());
		model.setReservationStateDate(entity.getReservationStateDate());
		model.setReservedCleintId(entity.getReservedCleintId());
		model.setReservedHouseholdId(entity.getReservedHouseholdId());
		model.setBedUnit(BedUnitConverter.entityToModel(entity.getBedUnit()));
		model.setId(entity.getId());
		return model;
	}

}
