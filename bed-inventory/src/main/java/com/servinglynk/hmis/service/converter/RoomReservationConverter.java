package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.RoomReservationEntity;
import com.servinglynk.hmis.model.RoomReservation;

public class RoomReservationConverter {

	public static RoomReservation entityToModel(RoomReservationEntity entity) {
		RoomReservation model = new RoomReservation();
		model.setEndDate(entity.getReservationEndDateDate());
		model.setStartDate(entity.getReservationStateDate());
		model.setReservedClientId(entity.getReservedCleintId());
		model.setReservedHouseholdId(entity.getReservedHouseholdId());
		if(entity.getRoom()!=null) model.setRoom(RoomConverter.entityToModel(entity.getRoom()));
		model.setId(entity.getId());
		return model;
	}

	public static RoomReservationEntity modelToEntity(RoomReservation model, RoomReservationEntity entity) {
		if(entity == null) entity = new RoomReservationEntity();
		if(model.getEndDate()!=null) entity.setReservationEndDateDate(model.getEndDate());
		if(model.getStartDate()!=null) entity.setReservationStateDate(model.getStartDate());
		if(model.getReservedClientId()!=null) entity.setReservedCleintId(model.getReservedClientId());
		if(model.getReservedHouseholdId()!=null) entity.setReservedHouseholdId(model.getReservedHouseholdId());
		return entity;
	}

}
