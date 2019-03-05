package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
@JsonRootName("projects")
public class BaseProjects extends PaginatedModel {
	
	 @JsonProperty("projects")
     private List<BaseProject> projects = new ArrayList<BaseProject>();
 
     public List<BaseProject> getProjects() {
         return projects;
     }
 
     public void setProjects(List<BaseProject> projects) {
          this.projects = projects;
     }
 
     public void addProject(BaseProject project){
         this.projects.add(project);
     }
}
