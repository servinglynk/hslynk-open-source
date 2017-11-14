package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Exitrhy;
import com.servinglynk.hmis.warehouse.core.model.Exitrhys;
public interface ExitrhyService {

   Exitrhy createExitrhy(Exitrhy exitrhy,UUID exitId,String caller);
   Exitrhy updateExitrhy(Exitrhy exitrhy,UUID exitId,String caller);
   Exitrhy deleteExitrhy(UUID exitrhyId,String caller);
   Exitrhy getExitrhyById(UUID exitrhyId);
   Exitrhys getAllExitExitrhys(UUID exitId,Integer startIndex, Integer maxItems);
}
