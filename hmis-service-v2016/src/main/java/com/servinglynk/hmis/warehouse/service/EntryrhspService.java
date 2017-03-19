package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Entryrhsp;
import com.servinglynk.hmis.warehouse.core.model.Entryrhsps;
public interface EntryrhspService {

   Entryrhsp createEntryrhsp(Entryrhsp entryrhsp,UUID enrollmentId,String caller);
   Entryrhsp updateEntryrhsp(Entryrhsp entryrhsp,UUID enrollmentId,String caller);
   Entryrhsp deleteEntryrhsp(UUID entryrhspId,String caller);
   Entryrhsp getEntryrhspById(UUID entryrhspId);
   Entryrhsps getAllEnrollmentEntryrhsps(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
