package com.servinglynk.hmis.household.web.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class GlobalHouseholdsDTO {

	@Valid
	private List<GlobalHouseholdDTO> globalHouseholds = new ArrayList<GlobalHouseholdDTO>();

	public List<GlobalHouseholdDTO> getGlobalHouseholds() {
		return globalHouseholds;
	}

	public void setGlobalHouseholds(List<GlobalHouseholdDTO> globalHouseholds) {
		this.globalHouseholds = globalHouseholds;
	}	 
}