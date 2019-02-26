package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
@JsonRootName("projects")
public class Projects extends PaginatedModel {
	
	 @JsonProperty("projects")
     private List<Project> projects = new ArrayList<Project>();
 
     public List<Project> getProjects() {
         return projects;
     }
 
     public void setProjects(List<Project> projects) {
          this.projects = projects;
     }
 
     public void addProject(Project project){
         this.projects.add(project);
     }
}
