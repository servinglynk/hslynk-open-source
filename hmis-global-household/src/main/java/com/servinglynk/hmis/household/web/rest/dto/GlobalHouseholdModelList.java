package com.servinglynk.hmis.household.web.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class GlobalHouseholdModelList {
	
	@Valid
	public List<GlobalHouseholdModel>  globalHouseholds = new ArrayList<GlobalHouseholdModel>();

	public List<GlobalHouseholdModel> getGlobalHouseholds() {
		return globalHouseholds;
	}

	public void setGlobalHouseholds(List<GlobalHouseholdModel> globalHouseholds) {
		this.globalHouseholds = globalHouseholds;
	}
	
	

}
