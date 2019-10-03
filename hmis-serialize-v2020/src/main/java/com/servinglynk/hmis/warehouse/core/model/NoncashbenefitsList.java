package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("noncashbenefitsList")
public class NoncashbenefitsList extends PaginatedModel{


       @JsonProperty("noncashbenefitsList") 
       List<Noncashbenefits>noncashbenefitsList = new ArrayList<Noncashbenefits>();
       public List<Noncashbenefits> getNoncashbenefitsList() {
           return noncashbenefitsList;
       }

        public void setNoncashbenefitsList(List<Noncashbenefits> noncashbenefitsList) {
           this.noncashbenefitsList = noncashbenefitsList;
       }
 
       public void addNoncashbenefits(Noncashbenefits noncashbenefits) {
           this.noncashbenefitsList.add(noncashbenefits);
       }
 }
