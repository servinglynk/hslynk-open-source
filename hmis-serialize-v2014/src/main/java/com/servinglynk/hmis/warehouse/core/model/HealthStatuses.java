package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("healthStatuses")
public class HealthStatuses extends PaginatedModel {
	
	@JsonProperty("healthStatuses")
     private List<HealthStatus> healthStatuses = new ArrayList<HealthStatus>();
 
     public List<HealthStatus> getHealthStatuses() {
         return healthStatuses;
     }
 
     public void setHealthStatuses(List<HealthStatus> healthStatuses) {
          this.healthStatuses = healthStatuses;
     }
 
     public void addHealthStatus(HealthStatus healthStatus){
         this.healthStatuses.add(healthStatus);
     }
}
