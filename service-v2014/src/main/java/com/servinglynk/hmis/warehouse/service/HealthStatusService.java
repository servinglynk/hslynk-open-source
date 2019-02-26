package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.core.model.HealthStatuses;
public interface HealthStatusService {

   HealthStatus createHealthStatus(HealthStatus HealthStatus,UUID enrollmentId,String caller);
   HealthStatus updateHealthStatus(HealthStatus HealthStatus,UUID enrollmentId,String caller);
   HealthStatus deleteHealthStatus(UUID HealthStatusId,String caller);
   HealthStatus getHealthStatusById(UUID HealthStatusId);
   HealthStatuses getAllEnrollmentHealthStatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
