package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.ClientEntity;
import com.servinglynk.hmis.entity.HousingUnitEntity;
import com.servinglynk.hmis.entity.HousingUnitReservationEntity;
import com.servinglynk.hmis.model.HousingUnitReservation;
import com.servinglynk.hmis.model.HousingUnitReservations;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.ClientConverter;
import com.servinglynk.hmis.service.converter.HousingUnitReservationConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class HousingUnitReservationServiceImpl extends BaseService implements HousingUnitReservationService {

	@Transactional
	public HousingUnitReservation createHousingUnitReservation(HousingUnitReservation housingUnitReservation) throws Exception {
		HousingUnitEntity housingUnitEntity = daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitReservation.getHousingUnit().getId(), SecurityContextUtil.getUserProjectGroup(), false);
		if(housingUnitEntity ==null) throw new ResourceNotFoundException(" Housing unit "+housingUnitReservation.getHousingUnit().getId()+" not found");
		HousingUnitReservationEntity entity = HousingUnitReservationConverter.modelToEntity(housingUnitReservation,null);
		entity.setReservedCleintId(housingUnitReservation.getReservedClientId());
		entity.setDedupClientId(validationService.validateCleintId(housingUnitReservation.getReservedClientId()));
		entity.setHousingUnit(housingUnitEntity);
		daoFactory.getHousingUnitReservationRepository().save(entity);
		housingUnitReservation.setId(entity.getId());
		sendClientMetaInfo(entity.getReservedCleintId(),entity.getDedupClientId(),false,"housingunit.reservation");
		return housingUnitReservation;
	}
	
	@Transactional
	public void updateHousingUnitReservation(HousingUnitReservation housingUnitReservation) throws Exception {
		HousingUnitEntity housingUnitEntity = daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitReservation.getHousingUnit().getId(), SecurityContextUtil.getUserProjectGroup(), false);
		if(housingUnitEntity ==null) throw new ResourceNotFoundException(" Housing unit "+housingUnitReservation.getHousingUnit().getId()+" not found");
		HousingUnitReservationEntity entity =  daoFactory.getHousingUnitReservationRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitReservation.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitReservation "+housingUnitReservation.getId()+" not found");
		entity = HousingUnitReservationConverter.modelToEntity(housingUnitReservation,entity);
		entity.setHousingUnit(housingUnitEntity);
		entity.setReservedCleintId(housingUnitReservation.getReservedClientId());
		if(housingUnitReservation.getReservedClientId()!=null) entity.setDedupClientId(validationService.validateCleintId(housingUnitReservation.getReservedClientId()));
		daoFactory.getHousingUnitReservationRepository().save(entity);
		sendClientMetaInfo(entity.getReservedCleintId(),entity.getDedupClientId(),false,"housingunit.reservation");
	}
	
	@Transactional
	public void deleteHousingUnitReservation(UUID housingUnitReservationId) {
		HousingUnitReservationEntity entity =  daoFactory.getHousingUnitReservationRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitReservationId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitReservation "+housingUnitReservationId+" not found");
		daoFactory.getHousingUnitReservationRepository().delete(entity);
	}
	
	@Transactional
	public HousingUnitReservation getHousingUnitReservation(UUID housingUnitReservationId) {
		HousingUnitReservationEntity entity =  daoFactory.getHousingUnitReservationRepository().findByIdAndProjectGroupCodeAndDeleted(housingUnitReservationId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("HousingUnitReservation "+housingUnitReservationId+" not found");	
		HousingUnitReservation reservation = HousingUnitReservationConverter.entityToModel(entity);
		if(reservation.getReservedClientId()!=null) {
			ClientEntity clientEntity = daoFactory.getClientRepository().findOne(reservation.getReservedClientId());
			if(clientEntity!=null) reservation.setClient(ClientConverter.entityToModel(clientEntity));
		}
		return reservation;
	}
	
	@Transactional
	public HousingUnitReservations getHousingUnitReservations(UUID housingunitid,Date fromdate, Date todate,Pageable pageable) {
		HousingUnitEntity housingUnitEntity = daoFactory.getHousingUnitRepository().findByIdAndProjectGroupCodeAndDeleted(housingunitid, SecurityContextUtil.getUserProjectGroup(), false);
	if(housingUnitEntity ==null) throw new ResourceNotFoundException(" Housing unit "+housingunitid+" not found");
		HousingUnitReservations housingUnitReservations = new HousingUnitReservations();
		Page<HousingUnitReservationEntity> entityPage = daoFactory.getHousingUnitReservationRepository().findByHousingUnitAndProjectGroupCodeAndDeleted(housingUnitEntity,SecurityContextUtil.getUserProjectGroup(), false,pageable);
		for(HousingUnitReservationEntity housingUnitReservationEntity : entityPage.getContent()) {
			HousingUnitReservation reservation = HousingUnitReservationConverter.entityToModel(housingUnitReservationEntity);
			if(reservation.getReservedClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(reservation.getReservedClientId());
				if(clientEntity!=null) reservation.setClient(ClientConverter.entityToModel(clientEntity));
			}
			housingUnitReservations.addHousingUnitReservation(reservation);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        housingUnitReservations.setPagination(pagination);
		return housingUnitReservations;
	}

	@Transactional
	public HousingUnitReservations getClientHousingUnitReservations(UUID dedupClientId, Date fromdate, Date todate,
			Pageable pageable) {
		HousingUnitReservations housingUnitReservations = new HousingUnitReservations();
		Page<HousingUnitReservationEntity> entityPage = daoFactory.getHousingUnitReservationDao().getClientHousingUnitReservations(dedupClientId,fromdate,todate,pageable);
		for(HousingUnitReservationEntity housingUnitReservationEntity : entityPage.getContent()) {
			HousingUnitReservation reservation = HousingUnitReservationConverter.entityToModel(housingUnitReservationEntity);
			if(reservation.getReservedClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(reservation.getReservedClientId());
				if(clientEntity!=null) reservation.setClient(ClientConverter.entityToModel(clientEntity));
			}
			housingUnitReservations.addHousingUnitReservation(reservation);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        housingUnitReservations.setPagination(pagination);
		return housingUnitReservations;
	}	
}