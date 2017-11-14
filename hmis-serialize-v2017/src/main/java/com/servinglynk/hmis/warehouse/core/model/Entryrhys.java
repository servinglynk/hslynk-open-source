package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("entryrhys")
public class Entryrhys extends PaginatedModel{


       @JsonProperty("entryrhys") 
       List<Entryrhy>entryrhys = new ArrayList<Entryrhy>();
       public List<Entryrhy> getEntryrhys() {
           return entryrhys;
       }

        public void setEntryrhys(List<Entryrhy> entryrhys) {
           this.entryrhys = entryrhys;
       }
 
       public void addEntryrhy(Entryrhy entryrhy) {
           this.entryrhys.add(entryrhy);
       }
 }
