package com.servinglynk.hmis.household.web.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.repository.GlobalHouseholdRepository;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;

@Component("householdMembershipMapper")
public class HouseholdMembershipMapperImpl implements HouseholdMembershipMapper {

	@Autowired
	GlobalHouseholdRepository globalHouseholdRepository; 
	
	
	@Override
	public HouseholdMembershipDTO householdMembershipToHouseholdMembershipDTO(HouseholdMembership householdMembership) {
			HouseholdMembershipDTO householdMembershipDTO = new HouseholdMembershipDTO();
			householdMembershipDTO.setDateCreated(householdMembership.getDateCreated());
			householdMembershipDTO.setDateUpdated(householdMembership.getDateUpdated());
			householdMembershipDTO.setGlobalClientId(householdMembership.getGlobalClientId());
			householdMembershipDTO.setGlobalHouseholdId(householdMembership.getGlobalHousehold().getGlobalHouseholdId());
			householdMembershipDTO.setInactive(householdMembership.getInactive());
			householdMembershipDTO.setRelationshipToHeadOfHousehold(householdMembership.getRelationshipToHeadOfHousehold());
			householdMembershipDTO.setUserCreate(householdMembership.getUserCreate());
			householdMembershipDTO.setUserUpdate(householdMembership.getUserUpdate());
			householdMembershipDTO.setHouseholdMembershipId(householdMembership.getHouseholdMembershipId());
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
		if(householdMembershipDTO.getInactive()==null)
			householdMembership.setInactive(false);
		else
			householdMembership.setInactive(householdMembershipDTO.getInactive());
		
		householdMembership.setRelationshipToHeadOfHousehold(householdMembershipDTO.getRelationshipToHeadOfHousehold());
		householdMembership.setUserCreate(householdMembershipDTO.getUserCreate());
		householdMembership.setUserUpdate(householdMembershipDTO.getUserUpdate());
		householdMembership.setHouseholdMembershipId(householdMembershipDTO.getHouseholdMembershipId());
		householdMembership.setClientLink(householdMembershipDTO.getLink());
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
