package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class Dateofengagements extends PaginatedModel {
     private List<Dateofengagement> dateofengagements = new ArrayList<Dateofengagement>();
 
     public List<Dateofengagement> getDateofengagements() {
         return dateofengagements;
     }
 
     public void setDateofengagements(List<Dateofengagement> dateofengagements) {
          this.dateofengagements = dateofengagements;
     }
 
     public void addDateofengagement(Dateofengagement dateofengagement){
         this.dateofengagements.add(dateofengagement);
     }
}
