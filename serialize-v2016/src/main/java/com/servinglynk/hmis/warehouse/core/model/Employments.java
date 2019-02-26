package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("employments")
public class Employments extends PaginatedModel{


       @JsonProperty("employments") 
       List<Employment>employments = new ArrayList<Employment>();
       public List<Employment> getEmployments() {
           return employments;
       }

        public void setEmployments(List<Employment> employments) {
           this.employments = employments;
       }
 
       public void addEmployment(Employment employment) {
           this.employments.add(employment);
       }
 }
