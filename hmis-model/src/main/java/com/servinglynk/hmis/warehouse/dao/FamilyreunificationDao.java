package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface FamilyreunificationDao extends ParentDao {
	  com.servinglynk.hmis.warehouse.model.live.Familyreunification createFamilyReunification(com.servinglynk.hmis.warehouse.model.live.Familyreunification familyReunification);
	   com.servinglynk.hmis.warehouse.model.live.Familyreunification updateFamilyReunification(com.servinglynk.hmis.warehouse.model.live.Familyreunification familyReunification);
	   void deleteFamilyReunification(com.servinglynk.hmis.warehouse.model.live.Familyreunification familyReunification);
	   com.servinglynk.hmis.warehouse.model.live.Familyreunification getFamilyReunificationById(UUID familyReunificationId);
	   List<com.servinglynk.hmis.warehouse.model.live.Familyreunification> getAllExitFamilyReunifications(UUID exitId,Integer startIndex, Integer maxItems);
	   long getExitFamilyReunificationsCount(UUID exitId);
}
