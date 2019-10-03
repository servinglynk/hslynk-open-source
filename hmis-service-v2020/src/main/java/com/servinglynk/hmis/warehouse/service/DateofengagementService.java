package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagements;
public interface DateofengagementService {

   Dateofengagement createDateofengagement(Dateofengagement dateofengagement,UUID enrollmentId,String caller);
   Dateofengagement updateDateofengagement(Dateofengagement dateofengagement,UUID enrollmentId,String caller);
   Dateofengagement deleteDateofengagement(UUID dateofengagementId,String caller);
   Dateofengagement getDateofengagementById(UUID dateofengagementId);
   Dateofengagements getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
