package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("disabilitiesList")
public class DisabilitiesList extends PaginatedModel{


       @JsonProperty("disabilitiesList") 
       List<Disabilities>disabilitiesList = new ArrayList<Disabilities>();
       public List<Disabilities> getDisabilitiesList() {
           return disabilitiesList;
       }

        public void setDisabilitiesList(List<Disabilities> disabilitiesList) {
           this.disabilitiesList = disabilitiesList;
       }
 
       public void addDisabilities(Disabilities disabilities) {
           this.disabilitiesList.add(disabilities);
       }
 }
