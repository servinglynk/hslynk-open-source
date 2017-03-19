package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;
 
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class LastPermanentAddresses extends PaginatedModel {
     private List<LastPermanentAddress> lastPermanentAddresses = new ArrayList<LastPermanentAddress>();
 
     public List<LastPermanentAddress> getLastPermanentAddresses() {
         return lastPermanentAddresses;
     }
 
     public void setLastPermanentAddresses(List<LastPermanentAddress> lastPermanentAddresses) {
          this.lastPermanentAddresses = lastPermanentAddresses;
     }
 
     public void addLastPermanentAddress(LastPermanentAddress lastPermanentAddreses){
         this.lastPermanentAddresses.add(lastPermanentAddreses);
     }
}
