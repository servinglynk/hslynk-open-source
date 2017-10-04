package com.servinglynk.hmis.warehouse.core.model;
 
import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;
 
public class HousingAssessmentDispositions extends PaginatedModel {
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
