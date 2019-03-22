package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("globalHouseholds")
public class GlobalHouseHolds extends PaginatedModel {

	@JsonProperty("globalHouseHolds")
	List<GlobalHouseHold> globalHouseHolds = new ArrayList<GlobalHouseHold>();
	
	public List<GlobalHouseHold> getGlobalHouseHolds() {
		return globalHouseHolds;
	}

	public void setGlobalHouseHolds(List<GlobalHouseHold> globalHouseHolds) {
		this.globalHouseHolds = globalHouseHolds;
	}

	public void addGlobalHouseHold(GlobalHouseHold globalHouseHold) {
		this.globalHouseHolds.add(globalHouseHold);
	}
}
