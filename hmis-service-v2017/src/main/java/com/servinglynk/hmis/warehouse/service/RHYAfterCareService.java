package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.RhyAfterCare;
import com.servinglynk.hmis.warehouse.core.model.RhyAfterCares;

public interface RHYAfterCareService {
	   RhyAfterCare createRhyAfterCare(RhyAfterCare rhyAfterCare,UUID exitRhyId,String caller);
	   public RhyAfterCare updateRhyAfterCare(RhyAfterCare rhyAfterCare, UUID exitRhyId, String caller);
	   RhyAfterCare deleteRhyAfterCare(UUID rhyAfterCareId,String caller);
	   RhyAfterCare getRhyAfterCareById(UUID rhyAfterCareId);
	   RhyAfterCares getAllExitrhyRhyAfterCares(UUID exitId,Integer startIndex, Integer maxItems);
}
