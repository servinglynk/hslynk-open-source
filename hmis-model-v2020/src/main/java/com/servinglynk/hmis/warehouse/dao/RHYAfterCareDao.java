package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface RHYAfterCareDao extends ParentDao{
	


	   com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare createRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare rhyAfterCare);
	   com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare updateRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare rhyAfterCare);
	   void deleteRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare rhyAfterCare);
	   com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare getRhyAfterCareById(UUID rhyAfterCareId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare> getAllRHYAfterCare(String inPersonGroup, Integer startIndex, Integer maxItems);
	   long getRhyAfterCareCount(String inPersonGroup);
	   List<com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare> getAllExitRHYAfterCares(UUID exitrhyId,Integer startIndex, Integer maxItems);
	   long getExitRHYAfterCaresCount(UUID exitrhyId);
}
