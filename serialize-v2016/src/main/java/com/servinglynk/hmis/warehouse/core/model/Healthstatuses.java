package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("healthstatuses")
public class Healthstatuses extends PaginatedModel{


       @JsonProperty("healthstatuses") 
       List<Healthstatus>healthstatuses = new ArrayList<Healthstatus>();
       public List<Healthstatus> getHealthstatuses() {
           return healthstatuses;
       }

        public void setHealthstatuses(List<Healthstatus> healthstatuses) {
           this.healthstatuses = healthstatuses;
       }
 
       public void addHealthstatus(Healthstatus healthstatus) {
           this.healthstatuses.add(healthstatus);
       }
 }
