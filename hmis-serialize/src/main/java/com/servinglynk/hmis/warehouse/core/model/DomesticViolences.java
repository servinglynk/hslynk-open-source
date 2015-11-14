package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class DomesticViolences extends PaginatedModel {
     private List<DomesticViolence> domesticViolences = new ArrayList<DomesticViolence>();
 
     public List<DomesticViolence> getDomesticViolences() {
         return domesticViolences;
     }
 
     public void setDomesticViolences(List<DomesticViolence> domesticViolences) {
          this.domesticViolences = domesticViolences;
     }
 
     public void addDomesticViolence(DomesticViolence domesticViolence){
         this.domesticViolences.add(domesticViolence);
     }
}
