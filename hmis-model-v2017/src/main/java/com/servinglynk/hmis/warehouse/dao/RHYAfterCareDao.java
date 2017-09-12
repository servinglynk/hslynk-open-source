package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface RHYAfterCareDao extends ParentDao{
	


	   com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare createRHYAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare);
	   com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare updateRHYAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare);
	   void deleteRHYAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare);
	   com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare getRHYAfterCareById(UUID rhyAfterCareId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> getAllRHYAfterCare(String inPersonGroup, Integer startIndex, Integer maxItems);
	   long getRHYAfterCareCount(String inPersonGroup);
	   


}
