package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("erviceFaReferrals")
public class Servicefareferrals extends PaginatedModel{


       @JsonProperty("erviceFaReferrals") 
       List<Servicefareferral>servicefareferrals = new ArrayList<Servicefareferral>();
       public List<Servicefareferral> getServicefareferrals() {
           return servicefareferrals;
       }

        public void setServicefareferrals(List<Servicefareferral> servicefareferrals) {
           this.servicefareferrals = servicefareferrals;
       }
 
       public void addServicefareferral(Servicefareferral servicefareferral) {
           this.servicefareferrals.add(servicefareferral);
       }
 }
