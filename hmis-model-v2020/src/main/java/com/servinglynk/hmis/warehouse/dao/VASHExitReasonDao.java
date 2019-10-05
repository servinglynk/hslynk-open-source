package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface VASHExitReasonDao extends ParentDao{
	
	   com.servinglynk.hmis.warehouse.model.v2020.VashExitReason createVashExitReason(com.servinglynk.hmis.warehouse.model.v2020.VashExitReason vashExitReason);
	   com.servinglynk.hmis.warehouse.model.v2020.VashExitReason updateVashExitReason(com.servinglynk.hmis.warehouse.model.v2020.VashExitReason vashExitReason);
	   void deleteVashExitReason(com.servinglynk.hmis.warehouse.model.v2020.VashExitReason vashExitReason);
	   com.servinglynk.hmis.warehouse.model.v2020.VashExitReason getVashExitReasonById(UUID vashExitReasonId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.VashExitReason> getAllVashExitReason(String exitId, Integer startIndex, Integer maxItems);
	   long getVashExitReasonCount(String exitId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.VashExitReason> getAllExitVashExitReasons(UUID exitId,Integer startIndex, Integer maxItems);
		long getExitVashExitReasonsCount(UUID exitId);


}
