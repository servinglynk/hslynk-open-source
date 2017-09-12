package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface VASHExitReasonDao extends ParentDao{
	


	   com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason createVASHExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason);
	   com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason updateVASHExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason);
	   void deleteVASHExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason);
	   com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason getVASHExitReasonById(UUID vashExitReasonId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason> getAllVASHExitReason(String exitId, Integer startIndex, Integer maxItems);
	   long getVASHExitReasonCount(String exitId);
	   


}
