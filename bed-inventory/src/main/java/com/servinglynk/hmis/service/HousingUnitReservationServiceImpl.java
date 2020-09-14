package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.HousingUnitReservationEntity;
import com.servinglynk.hmis.model.HousingUnitReservation;
import com.servinglynk.hmis.model.HousingUnitReservations;
import com.servinglynk.hmis.service.converter.HousingUnitReservationConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class HousingUnitReservationServiceImpl extends BaseService implements HousingUnitReservationService {

	@Transactional
	public HousingUnitReservation createHousingUnitReservation(HousingUnitReservation housingUnitReservation) {
		HousingUnitReservationEntity entity = HousingUnitReservationConverter.modelToEntity(housingUnitReservation,null);
		daoFactory.getHousingUnitReservationRepository().save(entity);
		housingUnitReservation.setId(entity.getId());
		return housingUnitReservation;
	}
	
	@Transactional
	public void updateHousingUnitReservation(HousingUnitReservation housingUnitReservation) {
		HousingUnitReservationEntity entity =  daoFactory.getHousingUnitReservationRepository().findOne(housingUnitReservation.getId());
		if(entity == null) throw new ResourceNotFoundException("HousingUnitReservation "+housingUnitReservation.getId()+" not found");
		entity = HousingUnitReservationConverter.modelToEntity(housingUnitReservation,entity);
		daoFactory.getHousingUnitReservationRepository().save(entity);
	}
	
	@Transactional
	public void deleteHousingUnitReservation(UUID housingUnitReservationId) {
		HousingUnitReservationEntity entity =  daoFactory.getHousingUnitReservationRepository().findOne(housingUnitReservationId);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitReservation "+housingUnitReservationId+" not found");
		daoFactory.getHousingUnitReservationRepository().delete(entity);
	}
	
	@Transactional
	public HousingUnitReservation getHousingUnitReservation(UUID housingUnitReservationId) {
		HousingUnitReservationEntity entity =  daoFactory.getHousingUnitReservationRepository().findOne(housingUnitReservationId);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitReservation "+housingUnitReservationId+" not found");		
		return HousingUnitReservationConverter.entityToModel(entity);
	}
	
	@Transactional
	public HousingUnitReservations getHousingUnitReservations(Pageable pageable) {
		HousingUnitReservations housingUnitReservations = new HousingUnitReservations();
		Page<HousingUnitReservationEntity> entityPage = daoFactory.getHousingUnitReservationRepository().findAll(pageable);
		for(HousingUnitReservationEntity housingUnitReservationEntity : entityPage.getContent()) {
			housingUnitReservations.addHousingUnitReservation(HousingUnitReservationConverter.entityToModel(housingUnitReservationEntity));
		}
		return housingUnitReservations;
	}	
}