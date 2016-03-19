package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface DomesticviolenceDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence createDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence);
	   com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence updateDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence);
	   void deleteDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence);
	   com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence getDomesticViolenceById(UUID domesticViolenceId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence> getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentDomesticViolencesCount(UUID enrollmentId);
}
