package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exithousingassessments")
public class Exithousingassessments extends PaginatedModel{


       @JsonProperty("exithousingassessments") 
       List<Exithousingassessment>exithousingassessments = new ArrayList<Exithousingassessment>();
       public List<Exithousingassessment> getExithousingassessments() {
           return exithousingassessments;
       }

        public void setExithousingassessments(List<Exithousingassessment> exithousingassessments) {
           this.exithousingassessments = exithousingassessments;
       }
 
       public void addExithousingassessment(Exithousingassessment exithousingassessment) {
           this.exithousingassessments.add(exithousingassessment);
       }
 }
