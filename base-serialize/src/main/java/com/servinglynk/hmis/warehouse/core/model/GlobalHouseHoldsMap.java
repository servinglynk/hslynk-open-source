package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalHouseHoldsMap {

	@JsonProperty("globalHouseholdMappings")
	List<GlobalHouseHoldMap> globalHouseHoldMaps = new ArrayList<GlobalHouseHoldMap>();

	public List<GlobalHouseHoldMap> getGlobalHouseHoldMaps() {
		return globalHouseHoldMaps;
	}

	public void setGlobalHouseHoldMaps(List<GlobalHouseHoldMap> globalHouseHoldMaps) {
		this.globalHouseHoldMaps = globalHouseHoldMaps;
	}
	
	public void addGlobalHouseHoldMap(GlobalHouseHoldMap globalHouseHoldMap) {
		this.globalHouseHoldMaps.add(globalHouseHoldMap);
	}
}
