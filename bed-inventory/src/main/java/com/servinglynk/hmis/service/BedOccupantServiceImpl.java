package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.ClientEntity;
import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.BedOccupants;
import com.servinglynk.hmis.model.BedUnitReservation;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.service.converter.BedOccupantConverter;
import com.servinglynk.hmis.service.converter.ClientConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class BedOccupantServiceImpl extends BaseService implements BedOccupantService {
	
	

	@Transactional
	public BedOccupant createBedOccupant(BedOccupant bedUnit) throws Exception {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getBedUnit().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed unit not found");
		this.checkReservation(bedUnit, bedUnitEntity);
		BedOccupantEntity entity = BedOccupantConverter.modelToEntity(bedUnit,null);
		entity.setClientId(bedUnit.getClientId());
		entity.setDedupClientId(validationService.validateCleintId(bedUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(bedUnit.getEnrollmentId()));
		entity.setEnrollemntId(bedUnit.getEnrollmentId());
		entity.setBedUnit(bedUnitEntity);
		entity.setRoom(bedUnitEntity.getRoom());
		entity.setArea(bedUnitEntity.getArea());
		entity.setShelter(bedUnitEntity.getShelter());
		daoFactory.getBedOccupantRepository().save(entity);
		bedUnitEntity.setOccupancy(true);
		daoFactory.getBedUnitRepository().save(bedUnitEntity);
		bedUnit.setId(entity.getId());
		sendClientMetaInfo(entity.getClientId(), entity.getDedupClientId(), false, "bedunit.occupant");
		return bedUnit;
	}
	
	@Transactional
	public void updateBedOccupant(BedOccupant bedUnit) throws Exception{
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getBedUnit().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed unit not found");
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnit.getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnit.getId()+" not found");
		entity = BedOccupantConverter.modelToEntity(bedUnit,entity);
		if(bedUnit.getClientId()!=null) entity.setDedupClientId(validationService.validateCleintId(bedUnit.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(bedUnit.getEnrollmentId()));
		sendClientMetaInfo(entity.getClientId(), entity.getDedupClientId(), false, "bedunit.occupant");
		daoFactory.getBedOccupantRepository().save(entity);
	}
	
	@Transactional
	public void checkoutBedOccupant(BedOccupant bedOccupant) throws Exception {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedOccupant.getBedUnit().getId(),SecurityContextUtil.getUserProjectGroup(),false);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed unit not found");
		BedOccupantEntity entity =  daoFactory.getBedOccupantDao().getClinetBedOccupants(bedOccupant.getClientId(),bedUnitEntity.getId());
		if(entity == null) throw new ResourceNotFoundException("Client not occupied bed unit "+bedOccupant.getBedUnit().getId());
		entity = BedOccupantConverter.modelToEntity(bedOccupant,entity);
		if(bedOccupant.getCheckoutDate()==null) entity.setCheckOutDate(new Date());
		if(bedOccupant.getClientId()!=null) entity.setDedupClientId(validationService.validateCleintId(bedOccupant.getClientId()));
		entity.setEnrollmentType(validationService.validateEnrillment(bedOccupant.getEnrollmentId()));
		sendClientMetaInfo(entity.getClientId(), entity.getDedupClientId(), false, "bedunit.occupant");
		daoFactory.getBedOccupantRepository().save(entity);
		bedUnitEntity.setOccupancy(false);
		daoFactory.getBedUnitRepository().save(bedUnitEntity);
		
	}	
	
	
	@Transactional
	public void deleteBedOccupant(UUID bedUnitId) {
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnitId+" not found");
		daoFactory.getBedOccupantRepository().delete(entity);
	}
	
	@Transactional
	public BedOccupant getBedOccupant(UUID bedUnitId) {
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnitId+" not found");		
		BedOccupant bedOccupant = BedOccupantConverter.entityToModel(entity);
		if(bedOccupant.getClientId()!=null) {
			ClientEntity clientEntity = daoFactory.getClientRepository().findOne(bedOccupant.getClientId());
			if(clientEntity!=null) bedOccupant.setClient(ClientConverter.entityToModel(clientEntity));
		}
		return bedOccupant;
	}
	
	@Transactional
	public BedOccupants getBedOccupants(UUID bedUnitId,Date fromdate, Date todate,Pageable pageable) {
		BedUnitEntity bedUnitEntity = daoFactory.getBedUnitRepository().findByIdAndProjectGroupCodeAndDeleted(bedUnitId,SecurityContextUtil.getUserProjectGroup(),false);
		if(bedUnitEntity == null) throw new ResourceNotFoundException("Bed unit not found");
		BedOccupants bedUnits = new BedOccupants();
		Page<BedOccupantEntity> entityPage = daoFactory.getBedOccupantDao().getBedOccupants(bedUnitId, fromdate, todate, pageable);
		for(BedOccupantEntity occupantEntity : entityPage.getContent()) {
			BedOccupant bedOccupant = BedOccupantConverter.entityToModel(occupantEntity);
			if(bedOccupant.getClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(bedOccupant.getClientId());
				if(clientEntity!=null) bedOccupant.setClient(ClientConverter.entityToModel(clientEntity));
			}
			bedUnits.addBedOccupant(bedOccupant);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        if(pageable!=null)pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        bedUnits.setPagination(pagination);
		return bedUnits;
	}

	@Transactional
	public BedOccupants getClientBedUnitOccupants(UUID dedupClientId, Date fromdate, Date todate, Pageable pageable) {
		BedOccupants bedUnits = new BedOccupants();
		Page<BedOccupantEntity> entityPage = daoFactory.getBedOccupantDao().getClinetBedOccupants(dedupClientId, fromdate, todate, pageable);
		for(BedOccupantEntity occupantEntity : entityPage.getContent()) {
			BedOccupant bedOccupant = BedOccupantConverter.entityToModel(occupantEntity);
			if(bedOccupant.getClientId()!=null) {
				ClientEntity clientEntity = daoFactory.getClientRepository().findOne(bedOccupant.getClientId());
				if(clientEntity!=null) bedOccupant.setClient(ClientConverter.entityToModel(clientEntity));
			}
			bedUnits.addBedOccupant(bedOccupant);
		}
		
		 SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(entityPage.getContent().size());
	        pagination.setTotal((int)entityPage.getTotalElements());
	        bedUnits.setPagination(pagination);
		return bedUnits;
	}
	
	public void checkReservation(BedOccupant bedOccupant,BedUnitEntity bedUnitEntity) throws Exception {
		Boolean isReserved = daoFactory.getBedUnitReservationDao().checkBedUnitOrRoomReservation(bedUnitEntity.getId(),bedUnitEntity.getRoom().getId(),bedOccupant.getStartDate(),bedOccupant.getEndDate(),bedOccupant.getClientId());
		if(!isReserved) {
			BedUnitReservation reservation = new BedUnitReservation();
			reservation.setBedUnitId(bedOccupant.getBedUnit().getId());
			reservation.setEndDate(bedOccupant.getEndDate());
			reservation.setStartDate(bedOccupant.getStartDate());
			reservation.setReservedClientId(bedOccupant.getClientId());
			serviceFactory.getBedReservationService().createBedUnitReservation(reservation);
		}
	}

	@Transactional
	public Boolean isBedUnitVacent(UUID bedunitid, Date startDate, Date endDate) {
			return daoFactory.getBedOccupantDao().isBedUnitVacent(bedunitid,startDate,endDate);
	}
}