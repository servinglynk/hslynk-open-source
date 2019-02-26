package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;
 
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class FormerWardChildWelfares extends PaginatedModel {
     private List<FormerWardChildWelfare> formerWardChildWelfares = new ArrayList<FormerWardChildWelfare>();
 
     public List<FormerWardChildWelfare> getFormerWardChildWelfares() {
         return formerWardChildWelfares;
     }
 
     public void setFormerWardChildWelfares(List<FormerWardChildWelfare> formerWardChildWelfares) {
          this.formerWardChildWelfares = formerWardChildWelfares;
     }
 
     public void addFormerWardChildWelfare(FormerWardChildWelfare formerWardChildWelfare){
         this.formerWardChildWelfares.add(formerWardChildWelfare);
     }
}
