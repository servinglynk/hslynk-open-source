package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollmentCocs")
public class EnrollmentCocs extends PaginatedModel{


       @JsonProperty("enrollmentCocs") 
       List<EnrollmentCoc>enrollmentCocs = new ArrayList<EnrollmentCoc>();
       public List<EnrollmentCoc> getEnrollmentCocs() {
           return enrollmentCocs;
       }

        public void setEnrollmentCocs(List<EnrollmentCoc> enrollmentCocs) {
           this.enrollmentCocs = enrollmentCocs;
       }
 
       public void addEnrollmentCoc(EnrollmentCoc enrollmentCoc) {
           this.enrollmentCocs.add(enrollmentCoc);
       }
 }
