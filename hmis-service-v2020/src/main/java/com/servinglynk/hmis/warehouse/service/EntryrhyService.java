package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Entryrhy;
import com.servinglynk.hmis.warehouse.core.model.Entryrhys;
public interface EntryrhyService {

   Entryrhy createEntryrhy(Entryrhy entryrhy,UUID enrollmentId,String caller);
   Entryrhy updateEntryrhy(Entryrhy entryrhy,UUID enrollmentId,String caller);
   Entryrhy deleteEntryrhy(UUID entryrhyId,String caller);
   Entryrhy getEntryrhyById(UUID entryrhyId);
   Entryrhys getAllEnrollmentEntryrhys(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
