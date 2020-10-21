package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.HousingUnitOccupantEntity;
import com.servinglynk.hmis.model.HousingUnitOccupant;
import com.servinglynk.hmis.model.HousingUnitOccupants;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.HousingUnitOccupantConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class HousingUnitOccupantServiceImpl extends BaseService implements HousingUnitOccupantService {

	@Transactional
	public HousingUnitOccupant createHousingUnitOccupant(HousingUnitOccupant housingUnitUnit) {
		HousingUnitOccupantEntity entity = HousingUnitOccupantConverter.modelToEntity(housingUnitUnit,null);
		entity.setDedupClientId(validationService.validateCleintId(housingUnitUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(housingUnitUnit.getEnrollmentId()));
		daoFactory.getHousingUnitOccupantRepository().save(entity);
		housingUnitUnit.setId(entity.getId());
		return housingUnitUnit;
	}
	
	@Transactional
	public void updateHousingUnitOccupant(HousingUnitOccupant housingUnitUnit) {
		HousingUnitOccupantEntity entity =  daoFactory.getHousingUnitOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitUnit.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitOccupant "+housingUnitUnit.getId()+" not found");
		entity = HousingUnitOccupantConverter.modelToEntity(housingUnitUnit,entity);
		entity.setDedupClientId(validationService.validateCleintId(housingUnitUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(housingUnitUnit.getEnrollmentId()));
		daoFactory.getHousingUnitOccupantRepository().save(entity);
	}
	
	@Transactional
	public void deleteHousingUnitOccupant(UUID housingUnitUnitId) {
		HousingUnitOccupantEntity entity =  daoFactory.getHousingUnitOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitOccupant "+housingUnitUnitId+" not found");
		daoFactory.getHousingUnitOccupantRepository().delete(entity);
	}
	
	@Transactional
	public HousingUnitOccupant getHousingUnitOccupant(UUID housingUnitUnitId) {
		HousingUnitOccupantEntity entity =  daoFactory.getHousingUnitOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitOccupant "+housingUnitUnitId+" not found");		
		return HousingUnitOccupantConverter.entityToModel(entity);
	}
	
	@Transactional
	public HousingUnitOccupants getHousingUnitOccupants(Pageable pageable) {
		HousingUnitOccupants housingUnitUnits = new HousingUnitOccupants();
		Page<HousingUnitOccupantEntity> entityPage = daoFactory.getHousingUnitOccupantRepository().findAll(pageable);
		for(HousingUnitOccupantEntity housingUnitUnitEntity : entityPage.getContent()) {
			housingUnitUnits.addHousingUnitOccupant(HousingUnitOccupantConverter.entityToModel(housingUnitUnitEntity));
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        housingUnitUnits.setPagination(pagination);
		return housingUnitUnits;
	}	
}