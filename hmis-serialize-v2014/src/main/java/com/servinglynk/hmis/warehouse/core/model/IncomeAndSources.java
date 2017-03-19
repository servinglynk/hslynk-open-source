package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class IncomeAndSources extends PaginatedModel {
     private List<IncomeAndSource> incomeAndSources = new ArrayList<IncomeAndSource>();
 
     public List<IncomeAndSource> getIncomeAndSources() {
         return incomeAndSources;
     }
 
     public void setIncomeAndSources(List<IncomeAndSource> incomeAndSources) {
          this.incomeAndSources = incomeAndSources;
     }
 
     public void addIncomeAndSource(IncomeAndSource incomeAndSource){
         this.incomeAndSources.add(incomeAndSource);
     }
}
