package com.servinglynk.hmis.household.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.repository.GlobalHouseholdRepository;
import com.servinglynk.hmis.household.repository.HouseholdMembershipRepository;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdModel;
import com.servinglynk.hmis.household.web.rest.mapper.GlobalHouseholdMapperV3;
import com.servinglynk.hmis.household.web.rest.util.SecurityContextUtil;
import com.servinglynk.hmis.warehouse.client.MessageSender;
import com.servinglynk.hmis.warehouse.model.AMQEvent;

@Component("globalHouseHoldServiveV3")
public class GlobalHouseHoldServiveV3 {
	
	
	@Autowired MessageSender messageSender; 
	
	@Autowired
	GlobalHouseholdRepository globalHouseholdRepository;
	
	@Autowired
	GlobalHouseholdMapperV3 globalHouseholdMapper;
	
    @Autowired
    private HouseholdMembershipRepository householdMembershipRepository;

	public GlobalHouseholdModel save(GlobalHouseholdModel globalHouseholdModel) {
		  String projectGroup = SecurityContextUtil.getUserProjectGroup();

		 List<GlobalHousehold> globalHouseholds = globalHouseholdRepository.findByDedupClientIdAndProjectGroupCodeAndDeleted(globalHouseholdModel.getDedupClientId(), projectGroup, false);

		 GlobalHousehold globalHousehold = null;
		 if(!globalHouseholds.isEmpty()) {
			 globalHousehold = globalHouseholds.get(0);			
		}
		 globalHousehold = globalHouseholdMapper.modelToEntity(globalHouseholdModel, globalHousehold);
		globalHouseholdRepository.save(globalHousehold);		
		
		this.publishGlobalHouseHold(globalHousehold);
		return globalHouseholdMapper.entityToModel(globalHousehold);
	}
	
    private void publishGlobalHouseHold(GlobalHousehold globalHousehold) {
		AMQEvent amqEvent = new AMQEvent();
		
		amqEvent.setEventType("globalHouseHold");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("genericHouseHoldId", globalHousehold.getGlobalHouseholdId());
		data.put("clientId", globalHousehold.getHeadOfHouseholdId());
		data.put("dedupClientId", globalHousehold.getDedupClientId());
		data.put("deleted", false);
		data.put("projectGroupCode", globalHousehold.getProjectGroupCode());
		data.put("userId", globalHousehold.getUserId());
		amqEvent.setPayload(data);
		amqEvent.setModule("client-api");
		amqEvent.setSubsystem("generic-household");
		messageSender.sendAmqMessage(amqEvent);	
	}

	public GlobalHouseholdModel update(GlobalHouseholdModel globalHouseholdModel) {
		GlobalHousehold globalHousehold = globalHouseholdRepository.findOne(globalHouseholdModel.getGlobalHouseholdId());
		if(globalHousehold==null) throw new ResourceNotFoundException("Global household not found "+globalHouseholdModel.getGlobalHouseholdId());
		globalHousehold = globalHouseholdMapper.modelToEntity(globalHouseholdModel, globalHousehold);
		globalHouseholdRepository.save(globalHousehold);
		return globalHouseholdModel;
	}

	public Page findAll(Pageable pageable) {
		  String projectGroup = SecurityContextUtil.getUserProjectGroup();
	        Page<GlobalHousehold> result = globalHouseholdRepository.findByProjectGroupCodeAndDeletedOrderBySchemaYearDesc(projectGroup,pageable,false);
	        List<UUID> dedups = new ArrayList<>();
	        List<GlobalHousehold> data = new ArrayList<>();
	        for(GlobalHousehold globalHousehold : result.getContent()) {
	        			if(!dedups.contains(globalHousehold.getDedupClientId()) && globalHousehold.getDedupClientId()!=null) {
	        				data.add(globalHousehold);
	        				dedups.add(globalHousehold.getDedupClientId());
	        			}
	        				
	        }	        
	       
	   return new PageImpl<>(data, pageable, result.getTotalElements());
	}

	public GlobalHouseholdModel findOne(UUID id) {
		  String projectGroup = SecurityContextUtil.getUserProjectGroup();
		GlobalHousehold globalHousehold =		globalHouseholdRepository.findByGlobalHouseholdIdAndProjectGroupCodeAndDeleted(id, projectGroup, false);
		 if(globalHousehold==null) throw new ResourceNotFoundException("Global household not found "+id);
		 
		return globalHouseholdMapper.entityToModel(globalHousehold);
	}

	public void delete(UUID id) {
	     String projectGroup = SecurityContextUtil.getUserProjectGroup();
	     GlobalHousehold globalHousehold =	globalHouseholdRepository.findByGlobalHouseholdIdAndProjectGroupCodeAndDeleted(id, projectGroup,false);
	        if(globalHousehold==null) throw new ResourceNotFoundException("Global household not found "+id);
	        List<HouseholdMembership> members = householdMembershipRepository.findByGlobalHouseholdAndDeleted(globalHousehold, false);
	        householdMembershipRepository.delete(members);
	        globalHouseholdRepository.delete(globalHousehold);
	        
	}

}
