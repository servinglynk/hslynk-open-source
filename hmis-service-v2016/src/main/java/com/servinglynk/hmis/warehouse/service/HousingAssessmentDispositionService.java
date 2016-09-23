package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDispositions;
public interface HousingAssessmentDispositionService {

   HousingAssessmentDisposition createHousingAssessmentDisposition(HousingAssessmentDisposition housingAssessmentDisposition,UUID exitId,String caller);
   HousingAssessmentDisposition updateHousingAssessmentDisposition(HousingAssessmentDisposition housingAssessmentDisposition,UUID exitId,String caller);
   HousingAssessmentDisposition deleteHousingAssessmentDisposition(UUID housingAssessmentDispositionId,String caller);
   HousingAssessmentDisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId);
   HousingAssessmentDispositions getAllEnrollmentHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems);
}
