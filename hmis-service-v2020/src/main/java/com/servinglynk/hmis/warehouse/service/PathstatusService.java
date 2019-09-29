package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.core.model.Pathstatuses;
import com.servinglynk.hmis.warehouse.core.model.Pathstatuses;
public interface PathstatusService {

   Pathstatus createPathstatus(Pathstatus pathstatus,UUID enrollmentId,String caller);
   Pathstatus updatePathstatus(Pathstatus pathstatus,UUID enrollmentId,String caller);
   Pathstatus deletePathstatus(UUID pathstatusId,String caller);
   Pathstatus getPathstatusById(UUID pathstatusId);
   Pathstatuses getAllEnrollmentPathstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
