package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("pathstatuses")
public class Pathstatuses extends PaginatedModel {

	@JsonProperty("pathstatuses")
	List<Pathstatus> pathstatuses = new ArrayList<Pathstatus>();

	public List<Pathstatus> getPathstatuses() {
		return pathstatuses;
	}

	public void setPathstatuses(List<Pathstatus> pathstatuses) {
		this.pathstatuses = pathstatuses;
	}
	
	public void addPathstatus(Pathstatus pathstatus){
		this.pathstatuses.add(pathstatus);
	}
	
}
