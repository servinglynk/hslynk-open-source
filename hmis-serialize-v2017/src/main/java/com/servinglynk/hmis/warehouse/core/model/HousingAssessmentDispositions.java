package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
 
@JsonRootName("housingAssessmentDispositions")
public class HousingAssessmentDispositions extends PaginatedModel {
	@JsonProperty("housingAssessmentDispositions")
     private List<HousingAssessmentDisposition> housingAssessmentDispositions = new ArrayList<HousingAssessmentDisposition>();
 
     public List<HousingAssessmentDisposition> getHousingAssessmentDispositions() {
         return housingAssessmentDispositions;
     }
 
     public void setHousingAssessmentDispositions(List<HousingAssessmentDisposition> housingAssessmentDispositions) {
          this.housingAssessmentDispositions = housingAssessmentDispositions;
     }
 
     public void addHousingAssessmentDisposition(HousingAssessmentDisposition housingAssessmentDisposition){
         this.housingAssessmentDispositions.add(housingAssessmentDisposition);
     }
}
