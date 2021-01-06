package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.HousingUnitReservationEntity;
import com.servinglynk.hmis.model.HousingUnitReservation;

public class HousingUnitReservationConverter {

	public static HousingUnitReservation entityToModel(HousingUnitReservationEntity entity) {
		HousingUnitReservation model = new HousingUnitReservation();
		model.setEndDate(entity.getReservationEndDateDate());
		model.setStartDate(entity.getReservationStateDate());
		model.setReservedClientId(entity.getReservedCleintId());
		model.setReservedHouseholdId(entity.getReservedHouseholdId());
		if(entity.getHousingUnit()!=null) model.setHousingUnit(HousingUnitConverter.entityToModel(entity.getHousingUnit()));
		model.setId(entity.getId());
		return model;
	}

	public static HousingUnitReservationEntity modelToEntity(HousingUnitReservation model,
			HousingUnitReservationEntity entity) {
		if(entity == null) entity = new HousingUnitReservationEntity();
		if(model.getEndDate()!=null) entity.setReservationEndDateDate(model.getEndDate());
		if(model.getStartDate()!=null) entity.setReservationStateDate(model.getStartDate());
		if(model.getReservedClientId()!=null) entity.setReservedCleintId(model.getReservedClientId());
		if(model.getReservedHouseholdId()!=null) entity.setReservedHouseholdId(model.getReservedHouseholdId());
		return entity;
	}

}
