package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("educations")
public class Educations extends PaginatedModel{


       @JsonProperty("educations") 
       List<Education>educations = new ArrayList<Education>();
       public List<Education> getEducations() {
           return educations;
       }

        public void setEducations(List<Education> educations) {
           this.educations = educations;
       }
 
       public void addEducation(Education education) {
           this.educations.add(education);
       }
 }
