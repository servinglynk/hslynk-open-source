package com.servinglynk.hmis.service.converter;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.model.BedUnit;

public class BedUnitConverter {

	public static BedUnitEntity modelToEntity(BedUnit bedUnit, BedUnitEntity bedUnitEntity) {
		if(bedUnitEntity == null) bedUnitEntity = new BedUnitEntity();
		if(bedUnit.getOccupancy()!=null) bedUnitEntity.setOccupancy(bedUnit.getOccupancy());
		if(bedUnit.getOccupantCapacity()!=null) bedUnitEntity.setOccupantCapacity(bedUnit.getOccupantCapacity());
		if(bedUnit.getOverflow()!=null) bedUnitEntity.setOverflow(bedUnit.getOverflow());
		return bedUnitEntity;
	}

	public static BedUnit entityToModel(BedUnitEntity bedUnitEntity) {
		BedUnit model =new BedUnit();
		model.setOccupancy(bedUnitEntity.getOccupancy());
		model.setOccupantCapacity(bedUnitEntity.getOccupantCapacity());
		model.setOverflow(bedUnitEntity.getOverflow());
		model.setId(bedUnitEntity.getId());
		model.setRoom(RoomConverter.entityToModel(bedUnitEntity.getRoom()));
		return model;
	}

}
