package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Exitpath;
import com.servinglynk.hmis.warehouse.core.model.Exitpaths;
public interface ExitpathService {

   Exitpath createExitpath(Exitpath exitpath,UUID exitId,String caller);
   Exitpath updateExitpath(Exitpath exitpath,UUID exitId,String caller);
   Exitpath deleteExitpath(UUID exitpathId,String caller);
   Exitpath getExitpathById(UUID exitpathId);
   Exitpaths getAllExitExitpaths(UUID exitId,Integer startIndex, Integer maxItems);
}
