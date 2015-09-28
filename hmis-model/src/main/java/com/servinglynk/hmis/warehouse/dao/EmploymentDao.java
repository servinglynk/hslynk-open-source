package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface EmploymentDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.live.Employment createEmployment(com.servinglynk.hmis.warehouse.model.live.Employment employment);
	   com.servinglynk.hmis.warehouse.model.live.Employment updateEmployment(com.servinglynk.hmis.warehouse.model.live.Employment employment);
	   void deleteEmployment(com.servinglynk.hmis.warehouse.model.live.Employment employment);
	   com.servinglynk.hmis.warehouse.model.live.Employment getEmploymentById(UUID employmentId);
	   List<com.servinglynk.hmis.warehouse.model.live.Employment> getAllEnrollmentEmployments(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentEmploymentsCount(UUID enrollmentId);
}
