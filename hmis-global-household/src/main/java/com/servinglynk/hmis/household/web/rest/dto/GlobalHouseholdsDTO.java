package com.servinglynk.hmis.household.web.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.internal.lang.annotation.ajcDeclareEoW;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GlobalHouseholdsDTO {

	@Valid
	@JsonProperty("genericHouseholds")
	private List<GlobalHouseholdDTO> globalHouseholds = new ArrayList<GlobalHouseholdDTO>();

	public List<GlobalHouseholdDTO> getGlobalHouseholds() {
		return globalHouseholds;
	}

	public void setGlobalHouseholds(List<GlobalHouseholdDTO> globalHouseholds) {
		this.globalHouseholds = globalHouseholds;
	}	 
}