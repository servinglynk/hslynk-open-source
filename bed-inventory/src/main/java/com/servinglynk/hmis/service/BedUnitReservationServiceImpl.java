package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.BedUnitReservationEntity;
import com.servinglynk.hmis.model.BedUnitReservation;
import com.servinglynk.hmis.model.BedUnitReservations;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.BedUnitReservationConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class BedUnitReservationServiceImpl extends BaseService implements BedReservationService {

	@Transactional
	public BedUnitReservation createBedUnitReservation(BedUnitReservation room) {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findOne(room.getBedUnit().getId());
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed Unit "+room.getBedUnit().getId()+" not found");
		BedUnitReservationEntity entity = BedUnitReservationConverter.modelToEntity(room,null);
		entity.setBedUnit(bedUnitEntity);
		daoFactory.getBedUnitReservationRepository().save(entity);
		room.setId(entity.getId());
		return room;
	}
	
	@Transactional
	public void updateBedUnitReservation(BedUnitReservation room) {
		BedUnitReservationEntity entity =  daoFactory.getBedUnitReservationRepository().findByIdAndProjectGroupCodeAndDeleted(room.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedUnitReservation "+room.getId()+" not found");
		entity = BedUnitReservationConverter.modelToEntity(room,entity);
		daoFactory.getBedUnitReservationRepository().save(entity);
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
		return BedUnitReservationConverter.entityToModel(entity);
	}
	
	@Transactional
	public BedUnitReservations getBedUnitReservations(Pageable pageable) {
		BedUnitReservations rooms = new BedUnitReservations();
		Page<BedUnitReservationEntity> entityPage = daoFactory.getBedUnitReservationRepository().findAll(pageable);
		for(BedUnitReservationEntity roomEntity : entityPage.getContent()) {
			rooms.addBedUnitReservation(BedUnitReservationConverter.entityToModel(roomEntity));
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        rooms.setPagination(pagination);
		return rooms;
	}	
}