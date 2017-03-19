package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("worstHousingSituations")
public class WorstHousingSituations extends PaginatedModel {

	
	@JsonProperty("worstHousingSituation")
	List<WorstHousingSituation> worstHousingSituations = new ArrayList<WorstHousingSituation>();

	public List<WorstHousingSituation> getWorstHousingSituations() {
		return worstHousingSituations;
	}

	public void setWorstHousingSituations(List<WorstHousingSituation> worstHousingSituations) {
		this.worstHousingSituations = worstHousingSituations;
	}
	
	public void addWorstHousingSituation(WorstHousingSituation worstHousingSituation){
		this.worstHousingSituations.add(worstHousingSituation);
	}
	
}
