package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Healthinsurance;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurances;
public interface HealthinsuranceService {

   Healthinsurance createHealthinsurance(Healthinsurance healthinsurance,UUID enrollmentId,String caller);
   Healthinsurance updateHealthinsurance(Healthinsurance healthinsurance,UUID enrollmentId,String caller);
   Healthinsurance deleteHealthinsurance(UUID healthinsuranceId,String caller);
   Healthinsurance getHealthinsuranceById(UUID healthinsuranceId);
   Healthinsurances getAllEnrollmentHealthinsurances(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
