package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatuses;
public interface RhybcpstatusService {

   Rhybcpstatus createRhybcpstatus(Rhybcpstatus rhybcpstatus,UUID enrollmentId,String caller);
   Rhybcpstatus updateRhybcpstatus(Rhybcpstatus rhybcpstatus,UUID enrollmentId,String caller);
   Rhybcpstatus deleteRhybcpstatus(UUID rhybcpstatusId,String caller);
   Rhybcpstatus getRhybcpstatusById(UUID rhybcpstatusId);
   Rhybcpstatuses getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
