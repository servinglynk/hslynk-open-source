package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.BedUnitReservationEntity;
import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.entity.RoomReservationEntity;
import com.servinglynk.hmis.model.RoomReservation;
import com.servinglynk.hmis.model.RoomReservations;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.RoomReservationConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class RoomReservationServiceImpl extends BaseService implements RoomReservationService {

	@Transactional
	public RoomReservation createRoomReservation(RoomReservation room) {
		RoomEntity roomEntity = daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(room.getRoom().getId(), SecurityContextUtil.getUserProjectGroup(),false);
		if(roomEntity==null) throw new ResourceNotFoundException("Room "+room.getRoom().getId()+" not found");
		RoomReservationEntity entity = RoomReservationConverter.modelToEntity(room,null);
		entity.setRoom(roomEntity);
		daoFactory.getRoomReservationRepository().save(entity);
		List<BedUnitEntity> bedUnitEntities =	daoFactory.getBedUnitRepository().findByRoomAndDeleted(roomEntity, false);
		this.reserveRoomBedUnits(bedUnitEntities, room);
		room.setId(entity.getId());
		return room;
	}
	
	@Transactional
	public void updateRoomReservation(RoomReservation room) {
		RoomReservationEntity entity =  daoFactory.getRoomReservationRepository().findByIdAndProjectGroupCodeAndDeleted(room.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("RoomReservation "+room.getId()+" not found");
		entity = RoomReservationConverter.modelToEntity(room,entity);
		daoFactory.getRoomReservationRepository().save(entity);
	}
	
	@Transactional
	public void deleteRoomReservation(UUID roomId) {
		RoomReservationEntity entity =  daoFactory.getRoomReservationRepository().findByIdAndProjectGroupCodeAndDeleted(roomId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("RoomReservation "+roomId+" not found");
		daoFactory.getRoomReservationRepository().delete(entity);
	}
	
	@Transactional
	public RoomReservation getRoomReservation(UUID roomId) {
		RoomReservationEntity entity =  daoFactory.getRoomReservationRepository().findByIdAndProjectGroupCodeAndDeleted(roomId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("RoomReservation "+roomId+" not found");		
		return RoomReservationConverter.entityToModel(entity);
	}
	
	@Transactional
	public RoomReservations getRoomReservations(UUID roomId,Date fromdate, Date todate,Pageable pageable) {
		RoomEntity roomEntity = daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(roomId, SecurityContextUtil.getUserProjectGroup(),false);
		if(roomEntity==null) throw new ResourceNotFoundException("Room "+roomId+" not found");
		RoomReservations rooms = new RoomReservations();
		Page<RoomReservationEntity> entityPage = daoFactory.getRoomReservationDao().getRoomReservations(roomId, fromdate, todate, pageable);
		for(RoomReservationEntity roomReservationEntity : entityPage.getContent()) {
			rooms.addRoomReservation(RoomReservationConverter.entityToModel(roomReservationEntity));
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        rooms.setPagination(pagination);
		return rooms;
	}	
	
	
	public void reserveRoomBedUnits(List<BedUnitEntity> bedUnitEntities,RoomReservation roomReservation) {
		for(BedUnitEntity bedUnitEntity : bedUnitEntities) {
			BedUnitReservationEntity entity = new BedUnitReservationEntity();
			entity.setBedUnit(bedUnitEntity);
			entity.setProjectGroupCode(bedUnitEntity.getProjectGroupCode());
			entity.setReservationEndDateDate(roomReservation.getEndDate());
			entity.setReservationStateDate(roomReservation.getStateDate());
			entity.setReservedCleintId(roomReservation.getReservedCleintId());
			entity.setReservedHouseholdId(roomReservation.getReservedHouseholdId());
			daoFactory.getBedUnitReservationRepository().save(entity);
			
		}
		
	}
}