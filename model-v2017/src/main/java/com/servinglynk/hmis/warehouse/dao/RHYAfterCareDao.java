package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface RHYAfterCareDao extends ParentDao{
	


	   com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare createRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare);
	   com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare updateRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare);
	   void deleteRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare);
	   com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare getRhyAfterCareById(UUID rhyAfterCareId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> getAllRHYAfterCare(String inPersonGroup, Integer startIndex, Integer maxItems);
	   long getRhyAfterCareCount(String inPersonGroup);
	   List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> getAllExitRHYAfterCares(UUID exitrhyId,Integer startIndex, Integer maxItems);
	   long getExitRHYAfterCaresCount(UUID exitrhyId);
}
