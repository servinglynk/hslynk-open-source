package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Entryssvf;
import com.servinglynk.hmis.warehouse.core.model.Entryssvfs;
public interface EntryssvfService {

   Entryssvf createEntryssvf(Entryssvf entryssvf,UUID enrollmentId,String caller);
   Entryssvf updateEntryssvf(Entryssvf entryssvf,UUID enrollmentId,String caller);
   Entryssvf deleteEntryssvf(UUID entryssvfId,String caller);
   Entryssvf getEntryssvfById(UUID entryssvfId);
   Entryssvfs getAllEnrollmentEntryssvfs(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
