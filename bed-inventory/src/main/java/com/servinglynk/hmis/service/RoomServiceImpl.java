package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.AreaEntity;
import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.entity.ShelterEntity;
import com.servinglynk.hmis.model.InventorySummary;
import com.servinglynk.hmis.model.RoomModel;
import com.servinglynk.hmis.model.Rooms;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.RoomConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class RoomServiceImpl extends BaseService implements RoomService {

	@Transactional
	public RoomModel createRoom(RoomModel room) {
		RoomEntity entity = RoomConverter.modelToEntity(room,null);
		ShelterEntity shelterEntity = daoFactory.getShelterRepository().findByIdAndProjectGroupCodeAndDeleted(room.getShelter().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(shelterEntity == null) throw new ResourceNotFoundException("Shelter "+room.getShelter().getId()+" not found");
		AreaEntity areaEntity =  daoFactory.getAreaRepository().findByIdAndProjectGroupCodeAndDeleted(room.getArea().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(areaEntity == null) throw new ResourceNotFoundException("Area "+room.getArea().getId()+" not found");
		entity.setArea(areaEntity);
		entity.setShelter(shelterEntity);
		daoFactory.getRoomRepository().save(entity);
		shelterEntity.setTotalRooms(shelterEntity.getTotalRooms()+1);
		daoFactory.getShelterRepository().save(shelterEntity);
		room.setId(entity.getId());
		return room;
	}
	
	@Transactional
	public void updateRoom(RoomModel room) {
		ShelterEntity shelterEntity = daoFactory.getShelterRepository().findByIdAndProjectGroupCodeAndDeleted(room.getShelter().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(shelterEntity == null) throw new ResourceNotFoundException("Shelter "+room.getShelter().getId()+" not found");
		AreaEntity areaEntity =  daoFactory.getAreaRepository().findByIdAndProjectGroupCodeAndDeleted(room.getArea().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(areaEntity == null) throw new ResourceNotFoundException("Area "+room.getArea().getId()+" not found");
		RoomEntity entity =  daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(room.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("Room "+room.getId()+" not found");
		entity = RoomConverter.modelToEntity(room,entity);
		daoFactory.getRoomRepository().save(entity);
	}
	
	@Transactional
	public void deleteRoom(UUID roomId) {
		RoomEntity entity =  daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(roomId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("Room "+roomId+" not found");
		daoFactory.getRoomRepository().delete(entity);
		ShelterEntity shelterEntity = entity.getShelter();
		shelterEntity.setTotalRooms(shelterEntity.getTotalRooms()-1);
		daoFactory.getShelterRepository().save(shelterEntity);
	}
	
	@Transactional
	public RoomModel getRoom(UUID roomId) {
		RoomEntity entity =  daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(roomId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("Room "+roomId+" not found");		
		RoomModel roomModel  = RoomConverter.entityToModel(entity);
		roomModel.setSummary(this.getRoomSummary(entity.getArea().getShelter().getId(), entity.getArea().getId(), roomId, 1L));
		return roomModel;
	}
	
	@Transactional
	public Rooms getRooms(UUID shelterid, UUID areaid,Pageable pageable) {
		ShelterEntity shelterEntity = daoFactory.getShelterRepository().findByIdAndProjectGroupCodeAndDeleted(shelterid,SecurityContextUtil.getUserProjectGroup(),false);
		if(shelterEntity == null) throw new ResourceNotFoundException("Shelter "+shelterid+" not found");
		AreaEntity areaEntity =  daoFactory.getAreaRepository().findOne(areaid);
		if(areaEntity == null) throw new ResourceNotFoundException("Area "+areaid+" not found");
		Rooms rooms = new Rooms();
		Page<RoomEntity> entityPage = daoFactory.getRoomRepository().findByAreaAndDeleted(areaEntity,false,pageable);
		for(RoomEntity roomEntity : entityPage.getContent()) {
			rooms.addRoom(RoomConverter.entityToModel(roomEntity));
		}
		rooms.setSummary(this.getRoomSummary(shelterid, areaid, null, entityPage.getTotalElements()));
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        rooms.setPagination(pagination);
		return rooms;
	}	
	
	
	public InventorySummary getRoomSummary(UUID shelterId,UUID areaId,UUID roomId,Long roomCount) {
		InventorySummary summary = new InventorySummary();
		summary.setTotalRooms(roomCount);
		summary.setTotalBeds(daoFactory.getSummaryDao().getBedCount(roomId, areaId, shelterId));
		summary.setOccupiedBeds(daoFactory.getSummaryDao().getOccupiedBeds(null, roomId, areaId, shelterId));
		summary.setReservedBeds(daoFactory.getSummaryDao().getReservedBeds(null, roomId, areaId, shelterId));
		summary.setReservedRooms(daoFactory.getSummaryDao().getReservedRooms(roomId, areaId, shelterId));
		summary.setVacantBeds(summary.getTotalBeds() - summary.getOccupiedBeds());
		return summary;
	}
}