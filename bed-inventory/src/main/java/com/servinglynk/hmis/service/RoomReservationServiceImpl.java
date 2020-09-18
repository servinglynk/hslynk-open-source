package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.RoomReservationEntity;
import com.servinglynk.hmis.model.RoomReservation;
import com.servinglynk.hmis.model.RoomReservations;
import com.servinglynk.hmis.service.converter.RoomReservationConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class RoomReservationServiceImpl extends BaseService implements RoomReservationService {

	@Transactional
	public RoomReservation createRoomReservation(RoomReservation room) {
		RoomReservationEntity entity = RoomReservationConverter.modelToEntity(room,null);
		daoFactory.getRoomReservationRepository().save(entity);
		room.setId(entity.getId());
		return room;
	}
	
	@Transactional
	public void updateRoomReservation(RoomReservation room) {
		RoomReservationEntity entity =  daoFactory.getRoomReservationRepository().findOne(room.getId());
		if(entity == null) throw new ResourceNotFoundException("RoomReservation "+room.getId()+" not found");
		entity = RoomReservationConverter.modelToEntity(room,entity);
		daoFactory.getRoomReservationRepository().save(entity);
	}
	
	@Transactional
	public void deleteRoomReservation(UUID roomId) {
		RoomReservationEntity entity =  daoFactory.getRoomReservationRepository().findOne(roomId);
		if(entity == null) throw new ResourceNotFoundException("RoomReservation "+roomId+" not found");
		daoFactory.getRoomReservationRepository().delete(entity);
	}
	
	@Transactional
	public RoomReservation getRoomReservation(UUID roomId) {
		RoomReservationEntity entity =  daoFactory.getRoomReservationRepository().findOne(roomId);
		if(entity == null) throw new ResourceNotFoundException("RoomReservation "+roomId+" not found");		
		return RoomReservationConverter.entityToModel(entity);
	}
	
	@Transactional
	public RoomReservations getRoomReservations(Pageable pageable) {
		RoomReservations rooms = new RoomReservations();
		Page<RoomReservationEntity> entityPage = daoFactory.getRoomReservationRepository().findAll(pageable);
		for(RoomReservationEntity roomEntity : entityPage.getContent()) {
			rooms.addRoomReservation(RoomReservationConverter.entityToModel(roomEntity));
		}
		return rooms;
	}	
}