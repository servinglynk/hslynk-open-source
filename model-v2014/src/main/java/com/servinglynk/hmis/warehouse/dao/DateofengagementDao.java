package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface DateofengagementDao extends ParentDao {
	
	   com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement);
	   com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement);
	   void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement);
	   com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement getDateofengagementById(UUID dateofengagementId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentDateofengagementsCount(UUID enrollmentId);
}
