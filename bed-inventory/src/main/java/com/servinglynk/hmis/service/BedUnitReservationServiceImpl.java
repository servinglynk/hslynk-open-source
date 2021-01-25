package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.BedUnitReservationEntity;
import com.servinglynk.hmis.entity.ClientEntity;
import com.servinglynk.hmis.model.BedUnitReservation;
import com.servinglynk.hmis.model.BedUnitReservations;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.BedUnitReservationConverter;
import com.servinglynk.hmis.service.converter.ClientConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class BedUnitReservationServiceImpl extends BaseService implements BedReservationService {

	@Transactional
	public BedUnitReservation createBedUnitReservation(BedUnitReservation room) throws Exception {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findOne(room.getBedUnit().getId());
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed Unit "+room.getBedUnit().getId()+" not found");
		BedUnitReservationEntity entity = BedUnitReservationConverter.modelToEntity(room,null);
		entity.setReservedCleintId(room.getReservedClientId());
		entity.setReservedCleintDedupId(validationService.validateCleintId(room.getReservedClientId()));
		entity.setBedUnit(bedUnitEntity);
		entity.setRoom(bedUnitEntity.getRoom());
		entity.setArea(bedUnitEntity.getArea());
		entity.setShelter(bedUnitEntity.getShelter());
		daoFactory.getBedUnitReservationRepository().save(entity);
		sendClientMetaInfo(entity.getReservedCleintId(), entity.getReservedCleintDedupId(), false, "bedunit.reservation");
		room.setId(entity.getId());
		return room;
	}
	
	@Transactional
	public void updateBedUnitReservation(BedUnitReservation room) throws Exception {
		BedUnitReservationEntity entity =  daoFactory.getBedUnitReservationRepository().findByIdAndProjectGroupCodeAndDeleted(room.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedUnitReservation "+room.getId()+" not found");
		entity = BedUnitReservationConverter.modelToEntity(room,entity);
		if(room.getReservedClientId()!=null) {
			entity.setReservedCleintId(room.getReservedClientId());
			entity.setReservedCleintDedupId(validationService.validateCleintId(room.getReservedClientId()));
		}
		daoFactory.getBedUnitReservationRepository().save(entity);
		sendClientMetaInfo(entity.getReservedCleintId(), entity.getReservedCleintDedupId(), false, "bedunit.reservation");
	}
	
	@Transactional
	public void deleteBedUnitReservation(UUID roomId) {
		BedUnitReservationEntity entity =  daoFactory.getBedUnitReservationRepository().findByIdAndProjectGroupCodeAndDeleted(roomId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedUnitReservation "+roomId+" not found");
		daoFactory.getBedUnitReservationRepository().delete(entity);
	}
	
	@Transactional
	public BedUnitReservation getBedUnitReservation(UUID roomId) {
		BedUnitReservationEntity entity =  daoFactory.getBedUnitReservationRepository().findByIdAndProjectGroupCodeAndDeleted(roomId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedUnitReservation "+roomId+" not found");		
		
		BedUnitReservation reservation = BedUnitReservationConverter.entityToModel(entity);
		if(reservation.getReservedClientId()!=null) {
			ClientEntity clientEntity = daoFactory.getClientRepository().findOne(reservation.getReservedClientId());
			if(clientEntity!=null) reservation.setClient(ClientConverter.entityToModel(clientEntity));
		}
		return reservation;
	}
	
	@Transactional
	public BedUnitReservations getBedUnitReservations(UUID bedUnitId, Date fromdate, Date todate,Pageable pageable) {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findOne(bedUnitId);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed Unit "+bedUnitId+" not found");
		BedUnitReservations rooms = new BedUnitReservations();
		Page<BedUnitReservationEntity> entityPage = daoFactory.getBedUnitReservationDao().getBedUnits(bedUnitId, fromdate, todate, pageable);
		for(BedUnitReservationEntity roomEntity : entityPage.getContent()) {
			BedUnitReservation reservation = BedUnitReservationConverter.entityToModel(roomEntity);
			if(reservation.getReservedClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(reservation.getReservedClientId());
				if(clientEntity!=null) reservation.setClient(ClientConverter.entityToModel(clientEntity));
			}
			rooms.addBedUnitReservation(reservation);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        rooms.setPagination(pagination);
		return rooms;
	}

	@Override
	public BedUnitReservations getClientBedUnitReservations(UUID dedupClientId, Date fromdate, Date todate,
			Pageable pageable) {
		BedUnitReservations rooms = new BedUnitReservations();
		Page<BedUnitReservationEntity> entityPage = daoFactory.getBedUnitReservationDao().getClientBedUnitReservations(dedupClientId, fromdate, todate, pageable);
		for(BedUnitReservationEntity roomEntity : entityPage.getContent()) {
			BedUnitReservation reservation = BedUnitReservationConverter.entityToModel(roomEntity);
			if(reservation.getReservedClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(reservation.getReservedClientId());
				if(clientEntity!=null) reservation.setClient(ClientConverter.entityToModel(clientEntity));
			}
			rooms.addBedUnitReservation(reservation);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        rooms.setPagination(pagination);
		return rooms;
	}	
}