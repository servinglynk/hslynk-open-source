package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Referralsource;
import com.servinglynk.hmis.warehouse.core.model.Referralsources;
public interface ReferralsourceService {

   Referralsource createReferralsource(Referralsource referralsource,UUID enrollmentId,String caller);
   Referralsource updateReferralsource(Referralsource referralsource,UUID enrollmentId,String caller);
   Referralsource deleteReferralsource(UUID referralsourceId,String caller);
   Referralsource getReferralsourceById(UUID referralsourceId);
   Referralsources getAllEnrollmentReferralsources(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
