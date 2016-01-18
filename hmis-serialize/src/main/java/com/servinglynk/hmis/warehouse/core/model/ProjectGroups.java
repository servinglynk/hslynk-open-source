package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
@JsonRootName("projectgroups")
public class ProjectGroups extends PaginatedModel {
	
	 @JsonProperty("projectGroups")
     private List<ProjectGroup> projectGroups = new ArrayList<ProjectGroup>();
 



	public void addProjectGroup(ProjectGroup projectGroup){
         this.projectGroups.add(projectGroup);
     }




	public List<ProjectGroup> getProjectGroups() {
		return projectGroups;
	}




	public void setProjectGroups(List<ProjectGroup> projectGroups) {
		this.projectGroups = projectGroups;
	}
}
