package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolences;
public interface DomesticViolenceService {

   DomesticViolence createDomesticViolence(DomesticViolence domesticViolence,UUID enrollmentId,String caller);
   DomesticViolence updateDomesticViolence(DomesticViolence domesticViolence,UUID enrollmentId,String caller);
   DomesticViolence deleteDomesticViolence(UUID domesticViolenceId,String caller);
   DomesticViolence getDomesticViolenceById(UUID domesticViolenceId);
   DomesticViolences getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
