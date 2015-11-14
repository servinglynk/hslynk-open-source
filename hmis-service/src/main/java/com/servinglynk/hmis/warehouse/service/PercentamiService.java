package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Percentami;
import com.servinglynk.hmis.warehouse.core.model.Percentamis;
public interface PercentamiService {

   Percentami createPercentami(Percentami percentami,UUID enrollmentId,String caller);
   Percentami updatePercentami(Percentami percentami,UUID enrollmentId,String caller);
   Percentami deletePercentami(UUID percentamiId,String caller);
   Percentami getPercentamiById(UUID percentamiId);
   Percentamis getAllEnrollmentPercentamis(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
