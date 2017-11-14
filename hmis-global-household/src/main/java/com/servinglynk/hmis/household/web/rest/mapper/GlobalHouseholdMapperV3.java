package com.servinglynk.hmis.household.web.rest.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.household.domain.Client;
import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.repository.ClientRepository;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdModel;
import com.servinglynk.hmis.household.web.rest.util.SecurityContextUtil;


@Component("globalHouseholdMapperV3")
public class GlobalHouseholdMapperV3 {

	
	@Autowired
	ClientRepository clientRepository;
	
	public GlobalHouseholdModel entityToModel(GlobalHousehold globalHousehold) {
		GlobalHouseholdModel model = new GlobalHouseholdModel();
		model.setDateCreated(globalHousehold.getDateCreated());
		model.setDateUpdated(globalHousehold.getDateUpdated());
		model.setDedupClientId(globalHousehold.getDedupClientId());
		model.setGlobalHouseholdId(globalHousehold.getGlobalHouseholdId());
		model.setHeadOfHouseholdId(globalHousehold.getHeadOfHouseholdId());
		
		if(globalHousehold.getDedupClientId()!=null)
		{
			List<Client> clients = clientRepository.findByDedupClientIdAndProjectGroupCodeOrderBySchemaYearDesc(globalHousehold.getDedupClientId(),SecurityContextUtil.getUserProjectGroup());
			model.setHeadOfHouseholdId(clients.get(0).getId());
			model.setDedupClientId(clients.get(0).getDedupClientId());
			model.setLink("/hmis-clientapi/rest/v"+clients.get(0).getSchemaYear()+"/clients/"+clients.get(0).getId());
		}
		
		return model;
	}
	
	
	public GlobalHousehold modelToEntity(GlobalHouseholdModel globalHouseholdModel, GlobalHousehold globalHousehold) {
	
		if(globalHousehold==null) {
			globalHousehold = new GlobalHousehold();
				HouseholdMembership membership = new HouseholdMembership();
				membership.setGlobalClientId(globalHouseholdModel.getHeadOfHouseholdId());
				membership.setGlobalHousehold(globalHousehold);
				membership.setClientLink(globalHouseholdModel.getLink());
				globalHousehold.getMembers().add(membership);
		}		
	
		globalHousehold.setHeadOfHouseholdId(globalHouseholdModel.getHeadOfHouseholdId());
		globalHousehold.setDedupClientId(globalHouseholdModel.getDedupClientId());
		globalHousehold.setSchemaYear(globalHouseholdModel.getSchemaYear());
		globalHousehold.setHeadOfHouseHoldLink(globalHouseholdModel.getLink());
		return globalHousehold;
	}
	
}
