package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.BedOccupants;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.BedOccupantConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class BedOccupantServiceImpl extends BaseService implements BedOccupantService {

	@Transactional
	public BedOccupant createBedOccupant(BedOccupant bedUnit) {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getBedUnit().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed unit not found");
		BedOccupantEntity entity = BedOccupantConverter.modelToEntity(bedUnit,null);
		entity.setClientId(bedUnit.getClientId());
		entity.setDedupClientId(validationService.validateCleintId(bedUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(bedUnit.getEnrollmentId()));
		entity.setEnrollemntId(bedUnit.getEnrollmentId());
		entity.setBedUnit(bedUnitEntity);
		daoFactory.getBedOccupantRepository().save(entity);
		bedUnit.setId(entity.getId());
		return bedUnit;
	}
	
	@Transactional
	public void updateBedOccupant(BedOccupant bedUnit) {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getBedUnit().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed unit not found");
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnit.getId()+" not found");
		entity = BedOccupantConverter.modelToEntity(bedUnit,entity);
		entity.setDedupClientId(validationService.validateCleintId(bedUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(bedUnit.getEnrollmentId()));
		daoFactory.getBedOccupantRepository().save(entity);
	}
	
	@Transactional
	public void deleteBedOccupant(UUID bedUnitId) {
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnitId+" not found");
		daoFactory.getBedOccupantRepository().delete(entity);
	}
	
	@Transactional
	public BedOccupant getBedOccupant(UUID bedUnitId) {
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnitId+" not found");		
		return BedOccupantConverter.entityToModel(entity);
	}
	
	@Transactional
	public BedOccupants getBedOccupants(UUID bedUnitId,Pageable pageable) {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed unit not found");
		BedOccupants bedUnits = new BedOccupants();
		Page<BedOccupantEntity> entityPage = daoFactory.getBedOccupantRepository().findByBedUnitAndDeleted(bedUnitEntity, false, pageable);
		for(BedOccupantEntity occupantEntity : entityPage.getContent()) {
			bedUnits.addBedOccupant(BedOccupantConverter.entityToModel(occupantEntity));
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        bedUnits.setPagination(pagination);
		return bedUnits;
	}	
}