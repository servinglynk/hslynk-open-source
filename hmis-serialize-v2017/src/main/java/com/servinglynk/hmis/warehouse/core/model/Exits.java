package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
@JsonRootName("exits")
public class Exits extends PaginatedModel {
	
	@JsonProperty("exits")
     private List<Exit> exits = new ArrayList<Exit>();
 
     public List<Exit> getExits() {
         return exits;
     }
 
     public void setExits(List<Exit> exits) {
          this.exits = exits;
     }
 
     public void addExit(Exit exit){
         this.exits.add(exit);
     }
}
