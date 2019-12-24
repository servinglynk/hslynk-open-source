package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.HmisHousehold;
import com.servinglynk.hmis.warehouse.core.model.HmisHouseholds;
import com.servinglynk.hmis.warehouse.core.model.HouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2016.Client;
import com.servinglynk.hmis.warehouse.model.v2016.HmisHouseHoldMember;
import com.servinglynk.hmis.warehouse.service.HmisHouseHoldService;
import com.servinglynk.hmis.warehouse.service.converter.HmisHouseHoldConverter;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class HmisHouseHoldServiceImpl extends ServiceBase implements HmisHouseHoldService {

	@Transactional
	public HmisHousehold createHouseHold(HmisHousehold model,Account caller) {
		Client client = daoFactory.getClientDao().getClientById(model.getHeadOfHouseHoldId());
		if(client==null) throw new ResourceNotFoundException("Head of house hold not found "+model.getHeadOfHouseHoldId());
		com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold entity = new com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold();
		entity.setHeadOfHouseholdId(model.getHeadOfHouseHoldId());
		entity.setDedupClientId(client.getDedupClientId());
		entity.setDateCreated(LocalDateTime.now());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setDeleted(false);
		entity.setUser(caller.getAccountId());
		entity.setProjectGroupCode(caller.getProjectGroup().getProjectGroupCode());
		daoFactory.getHmisHouseholdDao().createHouseHold(entity);
		model.setHouseHoldId(entity.getId());
		return model;
	}

	@Transactional
	public void updateHouseHold(HmisHousehold model,Account caller) {
		com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold entity = daoFactory.getHmisHouseholdDao().getHouseHoldById(model.getHouseHoldId());
		if(entity == null) throw new ResourceNotFoundException("House hold not found"+model.getHouseHoldId());
		Client client = daoFactory.getClientDao().getClientById(model.getHeadOfHouseHoldId());
		if(client==null) throw new ResourceNotFoundException("Head of house hold not found "+model.getHeadOfHouseHoldId());
		entity.setHeadOfHouseholdId(client.getId());
		entity.setDedupClientId(client.getDedupClientId());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setUser(caller.getAccountId());
		daoFactory.getHmisHouseholdDao().updateHouseHold(entity);
	}

	@Transactional
	public void deleteHouseHold(UUID householeId) {
		com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold entity = daoFactory.getHmisHouseholdDao().getHouseHoldById(householeId);
		if(entity == null) throw new ResourceNotFoundException("House hold not found"+householeId);
		daoFactory.getHmisHouseholdDao().deleteHouseHold(entity);

	}

	@Transactional
	public HmisHousehold getHouseHoldById(UUID householeId) {	
		com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold entity = daoFactory.getHmisHouseholdDao().getHouseHoldById(householeId);
		if(entity == null) throw new ResourceNotFoundException("House hold not found"+householeId);
		return HmisHouseHoldConverter.entityToModel(entity);
	}

	@Transactional
	public HmisHouseholds getAllHouseHolds(Integer startIndex, Integer maxItems) {
		HmisHouseholds hmisHouseholds = new HmisHouseholds();
		List<com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold> entities = daoFactory.getHmisHouseholdDao().getAllHouseHolds(startIndex, maxItems);
		for(com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold entity : entities) {
			hmisHouseholds.addHmisHouseHold(HmisHouseHoldConverter.entityToModel(entity));
		}
		
        long count = daoFactory.getHmisHouseholdDao().getHouseHoldCount();
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(entities.size());
        pagination.setTotal((int)count);
        hmisHouseholds.setPagination(pagination);

		return hmisHouseholds;
	}

	@Transactional
	public void addHouseHoldMember(HouseHoldMember member, Account caller) {
		com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold entity = daoFactory.getHmisHouseholdDao().getHouseHoldById(member.getHouseHoldId());
		if(entity == null) throw new ResourceNotFoundException("House hold not found"+member.getHouseHoldId());
		Client client = daoFactory.getClientDao().getClientById(member.getMemberId());
		if(client==null) throw new ResourceNotFoundException("House hold member not found "+member.getMemberId());
		HmisHouseHoldMember houseHoldMember = new HmisHouseHoldMember();
		houseHoldMember.setDateCreated(LocalDateTime.now());
		houseHoldMember.setDateUpdated(LocalDateTime.now());
		houseHoldMember.setDeleted(false);
		houseHoldMember.setUser(caller.getAccountId());
		houseHoldMember.setProjectGroupCode(caller.getProjectGroup().getProjectGroupCode());
		houseHoldMember.setMemberId(client.getId());
		houseHoldMember.setHmisHousehold(entity);
		houseHoldMember.setMemberDedupId(client.getDedupClientId());
		houseHoldMember.setRelationWithHouseHold(member.getRelationWithHouseHold());
		daoFactory.getHmisHouseholdDao().addHouseHoldMember(houseHoldMember);
	}

	@Transactional
	public void removeHouseHoldMember(UUID householdId, UUID memberid, Account caller) {
		com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold entity = daoFactory.getHmisHouseholdDao().getHouseHoldById(householdId);
		if(entity == null) throw new ResourceNotFoundException("House hold not found"+householdId);
		HmisHouseHoldMember houseHoldMember = daoFactory.getHmisHouseholdDao().getHouseHoldMember(householdId, memberid);
		if(houseHoldMember==null) throw new ResourceNotFoundException("House hold member not associated with household");
		daoFactory.getHmisHouseholdDao().removeHouseHoldMember(houseHoldMember);
	}

}
