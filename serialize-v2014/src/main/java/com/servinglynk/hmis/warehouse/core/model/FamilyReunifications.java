package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class FamilyReunifications extends PaginatedModel {
     private List<FamilyReunification> familyReunifications = new ArrayList<FamilyReunification>();
 
     public List<FamilyReunification> getFamilyReunifications() {
         return familyReunifications;
     }
 
     public void setFamilyReunifications(List<FamilyReunification> familyReunifications) {
          this.familyReunifications = familyReunifications;
     }
 
     public void addFamilyReunification(FamilyReunification familyReunification){
         this.familyReunifications.add(familyReunification);
     }
}
