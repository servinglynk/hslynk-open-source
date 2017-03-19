package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("funders")
public class Funders extends PaginatedModel {

	@JsonProperty("funders")
	List<Funder> funders = new ArrayList<Funder>();

	public List<Funder> getFunders() {
		return funders;
	}

	public void setFunders(List<Funder> funders) {
		this.funders = funders;
	}
	
	public void addFunder(Funder  funder){
		this.funders.add(funder);
	}
}
