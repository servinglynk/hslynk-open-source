package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.FamilyReunification;
import com.servinglynk.hmis.warehouse.core.model.FamilyReunifications;
public interface FamilyReunificationService {

   FamilyReunification createFamilyReunification(FamilyReunification familyReunification,UUID exitId,String caller);
   FamilyReunification updateFamilyReunification(FamilyReunification familyReunification,UUID exitId,String caller);
   FamilyReunification deleteFamilyReunification(UUID familyReunificationId,String caller);
   FamilyReunification getFamilyReunificationById(UUID familyReunificationId);
   FamilyReunifications getAllEnrollmentFamilyReunifications(UUID exitId,Integer startIndex, Integer maxItems);
}
