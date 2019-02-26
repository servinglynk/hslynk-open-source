package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Noncashbenefits;
import com.servinglynk.hmis.warehouse.core.model.NoncashbenefitsList;
public interface NoncashbenefitsService {

   Noncashbenefits createNoncashbenefits(Noncashbenefits noncashbenefits,UUID enrollmentId,String caller);
   Noncashbenefits updateNoncashbenefits(Noncashbenefits noncashbenefits,UUID enrollmentId,String caller);
   Noncashbenefits deleteNoncashbenefits(UUID noncashbenefitsId,String caller);
   Noncashbenefits getNoncashbenefitsById(UUID noncashbenefitsId);
   NoncashbenefitsList getAllEnrollmentNoncashbenefitss(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
