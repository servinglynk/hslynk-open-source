package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("percentamis")
public class Percentamis extends PaginatedModel {

	@JsonProperty("percentamis")	
	List<Percentami> percentamis = new ArrayList<Percentami>();

	public List<Percentami> getPercentamis() {
		return percentamis;
	}

	public void setPercentamis(List<Percentami> percentamis) {
		this.percentamis = percentamis;
	}
	
	public void addPercentami(Percentami percentami){
		this.percentamis.add(percentami);
	}
}
