package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
@JsonRootName("incomeAndSources")
public class IncomeAndSources extends PaginatedModel {
	@JsonProperty("incomeAndSources")
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
