package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface CurrentLivingSituationDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation createCurrentLivingSituation(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation CurrentLivingSituation);
	   com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation updateCurrentLivingSituation(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation CurrentLivingSituation);
	   void deleteCurrentLivingSituation(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation CurrentLivingSituation);
	   com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation getCurrentLivingSituationById(UUID CurrentLivingSituationId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation> getAllEnrollmentCurrentLivingSituations(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentCurrentLivingSituationsCount(UUID enrollmentId);
}
