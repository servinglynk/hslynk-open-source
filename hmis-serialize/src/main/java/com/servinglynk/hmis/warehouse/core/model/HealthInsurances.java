package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class HealthInsurances extends PaginatedModel {
     private List<HealthInsurance> healthInsurances = new ArrayList<HealthInsurance>();
 
     public List<HealthInsurance> getHealthInsurances() {
         return healthInsurances;
     }
 
     public void setHealthInsurances(List<HealthInsurance> healthInsurances) {
          this.healthInsurances = healthInsurances;
     }
 
     public void addHealthInsurance(HealthInsurance healthInsurance){
         this.healthInsurances.add(healthInsurance);
     }
}
