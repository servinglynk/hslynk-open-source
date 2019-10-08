package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.CurrentLivingSituation;
import com.servinglynk.hmis.warehouse.core.model.CurrentLivingSituations;

public interface CurrentLivingSituationService {
	
	   CurrentLivingSituation createCurrentLivingSituation(CurrentLivingSituation CurrentLivingSituation,UUID enrollmentId,String caller);
	   CurrentLivingSituation updateCurrentLivingSituation(CurrentLivingSituation CurrentLivingSituation,UUID enrollmentId,String caller);
	   CurrentLivingSituation deleteCurrentLivingSituation(UUID CurrentLivingSituationId,String caller);
	   CurrentLivingSituation getCurrentLivingSituationById(UUID CurrentLivingSituationId);
	   CurrentLivingSituations getAllEnrollmentCurrentLivingSituations(UUID enrollmentId,Integer startIndex, Integer maxItems);

}
