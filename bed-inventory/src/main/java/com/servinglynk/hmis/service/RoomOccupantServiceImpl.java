package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.ClientEntity;
import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.entity.RoomOccupantEntity;
import com.servinglynk.hmis.model.RoomOccupant;
import com.servinglynk.hmis.model.RoomOccupants;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.ClientConverter;
import com.servinglynk.hmis.service.converter.RoomOccupantConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;


@Service
public class RoomOccupantServiceImpl extends BaseService implements RoomOccupantService {

	@Transactional
	public RoomOccupants getRoomOccupants(UUID roomid, Date fromdate, Date todate, Pageable pageable) {
		RoomEntity roomEntity = daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(roomid,SecurityContextUtil.getUserProjectGroup(),false);
		if(roomEntity == null) throw new ResourceNotFoundException("Room not found");
		RoomOccupants occupants = new RoomOccupants();
		Page<RoomOccupantEntity> entityPage = daoFactory.getRoomOccupantDao().getRoomOccupants(roomid, fromdate, todate, pageable);
		for(RoomOccupantEntity occupantEntity : entityPage.getContent()) {
			RoomOccupant occupant = RoomOccupantConverter.entityToModel(occupantEntity);
			if(occupant.getClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(occupant.getClientId());
				if(clientEntity!=null) occupant.setClient(ClientConverter.entityToModel(clientEntity));
			}
			occupants.addRoomOccupant(occupant);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        if(pageable!=null)pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        occupants.setPagination(pagination);
		return occupants;
	}

	@Transactional
	public RoomOccupant getRoomOccupant(UUID id) {		
		RoomOccupantEntity entity = daoFactory.getRoomOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(id, SecurityContextUtil.getUserProjectGroup(),false);
		if(entity ==  null) throw new ResourceNotFoundException("Room Occupant "+id+" not found");
		RoomOccupant model = RoomOccupantConverter.entityToModel(entity);
		if(model.getClientId()!=null) {
			ClientEntity clientEntity = daoFactory.getClientRepository().findOne(model.getClientId());
			if(clientEntity!=null) model.setClient(ClientConverter.entityToModel(clientEntity));
		}
		return model;
	}

	@Transactional
	public void checkoutRoomOccupant(RoomOccupant model) {
		RoomEntity roomEntity = daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(model.getRoom().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(roomEntity == null) throw new ResourceNotFoundException("Room not found");
		RoomOccupantEntity entity =  daoFactory.getRoomOccupantDao().getClinetRoomOccupants(model.getClientId(),roomEntity.getId());
		if(entity == null) throw new ResourceNotFoundException("Client not occupied room unit "+model.getRoom().getId());
		entity = RoomOccupantConverter.modelToEntity(model,entity);
		if(model.getCheckoutDate()==null) entity.setCheckOutDate(new Date());
//		sendClientMetaInfo(entity.getClientId(), entity.getDedupClientId(), false, "bedunit.occupant");
		daoFactory.getRoomOccupantRepository().save(entity);
	}

	@Transactional
	public RoomOccupant createRoomOccupant(RoomOccupant model) throws Exception {
		RoomEntity roomEntity = daoFactory.getRoomRepository().findByIdAndProjectGroupCodeAndDeleted(model.getRoom().getId(), SecurityContextUtil.getUserProjectGroup(), false);
		if(roomEntity==null) throw new ResourceNotFoundException("Room "+model.getRoom().getId()+" not found");
		 RoomOccupantEntity entity = RoomOccupantConverter.modelToEntity(model, null);
		 entity.setClientId(model.getClientId());
		 entity.setDedupClientId(validationService.validateCleintId(model.getClientId()));
		 entity.setEnrollmentType(validationService.validateEnrillment(model.getEnrollmentId()));
		 entity.setEnrollemntId(model.getEnrollmentId());
		 entity.setRoom(roomEntity);
		 entity.setArea(roomEntity.getArea());
		 entity.setShelter(roomEntity.getShelter());
		 daoFactory.getRoomOccupantRepository().save(entity);
		 model.setId(entity.getId());
		return model;
	}

}
