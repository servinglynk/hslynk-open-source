package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface ExitDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.live.Exit createExit(com.servinglynk.hmis.warehouse.model.live.Exit exit);
	   com.servinglynk.hmis.warehouse.model.live.Exit updateExit(com.servinglynk.hmis.warehouse.model.live.Exit exit);
	   void deleteExit(com.servinglynk.hmis.warehouse.model.live.Exit exit);
	   com.servinglynk.hmis.warehouse.model.live.Exit getExitById(UUID exitId);
	   List<com.servinglynk.hmis.warehouse.model.live.Exit> getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentExitsCount(UUID enrollmentId);
}
