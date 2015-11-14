package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("schoolstatuses")
public class Schoolstatuses extends PaginatedModel {

	@JsonProperty("schoolstatuses")
	List<Schoolstatus> schoolstatuses = new ArrayList<Schoolstatus>();

	public List<Schoolstatus> getSchoolstatuses() {
		return schoolstatuses;
	}

	public void setSchoolstatuses(List<Schoolstatus> schoolstatuses) {
		this.schoolstatuses = schoolstatuses;
	}
	
	public void addSchoolstatus(Schoolstatus schoolstatus){
		this.schoolstatuses.add(schoolstatus);
	}
	
	
}