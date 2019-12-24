package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("hmisHouseholds")
public class HmisHouseholds extends PaginatedModel {

	List<HmisHousehold> hmisHouseholds = new ArrayList<HmisHousehold>();

	public List<HmisHousehold> getHmisHouseholds() {
		return hmisHouseholds;
	}

	public void setHmisHouseholds(List<HmisHousehold> hmisHouseholds) {
		this.hmisHouseholds = hmisHouseholds;
	}
	
	public void addHmisHouseHold(HmisHousehold hmisHousehold) {
		this.hmisHouseholds.add(hmisHousehold);
	}
}
