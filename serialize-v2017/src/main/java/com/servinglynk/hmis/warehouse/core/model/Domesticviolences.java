package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("domesticviolences")
public class Domesticviolences extends PaginatedModel{


       @JsonProperty("domesticviolences") 
       List<Domesticviolence>domesticviolences = new ArrayList<Domesticviolence>();
       public List<Domesticviolence> getDomesticviolences() {
           return domesticviolences;
       }

        public void setDomesticviolences(List<Domesticviolence> domesticviolences) {
           this.domesticviolences = domesticviolences;
       }
 
       public void addDomesticviolence(Domesticviolence domesticviolence) {
           this.domesticviolences.add(domesticviolence);
       }
 }
