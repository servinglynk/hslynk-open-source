package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface FamilyreunificationDao extends ParentDao {
	  com.servinglynk.hmis.warehouse.model.v2014.Familyreunification createFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification);
	   com.servinglynk.hmis.warehouse.model.v2014.Familyreunification updateFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification);
	   void deleteFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification);
	   com.servinglynk.hmis.warehouse.model.v2014.Familyreunification getFamilyReunificationById(UUID familyReunificationId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Familyreunification> getAllExitFamilyReunifications(UUID exitId,Integer startIndex, Integer maxItems);
	   long getExitFamilyReunificationsCount(UUID exitId);
}
