package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.model.RoomModel;

public class RoomConverter {

	public static RoomEntity modelToEntity(RoomModel room, RoomEntity entity) {
		if(entity == null) entity = new RoomEntity();
		if(room.getName()!=null) entity.setName(room.getName());
		if(room.getOccupantCapacity()!=null) entity.setOccupantCapacity(room.getOccupantCapacity());
		return entity;
	}

	public static RoomModel entityToModel(RoomEntity entity) {
		RoomModel model = new RoomModel();
		model.setArea(AreaConverter.entityToModel(entity.getArea()));
		model.setName(entity.getName());
		model.setOccupantCapacity(entity.getOccupantCapacity());
		model.setShelter(ShelterConverter.entityToModel(entity.getShelter(),false));
		model.setId(entity.getId());
		return model;
	}

}
