package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class ProjectCompletionStatuses extends PaginatedModel {
     private List<ProjectCompletionStatus> projectCompletionStatuss = new ArrayList<ProjectCompletionStatus>();
 
     public List<ProjectCompletionStatus> getProjectCompletionStatuss() {
         return projectCompletionStatuss;
     }
 
     public void setProjectCompletionStatuss(List<ProjectCompletionStatus> projectCompletionStatuss) {
          this.projectCompletionStatuss = projectCompletionStatuss;
     }
 
     public void addProjectCompletionStatus(ProjectCompletionStatus projectCompletionStatus){
         this.projectCompletionStatuss.add(projectCompletionStatus);
     }
}
