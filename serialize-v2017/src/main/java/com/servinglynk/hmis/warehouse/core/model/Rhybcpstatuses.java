package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("rhybcpStatuses")
public class Rhybcpstatuses extends PaginatedModel{


       @JsonProperty("rhybcpstatuses") 
       List<Rhybcpstatus>rhybcpstatuses = new ArrayList<Rhybcpstatus>();
       public List<Rhybcpstatus> getRhybcpstatuses() {
           return rhybcpstatuses;
       }

        public void setRhybcpstatuses(List<Rhybcpstatus> rhybcpstatuses) {
           this.rhybcpstatuses = rhybcpstatuses;
       }
 
       public void addRhybcpstatus(Rhybcpstatus rhybcpstatus) {
           this.rhybcpstatuses.add(rhybcpstatus);
       }
 }
