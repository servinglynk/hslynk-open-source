package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("projectCocs")
public class Projectcocs extends PaginatedModel {

	@JsonProperty("projectCocs")
	List<Projectcoc> projectcocs = new ArrayList<Projectcoc>();

	public List<Projectcoc> getProjectcocs() {
		return projectcocs;
	}

	public void setProjectcocs(List<Projectcoc> projectcocs) {
		this.projectcocs = projectcocs;
	}
	
	public void addProjectcoc(Projectcoc projectcoc){
		this.projectcocs.add(projectcoc);
	}
}