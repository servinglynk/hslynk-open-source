package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("geographies")
public class Geographies extends PaginatedModel {
	
	@JsonProperty("geographies")
	List<Geography> geographies = new ArrayList<Geography>();

	public List<Geography> getGeographies() {
		return geographies;
	}

	public void setGeographies(List<Geography> geographies) {
		this.geographies = geographies;
	}
	
	public void addGeography(Geography  Geography){
		this.geographies.add(Geography);
	}

}
