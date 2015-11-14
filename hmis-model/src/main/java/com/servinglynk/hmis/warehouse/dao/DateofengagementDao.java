package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface DateofengagementDao extends ParentDao {
	
	   com.servinglynk.hmis.warehouse.model.live.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.live.Dateofengagement dateofengagement);
	   com.servinglynk.hmis.warehouse.model.live.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.live.Dateofengagement dateofengagement);
	   void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.live.Dateofengagement dateofengagement);
	   com.servinglynk.hmis.warehouse.model.live.Dateofengagement getDateofengagementById(UUID dateofengagementId);
	   List<com.servinglynk.hmis.warehouse.model.live.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentDateofengagementsCount(UUID enrollmentId);
}
