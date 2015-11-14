package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.HealthInsurance;
import com.servinglynk.hmis.warehouse.core.model.HealthInsurances;
public interface HealthInsuranceService {

   HealthInsurance createHealthInsurance(HealthInsurance healthInsurance,UUID enrollmentId,String caller);
   HealthInsurance updateHealthInsurance(HealthInsurance healthInsurance,UUID enrollmentId,String caller);
   HealthInsurance deleteHealthInsurance(UUID healthInsuranceId,String caller);
   HealthInsurance getHealthInsuranceById(UUID healthInsuranceId);
   HealthInsurances getAllEnrollmentHealthInsurances(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
