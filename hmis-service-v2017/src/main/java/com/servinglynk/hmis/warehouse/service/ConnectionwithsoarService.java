package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoars;
public interface ConnectionwithsoarService {

   Connectionwithsoar createConnectionwithsoar(Connectionwithsoar connectionwithsoar,UUID exitId,String caller);
   Connectionwithsoar updateConnectionwithsoar(Connectionwithsoar connectionwithsoar,UUID exitId,String caller);
   Connectionwithsoar deleteConnectionwithsoar(UUID connectionwithsoarId,String caller);
   Connectionwithsoar getConnectionwithsoarById(UUID connectionwithsoarId);
   Connectionwithsoars getAllEnrollmentConnectionwithsoars(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
