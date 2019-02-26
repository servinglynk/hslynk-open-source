package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exitpaths")
public class Exitpaths extends PaginatedModel{


       @JsonProperty("exitpaths") 
       List<Exitpath>exitpaths = new ArrayList<Exitpath>();
       public List<Exitpath> getExitpaths() {
           return exitpaths;
       }

        public void setExitpaths(List<Exitpath> exitpaths) {
           this.exitpaths = exitpaths;
       }
 
       public void addExitpath(Exitpath exitpath) {
           this.exitpaths.add(exitpath);
       }
 }
