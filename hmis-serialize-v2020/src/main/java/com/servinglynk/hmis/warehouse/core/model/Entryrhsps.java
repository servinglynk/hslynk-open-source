package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("entryRhsps")
public class Entryrhsps extends PaginatedModel{


       @JsonProperty("entryRhsps") 
       List<Entryrhsp>entryrhsps = new ArrayList<Entryrhsp>();
       public List<Entryrhsp> getEntryrhsps() {
           return entryrhsps;
       }

        public void setEntryrhsps(List<Entryrhsp> entryrhsps) {
           this.entryrhsps = entryrhsps;
       }
 
       public void addEntryrhsp(Entryrhsp entryrhsp) {
           this.entryrhsps.add(entryrhsp);
       }
 }
