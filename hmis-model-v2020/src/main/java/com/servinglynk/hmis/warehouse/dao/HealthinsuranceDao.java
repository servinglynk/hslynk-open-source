package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface HealthinsuranceDao extends ParentDao {


	  com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance createHealthInsurance(com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance healthInsurance);
	   com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance updateHealthInsurance(com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance healthInsurance);
	   void deleteHealthInsurance(com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance healthInsurance);
	   com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance getHealthInsuranceById(UUID healthInsuranceId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance> getAllEnrollmentHealthInsurances(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentHealthInsurancesCount(UUID enrollmentId);
}
