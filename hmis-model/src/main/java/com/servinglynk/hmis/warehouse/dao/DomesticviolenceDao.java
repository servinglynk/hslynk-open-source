package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface DomesticviolenceDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.live.Domesticviolence createDomesticViolence(com.servinglynk.hmis.warehouse.model.live.Domesticviolence domesticViolence);
	   com.servinglynk.hmis.warehouse.model.live.Domesticviolence updateDomesticViolence(com.servinglynk.hmis.warehouse.model.live.Domesticviolence domesticViolence);
	   void deleteDomesticViolence(com.servinglynk.hmis.warehouse.model.live.Domesticviolence domesticViolence);
	   com.servinglynk.hmis.warehouse.model.live.Domesticviolence getDomesticViolenceById(UUID domesticViolenceId);
	   List<com.servinglynk.hmis.warehouse.model.live.Domesticviolence> getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentDomesticViolencesCount(UUID enrollmentId);
}
