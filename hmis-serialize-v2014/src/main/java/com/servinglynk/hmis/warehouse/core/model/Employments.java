package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
@JsonRootName("employments")
public class Employments extends PaginatedModel {
     private List<Employment> employments = new ArrayList<Employment>();
 
     public List<Employment> getEmployments() {
         return employments;
     }
 
     public void setEmployments(List<Employment> employments) {
          this.employments = employments;
     }
 
     public void addEmployment(Employment employment){
         this.employments.add(employment);
     }
}
