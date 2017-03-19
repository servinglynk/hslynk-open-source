package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface EmploymentDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Employment createEmployment(com.servinglynk.hmis.warehouse.model.v2014.Employment employment);
	   com.servinglynk.hmis.warehouse.model.v2014.Employment updateEmployment(com.servinglynk.hmis.warehouse.model.v2014.Employment employment);
	   void deleteEmployment(com.servinglynk.hmis.warehouse.model.v2014.Employment employment);
	   com.servinglynk.hmis.warehouse.model.v2014.Employment getEmploymentById(UUID employmentId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Employment> getAllEnrollmentEmployments(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentEmploymentsCount(UUID enrollmentId);
}
