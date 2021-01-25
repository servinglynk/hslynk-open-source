package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.entity.RoomOccupantEntity;
import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.RoomOccupant;

public class RoomOccupantConverter {

	public static RoomOccupantEntity modelToEntity(RoomOccupant model, RoomOccupantEntity entity) {
		if(entity == null) {
			entity = new RoomOccupantEntity();
		}
		if(model.getIsActive()!=null) entity.setIsActive(model.getIsActive());
		if(model.getEndDate()!=null) entity.setOccupancyEndDate(model.getEndDate());
		if(model.getStartDate()!=null) entity.setOccupancyStartDate(model.getStartDate());
		if(model.getCheckoutDate()!=null) entity.setCheckOutDate(model.getCheckoutDate());
		return entity;
	}

	public static RoomOccupant entityToModel(RoomOccupantEntity entity) {
		RoomOccupant model = new RoomOccupant();
		model.setIsActive(entity.getIsActive());
		model.setEndDate(entity.getOccupancyEndDate());
		model.setStartDate(entity.getOccupancyStartDate());
		model.setClientId(entity.getClientId());
		model.setDedupClientId(entity.getDedupClientId());
		model.setEnrollmentId(entity.getEnrollemntId());
		model.setEnrollmentType(entity.getEnrollmentType());
		model.setCheckoutDate(entity.getCheckOutDate());
		model.setId(entity.getId());
		if(entity.getRoom()!=null) model.setRoom(RoomConverter.entityToModel(entity.getRoom()));
		return model;
	}

}
