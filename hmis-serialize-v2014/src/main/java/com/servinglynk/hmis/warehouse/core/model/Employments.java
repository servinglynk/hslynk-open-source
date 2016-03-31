package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class Employments extends PaginatedModel{


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
