package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface VASHExitReasonDao extends ParentDao{
	
	   com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason createVashExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason);
	   com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason updateVashExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason);
	   void deleteVashExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason);
	   com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason getVashExitReasonById(UUID vashExitReasonId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason> getAllVashExitReason(String exitId, Integer startIndex, Integer maxItems);
	   long getVashExitReasonCount(String exitId);
	   


}
