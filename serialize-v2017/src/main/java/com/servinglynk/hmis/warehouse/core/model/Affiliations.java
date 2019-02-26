package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("affiliations")
public class Affiliations extends PaginatedModel {

	@JsonProperty("affiliations")
	List<Affiliation> affiliations = new ArrayList<Affiliation>();

	public List<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(List<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}
	
	public void addAffiliation(Affiliation affiliation){
		this.affiliations.add(affiliation);
	}
	
}
