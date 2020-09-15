package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.model.BedUnit;
import com.servinglynk.hmis.model.BedUnits;
import com.servinglynk.hmis.service.converter.BedUnitConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class BedUnitsServiceImpl extends BaseService implements BedUnitService {

	@Transactional
	public BedUnit createBedUnit(BedUnit bedUnit) {
		RoomEntity roomEntity =  daoFactory.getRoomRepository().findOne(bedUnit.getRoom().getId());
		if(roomEntity == null) throw new ResourceNotFoundException("Room "+bedUnit.getRoom().getId()+" not found");
		BedUnitEntity entity = BedUnitConverter.modelToEntity(bedUnit,null);
		entity.setRoom(roomEntity);
		daoFactory.getBedUnitRepository().save(entity);
		bedUnit.setId(entity.getId());
		return bedUnit;
	}
	
	@Transactional
	public void updateBedUnit(BedUnit bedUnit) {
		BedUnitEntity entity =  daoFactory.getBedUnitRepository().findOne(bedUnit.getId());
		if(entity == null) throw new ResourceNotFoundException("BedUnit "+bedUnit.getId()+" not found");
		entity = BedUnitConverter.modelToEntity(bedUnit,entity);
		daoFactory.getBedUnitRepository().save(entity);
	}
	
	@Transactional
	public void deleteBedUnit(UUID bedUnitId) {
		BedUnitEntity entity =  daoFactory.getBedUnitRepository().findOne(bedUnitId);
		if(entity == null) throw new ResourceNotFoundException("BedUnit "+bedUnitId+" not found");
		daoFactory.getBedUnitRepository().delete(entity);
	}
	
	@Transactional
	public BedUnit getBedUnit(UUID bedUnitId) {
		BedUnitEntity entity =  daoFactory.getBedUnitRepository().findOne(bedUnitId);
		if(entity == null) throw new ResourceNotFoundException("BedUnit "+bedUnitId+" not found");		
		return BedUnitConverter.entityToModel(entity);
	}
	
	@Transactional
	public BedUnits getBedUnits(Pageable pageable) {
		BedUnits bedUnits = new BedUnits();
		Page<BedUnitEntity> entityPage = daoFactory.getBedUnitRepository().findAll(pageable);
		for(BedUnitEntity bedUnitEntity : entityPage.getContent()) {
			bedUnits.addBedUnit(BedUnitConverter.entityToModel(bedUnitEntity));
		}
		return bedUnits;
	}	
}