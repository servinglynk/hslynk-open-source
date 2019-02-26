package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exitrhys")
public class Exitrhys extends PaginatedModel{


       @JsonProperty("exitrhys") 
       List<Exitrhy>exitrhys = new ArrayList<Exitrhy>();
       public List<Exitrhy> getExitrhys() {
           return exitrhys;
       }

        public void setExitrhys(List<Exitrhy> exitrhys) {
           this.exitrhys = exitrhys;
       }
 
       public void addExitrhy(Exitrhy exitrhy) {
           this.exitrhys.add(exitrhy);
       }
 }
