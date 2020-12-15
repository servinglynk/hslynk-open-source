package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.ShelterEntity;
import com.servinglynk.hmis.model.ShelterModel;
import com.servinglynk.hmis.model.Shelters;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.ShelterConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;

@Service
public class ShelterServiceImpl extends BaseService implements ShelterService {

	@Transactional
	public ShelterModel createShelter(ShelterModel shelter) {
		ShelterEntity entity = ShelterConverter.modelToEntity(shelter,null);
		daoFactory.getShelterRepository().save(entity);
		shelter.setId(entity.getId());
		return shelter;
	}
	
	@Transactional
	public void updateShelter(ShelterModel shelter) {
		ShelterEntity entity =  daoFactory.getShelterRepository().findByIdAndProjectGroupCodeAndDeleted(shelter.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("Shelter "+shelter.getId()+" not found");
		entity = ShelterConverter.modelToEntity(shelter,entity);
		daoFactory.getShelterRepository().save(entity);
	}
	
	@Transactional
	public void deleteShelter(UUID shelterId) {
		ShelterEntity entity =  daoFactory.getShelterRepository().findByIdAndProjectGroupCodeAndDeleted(shelterId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("Shelter "+shelterId+" not found");
		daoFactory.getShelterRepository().delete(entity);
	}
	
	@Transactional
	public ShelterModel getShelter(UUID shelterId) {
		ShelterEntity entity =  daoFactory.getShelterRepository().findByIdAndProjectGroupCodeAndDeleted(shelterId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("Shelter "+shelterId+" not found");		
		return ShelterConverter.entityToModel(entity);
	}
	
	@Transactional
	public Shelters getShelters(String q,Pageable pageable) {
		Shelters shelters = new Shelters();
		Page<ShelterEntity> entityPage = null ; 
		if(q==null) {
			entityPage = daoFactory.getShelterRepository().findByProjectGroupCodeAndDeleted(SecurityContextUtil.getUserProjectGroup(),false,pageable);
		}else {
			entityPage = daoFactory.getShelterDao().getAllShelters(q, pageable);
		}
		for(ShelterEntity shelterEntity : entityPage.getContent()) {
			shelters.addShleter(ShelterConverter.entityToModel(shelterEntity));
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        shelters.setPagination(pagination);
		return shelters;
	}	
}