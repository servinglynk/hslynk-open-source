package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.ClientEntity;
import com.servinglynk.hmis.entity.HousingUnitEntity;
import com.servinglynk.hmis.entity.HousingUnitOccupantEntity;
import com.servinglynk.hmis.model.HousingUnitOccupant;
import com.servinglynk.hmis.model.HousingUnitOccupants;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.ClientConverter;
import com.servinglynk.hmis.service.converter.HousingUnitOccupantConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class HousingUnitOccupantServiceImpl extends BaseService implements HousingUnitOccupantService {

	@Transactional
	public HousingUnitOccupant createHousingUnitOccupant(HousingUnitOccupant housingUnitUnit) throws Exception  {
		HousingUnitEntity housingUnitEntity = daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitUnit.getHousingUnit().getId(), SecurityContextUtil.getUserProjectGroup(), false);
		if(housingUnitEntity ==null) throw new ResourceNotFoundException(" Housing unit "+housingUnitUnit.getHousingUnit().getId()+" not found");
		HousingUnitOccupantEntity entity = HousingUnitOccupantConverter.modelToEntity(housingUnitUnit,null);
		entity.setHousingUnit(housingUnitEntity);
		entity.setDedupClientId(validationService.validateCleintId(housingUnitUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(housingUnitUnit.getEnrollmentId()));
		daoFactory.getHousingUnitOccupantRepository().save(entity);
		housingUnitUnit.setId(entity.getId());
		sendClientMetaInfo(entity.getClientId(),entity.getDedupClientId(),false,"housingunit.occupant");
		return housingUnitUnit;
	}
	
	@Transactional
	public void updateHousingUnitOccupant(HousingUnitOccupant housingUnitUnit)throws Exception  {
		HousingUnitEntity housingUnitEntity = daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitUnit.getHousingUnit().getId(), SecurityContextUtil.getUserProjectGroup(), false);
		if(housingUnitEntity ==null) throw new ResourceNotFoundException(" Housing unit "+housingUnitUnit.getHousingUnit().getId()+" not found");
		HousingUnitOccupantEntity entity =  daoFactory.getHousingUnitOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitUnit.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitOccupant "+housingUnitUnit.getId()+" not found");
		entity = HousingUnitOccupantConverter.modelToEntity(housingUnitUnit,entity);
		entity.setHousingUnit(housingUnitEntity);
		entity.setDedupClientId(validationService.validateCleintId(housingUnitUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(housingUnitUnit.getEnrollmentId()));
		daoFactory.getHousingUnitOccupantRepository().save(entity);
		sendClientMetaInfo(entity.getClientId(),entity.getDedupClientId(),false,"housingunit.occupant");
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
		HousingUnitOccupant occupant = HousingUnitOccupantConverter.entityToModel(entity);
		if(occupant.getClientId()!=null) {
			ClientEntity clientEntity = daoFactory.getClientRepository().findOne(occupant.getClientId());
			if(clientEntity!=null) occupant.setClient(ClientConverter.entityToModel(clientEntity));
		}
		return occupant;
	}
	
	@Transactional
	public HousingUnitOccupants getHousingUnitOccupants(UUID housingunitid,Pageable pageable) {
		HousingUnitEntity housingUnitEntity = daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingunitid, SecurityContextUtil.getUserProjectGroup(), false);
		if(housingUnitEntity ==null) throw new ResourceNotFoundException(" Housing unit "+housingunitid+" not found");
		HousingUnitOccupants housingUnitUnits = new HousingUnitOccupants();
		Page<HousingUnitOccupantEntity> entityPage = daoFactory.getHousingUnitOccupantRepository().findByHousingUnitAndProjectGroupCodeAndDeleted(housingUnitEntity, SecurityContextUtil.getUserProjectGroup(), false,pageable);
		for(HousingUnitOccupantEntity housingUnitUnitEntity : entityPage.getContent()) {
			HousingUnitOccupant occupant = HousingUnitOccupantConverter.entityToModel(housingUnitUnitEntity);
			if(occupant.getClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(occupant.getClientId());
				if(clientEntity!=null) occupant.setClient(ClientConverter.entityToModel(clientEntity));
			}
			housingUnitUnits.addHousingUnitOccupant(occupant);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        housingUnitUnits.setPagination(pagination);
		return housingUnitUnits;
	}

	@Transactional
	public HousingUnitOccupants getClientHousingUnitOccupants(UUID dedupClientId, Date fromdate, Date todate,
			Pageable pageable) {
		HousingUnitOccupants housingUnitUnits = new HousingUnitOccupants();
		Page<HousingUnitOccupantEntity> entityPage = daoFactory.getHousingUnitOccupantDao().getClientHousingUnitOccupants(dedupClientId, fromdate, todate,pageable);
		for(HousingUnitOccupantEntity housingUnitUnitEntity : entityPage.getContent()) {
			HousingUnitOccupant occupant = HousingUnitOccupantConverter.entityToModel(housingUnitUnitEntity);
			if(occupant.getClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(occupant.getClientId());
				if(clientEntity!=null) occupant.setClient(ClientConverter.entityToModel(clientEntity));
			}
			housingUnitUnits.addHousingUnitOccupant(occupant);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        housingUnitUnits.setPagination(pagination);
		return housingUnitUnits;
	}	
}