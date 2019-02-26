package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Funder;
import com.servinglynk.hmis.warehouse.core.model.Funders;
public interface FunderService {

   Funder createFunder(Funder funder,UUID projectId,String caller);
   Funder updateFunder(Funder funder,UUID projectId,String caller);
   Funder deleteFunder(UUID funderId,String caller);
   Funder getFunderById(UUID funderId);
   Funders getAllProjectFunders(UUID projectId,Integer startIndex, Integer maxItems);
}
