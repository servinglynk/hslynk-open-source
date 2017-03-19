package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface ExitDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Exit createExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit);
	   com.servinglynk.hmis.warehouse.model.v2014.Exit updateExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit);
	   void deleteExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit);
	   com.servinglynk.hmis.warehouse.model.v2014.Exit getExitById(UUID exitId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Exit> getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentExitsCount(UUID enrollmentId);
}
