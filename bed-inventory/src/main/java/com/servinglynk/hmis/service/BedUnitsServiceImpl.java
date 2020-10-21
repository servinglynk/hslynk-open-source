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
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.BedUnitConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class BedUnitsServiceImpl extends BaseService implements BedUnitService {

	@Transactional
	public BedUnit createBedUnit(BedUnit bedUnit) {
		RoomEntity roomEntity =  daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getRoom().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(roomEntity == null) throw new ResourceNotFoundException("Room "+bedUnit.getRoom().getId()+" not found");
		BedUnitEntity entity = BedUnitConverter.modelToEntity(bedUnit,null);
		entity.setRoom(roomEntity);
		daoFactory.getBedUnitRepository().save(entity);
		bedUnit.setId(entity.getId());
		return bedUnit;
	}
	
	@Transactional
	public void updateBedUnit(BedUnit bedUnit) {
		BedUnitEntity entity =  daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedUnit "+bedUnit.getId()+" not found");
		entity = BedUnitConverter.modelToEntity(bedUnit,entity);
		daoFactory.getBedUnitRepository().save(entity);
	}
	
	@Transactional
	public void deleteBedUnit(UUID bedUnitId) {
		BedUnitEntity entity =  daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedUnit "+bedUnitId+" not found");
		daoFactory.getBedUnitRepository().delete(entity);
	}
	
	@Transactional
	public BedUnit getBedUnit(UUID bedUnitId) {
		BedUnitEntity entity =  daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
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
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        bedUnits.setPagination(pagination);
		return bedUnits;
	}	
}