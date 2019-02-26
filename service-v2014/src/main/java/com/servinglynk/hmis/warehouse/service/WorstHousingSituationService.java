package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituations;
public interface WorstHousingSituationService {

   WorstHousingSituation createWorstHousingSituation(WorstHousingSituation worstHousingSituation,UUID enrollmentId,String caller);
   WorstHousingSituation updateWorstHousingSituation(WorstHousingSituation worstHousingSituation,UUID enrollmentId,String caller);
   WorstHousingSituation deleteWorstHousingSituation(UUID worstHousingSituationId,String caller);
   WorstHousingSituation getWorstHousingSituationById(UUID worstHousingSituationId);
   WorstHousingSituations getAllEnrollmentWorstHousingSituations(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
