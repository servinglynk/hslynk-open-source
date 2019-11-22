package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("projectSubGroups")
public class ProjectSubGroups extends PaginatedModel {
	
	@JsonProperty("projectSubGroups")
	List<ProjectSubGroup> projectSubGroups = new ArrayList<ProjectSubGroup>();

	public List<ProjectSubGroup> getProjectSubGroups() {
		return projectSubGroups;
	}

	public void setProjectSubGroups(List<ProjectSubGroup> projectSubGroups) {
		this.projectSubGroups = projectSubGroups;
	}
	
	public void addProjectSubGroup(ProjectSubGroup projectSubGroup) {
		this.projectSubGroups.add(projectSubGroup);
	}
 
}
