package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("healthinsurances")
public class Healthinsurances extends PaginatedModel{


       @JsonProperty("healthinsurances") 
       List<Healthinsurance>healthinsurances = new ArrayList<Healthinsurance>();
       public List<Healthinsurance> getHealthinsurances() {
           return healthinsurances;
       }

        public void setHealthinsurances(List<Healthinsurance> healthinsurances) {
           this.healthinsurances = healthinsurances;
       }
 
       public void addHealthinsurance(Healthinsurance healthinsurance) {
           this.healthinsurances.add(healthinsurance);
       }
 }
