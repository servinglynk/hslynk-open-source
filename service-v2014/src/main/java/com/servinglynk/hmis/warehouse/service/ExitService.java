package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.Exits;
public interface ExitService {

   Exit createExit(Exit exit,UUID enrollmentId,String caller);
   Exit updateExit(Exit exit,UUID enrollmentId,String caller);
   Exit deleteExit(UUID exitId,String caller);
   Exit getExitById(UUID exitId);
   Exits getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
