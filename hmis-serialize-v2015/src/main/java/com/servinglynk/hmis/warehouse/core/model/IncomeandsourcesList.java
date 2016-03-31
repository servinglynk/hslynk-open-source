package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("incomeandsourcesList")
public class IncomeandsourcesList extends PaginatedModel{


       @JsonProperty("incomeandsourcesList") 
       List<Incomeandsources>incomeandsourcesList = new ArrayList<Incomeandsources>();
       public List<Incomeandsources> getIncomeandsourcesList() {
           return incomeandsourcesList;
       }

        public void setIncomeandsourcesList(List<Incomeandsources> incomeandsourcesList) {
           this.incomeandsourcesList = incomeandsourcesList;
       }
 
       public void addIncomeandsources(Incomeandsources incomeandsources) {
           this.incomeandsourcesList.add(incomeandsources);
       }
 }
