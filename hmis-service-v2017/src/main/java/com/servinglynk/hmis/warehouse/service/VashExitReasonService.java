package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.VashExitReason;
import com.servinglynk.hmis.warehouse.core.model.VashExitReasons;

public interface VashExitReasonService {
	   VashExitReason createVashExitReason(VashExitReason vashExitReason,UUID exitId,String caller);
	   VashExitReason updateVashExitReason(VashExitReason vashExitReason,UUID exitId,String caller);
	   VashExitReason deleteVashExitReason(UUID vashExitReasonId,String caller);
	   VashExitReason getVashExitReasonById(UUID vashExitReasonId);
	   VashExitReasons getAllExitVashExitReasons(UUID exitId,Integer startIndex, Integer maxItems);
}
