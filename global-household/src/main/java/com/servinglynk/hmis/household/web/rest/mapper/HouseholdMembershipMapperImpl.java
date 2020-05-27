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
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;
import com.servinglynk.hmis.household.web.rest.util.SecurityContextUtil;

@Component("householdMembershipMapper")
public class HouseholdMembershipMapperImpl implements HouseholdMembershipMapper {

	@Autowired
	GlobalHouseholdRepository globalHouseholdRepository; 
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@Override
	public HouseholdMembershipDTO householdMembershipToHouseholdMembershipDTO(HouseholdMembership householdMembership) {
			HouseholdMembershipDTO householdMembershipDTO = new HouseholdMembershipDTO();
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

	@Override
	public List<HouseholdMembershipDTO> householdMembershipsToHouseholdMembershipDTOs(
			List<HouseholdMembership> householdMemberships) {
			List<HouseholdMembershipDTO> householdMembershipDTOs = new ArrayList<HouseholdMembershipDTO>();
			for(HouseholdMembership  householdMembership : householdMemberships){
				householdMembershipDTOs.add(this.householdMembershipToHouseholdMembershipDTO(householdMembership));
			}
		return householdMembershipDTOs;
	}

	@Override
	public HouseholdMembership householdMembershipDTOToHouseholdMembership(
			HouseholdMembershipDTO householdMembershipDTO) {
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

	@Override
	public List<HouseholdMembership> householdMembershipDTOsToHouseholdMemberships(
			List<HouseholdMembershipDTO> householdMembershipDTOs) {
			List<HouseholdMembership> householdMemberships = new ArrayList<HouseholdMembership>();
			for(HouseholdMembershipDTO householdMembershipDTO : householdMembershipDTOs){
				householdMemberships.add(this.householdMembershipDTOToHouseholdMembership(householdMembershipDTO));
			}
		return householdMemberships;
	}

}
