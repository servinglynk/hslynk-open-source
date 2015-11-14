package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface FunderDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.live.Funder createFunder(com.servinglynk.hmis.warehouse.model.live.Funder funder);
	   com.servinglynk.hmis.warehouse.model.live.Funder updateFunder(com.servinglynk.hmis.warehouse.model.live.Funder funder);
	   void deleteFunder(com.servinglynk.hmis.warehouse.model.live.Funder funder);
	   com.servinglynk.hmis.warehouse.model.live.Funder getFunderById(UUID funderId);
	   List<com.servinglynk.hmis.warehouse.model.live.Funder> getAllProjectFunders(UUID projectId,Integer startIndex, Integer maxItems);
	   long getProjectFundersCount(UUID projectId);
}
