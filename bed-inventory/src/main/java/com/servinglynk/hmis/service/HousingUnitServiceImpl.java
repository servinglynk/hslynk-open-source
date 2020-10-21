package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.HousingUnitEntity;
import com.servinglynk.hmis.model.HousingUnit;
import com.servinglynk.hmis.model.HousingUnits;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.HousingUnitConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class HousingUnitServiceImpl extends BaseService implements HousingUnitService {

	@Transactional
	public HousingUnit createHousingUnit(HousingUnit housingUnit) {
		HousingUnitEntity entity = HousingUnitConverter.modelToEntity(housingUnit,null);
		daoFactory.getHousingUnitRepository().save(entity);
		housingUnit.setId(entity.getId());
		return housingUnit;
	}
	
	@Transactional
	public void updateHousingUnit(HousingUnit housingUnit) {
		HousingUnitEntity entity =  daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnit.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnit "+housingUnit.getId()+" not found");
		entity = HousingUnitConverter.modelToEntity(housingUnit,entity);
		daoFactory.getHousingUnitRepository().save(entity);
	}
	
	@Transactional
	public void deleteHousingUnit(UUID housingUnitId) {
		HousingUnitEntity entity =  daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnit "+housingUnitId+" not found");
		daoFactory.getHousingUnitRepository().delete(entity);
	}
	
	@Transactional
	public HousingUnit getHousingUnit(UUID housingUnitId) {
		HousingUnitEntity entity =  daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnit "+housingUnitId+" not found");		
		return HousingUnitConverter.entityToModel(entity);
	}
	
	@Transactional
	public HousingUnits getHousingUnits(Pageable pageable) {
		HousingUnits housingUnits = new HousingUnits();
		Page<HousingUnitEntity> entityPage = daoFactory.getHousingUnitRepository().findAll(pageable);
		for(HousingUnitEntity housingUnitEntity : entityPage.getContent()) {
			housingUnits.addHousingUnit(HousingUnitConverter.entityToModel(housingUnitEntity));
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        housingUnits.setPagination(pagination);
		return housingUnits;
	}	
}