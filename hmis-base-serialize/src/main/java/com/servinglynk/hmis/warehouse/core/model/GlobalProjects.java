package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("globalProjects")
public class GlobalProjects extends PaginatedModel {
	
	@JsonProperty("globalProjects")
	private List<GlobalProject> globalProjects = new ArrayList<>();

	public List<GlobalProject> getGlobalProjects() {
		return globalProjects;
	}

	public void setGlobalProjects(List<GlobalProject> globalProjects) {
		this.globalProjects = globalProjects;
	}
	
	public void addGlobalProject(GlobalProject globalProject) {
		this.globalProjects.add(globalProject);
	}

}
