package com.servinglynk.hmis.household.web.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class HouseholdMembershipModels {
	@Valid
	List<HouseholdMembershipModel> members = new ArrayList<HouseholdMembershipModel>();

	public List<HouseholdMembershipModel> getMembers() {
		return members;
	}

	public void setMembers(List<HouseholdMembershipModel> members) {
		this.members = members;
	}	
}