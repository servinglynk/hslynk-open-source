package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface HealthinsuranceDao extends ParentDao {

	
	  com.servinglynk.hmis.warehouse.model.live.Healthinsurance createHealthInsurance(com.servinglynk.hmis.warehouse.model.live.Healthinsurance healthInsurance);
	   com.servinglynk.hmis.warehouse.model.live.Healthinsurance updateHealthInsurance(com.servinglynk.hmis.warehouse.model.live.Healthinsurance healthInsurance);
	   void deleteHealthInsurance(com.servinglynk.hmis.warehouse.model.live.Healthinsurance healthInsurance);
	   com.servinglynk.hmis.warehouse.model.live.Healthinsurance getHealthInsuranceById(UUID healthInsuranceId);
	   List<com.servinglynk.hmis.warehouse.model.live.Healthinsurance> getAllEnrollmentHealthInsurances(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentHealthInsurancesCount(UUID enrollmentId);
}
