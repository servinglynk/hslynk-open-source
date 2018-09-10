package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pathStatuses")
public class Pathstatuses extends PaginatedModel{


       @JsonProperty("pathStatuses") 
       List<Pathstatus>pathstatuses = new ArrayList<Pathstatus>();
       public List<Pathstatus> getPathstatuses() {
           return pathstatuses;
       }

        public void setPathstatuses(List<Pathstatus> pathstatuses) {
           this.pathstatuses = pathstatuses;
       }
 
       public void addPathstatus(Pathstatus pathstatus) {
           this.pathstatuses.add(pathstatus);
       }
 }
