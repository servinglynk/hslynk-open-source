package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;
 
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class Organizations extends PaginatedModel {
     private List<Organization> organizations = new ArrayList<Organization>();
 
     public List<Organization> getOrganizations() {
         return organizations;
     }
 
     public void setOrganizations(List<Organization> organizations) {
          this.organizations = organizations;
     }
 
     public void addOrganization(Organization organization){
         this.organizations.add(organization);
     }
}
