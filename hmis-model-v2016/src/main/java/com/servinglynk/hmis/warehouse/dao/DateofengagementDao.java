package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface DateofengagementDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2016.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.v2016.Dateofengagement dateofengagement);
	   com.servinglynk.hmis.warehouse.model.v2016.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.v2016.Dateofengagement dateofengagement);
	   void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.v2016.Dateofengagement dateofengagement);
	   com.servinglynk.hmis.warehouse.model.v2016.Dateofengagement getDateofengagementById(UUID dateofengagementId);
	   List<com.servinglynk.hmis.warehouse.model.v2016.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentDateofengagementsCount(UUID enrollmentId);
}
