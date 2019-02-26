package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.DisabilitiesList;
public interface DisabilitiesService {

   Disabilities createDisabilities(Disabilities disabilities,UUID enrollmentId,String caller);
   Disabilities updateDisabilities(Disabilities disabilities,UUID enrollmentId,String caller);
   Disabilities deleteDisabilities(UUID disabilitiesId,String caller);
   Disabilities getDisabilitiesById(UUID disabilitiesId);
   DisabilitiesList getAllEnrollmentDisabilitiess(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
