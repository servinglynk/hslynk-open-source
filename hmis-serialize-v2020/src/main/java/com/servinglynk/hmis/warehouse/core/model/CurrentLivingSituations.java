package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("currentLivingSituations")
public class CurrentLivingSituations extends PaginatedModel {

	@JsonProperty("currentLivingSituations")
	List<CurrentLivingSituation> currentLivingSituations = new ArrayList<CurrentLivingSituation>();

	public List<CurrentLivingSituation> getCurrentLivingSituations() {
		return currentLivingSituations;
	}

	public void setCurrentLivingSituations(List<CurrentLivingSituation> currentLivingSituations) {
		this.currentLivingSituations = currentLivingSituations;
	}
	
	public void addCurrentLivingSituation(CurrentLivingSituation currentLivingSituation){
		this.currentLivingSituations.add(currentLivingSituation);
	}
	
}
