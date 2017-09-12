package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolences;
public interface DomesticviolenceService {

   Domesticviolence createDomesticviolence(Domesticviolence domesticviolence,UUID enrollmentId,String caller);
   Domesticviolence updateDomesticviolence(Domesticviolence domesticviolence,UUID enrollmentId,String caller);
   Domesticviolence deleteDomesticviolence(UUID domesticviolenceId,String caller);
   Domesticviolence getDomesticviolenceById(UUID domesticviolenceId);
   Domesticviolences getAllEnrollmentDomesticviolences(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
