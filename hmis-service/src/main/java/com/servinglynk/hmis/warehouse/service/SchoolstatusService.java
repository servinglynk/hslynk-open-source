package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatuses;
public interface SchoolstatusService {

   Schoolstatus createSchoolstatus(Schoolstatus schoolstatus,UUID enrollmentId,String caller);
   Schoolstatus updateSchoolstatus(Schoolstatus schoolstatus,UUID enrollmentId,String caller);
   Schoolstatus deleteSchoolstatus(UUID schoolstatusId,String caller);
   Schoolstatus getSchoolstatusById(UUID schoolstatusId);
   Schoolstatuses getAllEnrollmentSchoolstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
