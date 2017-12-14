package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCocs;
public interface EnrollmentCocService {

   EnrollmentCoc createEnrollmentCoc(EnrollmentCoc enrollmentCoc,UUID enrollmentId,String caller);
   EnrollmentCoc updateEnrollmentCoc(EnrollmentCoc enrollmentCoc,UUID enrollmentId,String caller);
   EnrollmentCoc deleteEnrollmentCoc(UUID enrollmentCocId,String caller);
   EnrollmentCoc getEnrollmentCocById(UUID enrollmentCocId);
   EnrollmentCocs getAllEnrollmentEnrollmentCocs(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
