package com.servinglynk.hmis.household.web.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.household.domain.Client;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.enums.RelationshipToHOfHEnum;
import com.servinglynk.hmis.household.repository.ClientRepository;
import com.servinglynk.hmis.household.repository.GlobalHouseholdRepository;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipModel;
import com.servinglynk.hmis.household.web.rest.util.SecurityContextUtil;

@Component("householdMembershipMapperV3")
public class HouseholdMembershipMapperImplV3 {

	@Autowired
	GlobalHouseholdRepository globalHouseholdRepository; 
	
	@Autowired
	ClientRepository clientRepository;
	
	
	public HouseholdMembershipModel householdMembershipToHouseholdMembershipDTO(HouseholdMembership householdMembership) {
		HouseholdMembershipModel householdMembershipDTO = new HouseholdMembershipModel();
			householdMembershipDTO.setDateCreated(householdMembership.getDateCreated());
			householdMembershipDTO.setDateUpdated(householdMembership.getDateUpdated());
			householdMembershipDTO.setGlobalClientId(householdMembership.getGlobalClientId());
			householdMembershipDTO.setGlobalHouseholdId(householdMembership.getGlobalHousehold().getGlobalHouseholdId());
			if(householdMembership.getRelationshipToHeadOfHousehold()!=null) {
				householdMembershipDTO.setRelationshipToHeadOfHousehold(Integer.parseInt(householdMembership.getRelationshipToHeadOfHousehold().getValue()));
			}
			householdMembershipDTO.setHouseholdMembershipId(householdMembership.getHouseholdMembershipId());
			householdMembershipDTO.setUserId(householdMembership.getUserId());
			householdMembershipDTO.setLink(householdMembership.getClientLink());
			householdMembershipDTO.setSchemaYear(householdMembership.getSchemaYear());
			
			if(householdMembership.getDedupClientId()!=null)
			{
				List<Client> clients = clientRepository.findByDedupClientIdAndProjectGroupCodeOrderBySchemaYearDesc(householdMembershipDTO.getDedupClientId(),SecurityContextUtil.getUserProjectGroup());
				householdMembershipDTO.setGlobalClientId(clients.get(0).getId());
				householdMembershipDTO.setDedupClientId(clients.get(0).getDedupClientId());
				householdMembershipDTO.setLink("/hmis-clientapi/rest/v"+clients.get(0).getSchemaYear()+"/clients/"+clients.get(0).getId());
			}
		return householdMembershipDTO;
	}


	public List<HouseholdMembershipModel> householdMembershipsToHouseholdMembershipDTOs(
			List<HouseholdMembership> householdMemberships) {
			List<HouseholdMembershipModel> householdMembershipDTOs = new ArrayList<HouseholdMembershipModel>();
			for(HouseholdMembership  householdMembership : householdMemberships){
				householdMembershipDTOs.add(this.householdMembershipToHouseholdMembershipDTO(householdMembership));
			}
		return householdMembershipDTOs;
	}

	public HouseholdMembership householdMembershipDTOToHouseholdMembership(
			HouseholdMembershipModel householdMembershipDTO) {
		HouseholdMembership householdMembership = new HouseholdMembership();
		householdMembership.setDateCreated(householdMembershipDTO.getDateCreated());
		householdMembership.setDateUpdated(householdMembershipDTO.getDateUpdated());
		householdMembership.setGlobalClientId(householdMembershipDTO.getGlobalClientId());
		householdMembership.setGlobalHousehold(globalHouseholdRepository.findOne(householdMembershipDTO.getGlobalHouseholdId()));		
		if(householdMembershipDTO.getRelationshipToHeadOfHousehold()!=null) {
			householdMembership.setRelationshipToHeadOfHousehold(RelationshipToHOfHEnum.lookupEnum(householdMembershipDTO.getRelationshipToHeadOfHousehold().toString()));
		}
		householdMembership.setHouseholdMembershipId(householdMembershipDTO.getHouseholdMembershipId());
		householdMembership.setClientLink(householdMembershipDTO.getLink());
		householdMembership.setSchemaYear(householdMembershipDTO.getSchemaYear());
		return householdMembership;
	}

	public List<HouseholdMembership> householdMembershipDTOsToHouseholdMemberships(
			List<HouseholdMembershipModel> householdMembershipDTOs) {
			List<HouseholdMembership> householdMemberships = new ArrayList<HouseholdMembership>();
			for(HouseholdMembershipModel householdMembershipDTO : householdMembershipDTOs){
				householdMemberships.add(this.householdMembershipDTOToHouseholdMembership(householdMembershipDTO));
			}
		return householdMemberships;
	}

}
