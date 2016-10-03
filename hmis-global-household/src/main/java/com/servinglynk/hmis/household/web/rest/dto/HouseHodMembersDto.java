package com.servinglynk.hmis.household.web.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class HouseHodMembersDto {

	@Valid
	List<HouseholdMembershipDTO> members = new ArrayList<>();

	public List<HouseholdMembershipDTO> getMembers() {
		return members;
	}

	public void setMembers(List<HouseholdMembershipDTO> members) {
		this.members = members;
	}	
}