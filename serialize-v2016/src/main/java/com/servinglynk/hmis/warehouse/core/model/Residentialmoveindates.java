package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("residentialmoveindates")
public class Residentialmoveindates extends PaginatedModel{


       @JsonProperty("residentialmoveindates") 
       List<Residentialmoveindate>residentialmoveindates = new ArrayList<Residentialmoveindate>();
       public List<Residentialmoveindate> getResidentialmoveindates() {
           return residentialmoveindates;
       }

        public void setResidentialmoveindates(List<Residentialmoveindate> residentialmoveindates) {
           this.residentialmoveindates = residentialmoveindates;
       }
 
       public void addResidentialmoveindate(Residentialmoveindate residentialmoveindate) {
           this.residentialmoveindates.add(residentialmoveindate);
       }
 }
