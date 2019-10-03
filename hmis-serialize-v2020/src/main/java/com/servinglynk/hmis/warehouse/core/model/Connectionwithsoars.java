package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class Connectionwithsoars extends PaginatedModel {
     private List<Connectionwithsoar> connectionwithsoars = new ArrayList<Connectionwithsoar>();
 
     public List<Connectionwithsoar> getConnectionwithsoars() {
         return connectionwithsoars;
     }
 
     public void setConnectionwithsoars(List<Connectionwithsoar> connectionwithsoars) {
          this.connectionwithsoars = connectionwithsoars;
     }
 
     public void addConnectionwithsoar(Connectionwithsoar connectionwithsoar){
         this.connectionwithsoars.add(connectionwithsoar);
     }
}
