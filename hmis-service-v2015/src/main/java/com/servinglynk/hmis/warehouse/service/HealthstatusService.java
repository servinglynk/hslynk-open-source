package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Healthstatus;
import com.servinglynk.hmis.warehouse.core.model.Healthstatuses;
import com.servinglynk.hmis.warehouse.core.model.Healthstatuses;
public interface HealthstatusService {

   Healthstatus createHealthstatus(Healthstatus healthstatus,UUID enrollmentId,String caller);
   Healthstatus updateHealthstatus(Healthstatus healthstatus,UUID enrollmentId,String caller);
   Healthstatus deleteHealthstatus(UUID healthstatusId,String caller);
   Healthstatus getHealthstatusById(UUID healthstatusId);
   Healthstatuses getAllEnrollmentHealthstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
