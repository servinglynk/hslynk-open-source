package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("dateofengagements")
public class Dateofengagements extends PaginatedModel{


       @JsonProperty("dateofengagements") 
       List<Dateofengagement>dateofengagements = new ArrayList<Dateofengagement>();
       public List<Dateofengagement> getDateofengagements() {
           return dateofengagements;
       }

        public void setDateofengagements(List<Dateofengagement> dateofengagements) {
           this.dateofengagements = dateofengagements;
       }
 
       public void addDateofengagement(Dateofengagement dateofengagement) {
           this.dateofengagements.add(dateofengagement);
       }
 }
