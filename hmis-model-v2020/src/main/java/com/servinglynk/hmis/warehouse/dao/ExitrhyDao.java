package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2020.Exitrhy;

public interface ExitrhyDao extends ParentDao {

	
	Exitrhy createExitrhy(Exitrhy exitrhy);
	Exitrhy updateExitrhy(Exitrhy exitrhy);
	void deleteExitrhy(Exitrhy exitrhy);
	Exitrhy getExitrhyById(UUID exitrhyId);
	public Exitrhy getExitrhyByDedupExitrhyId(UUID id,String projectGroupCode);
	List<Exitrhy> getAllExitrhy(Integer startIndex, Integer maxItems);
	long getExitrhyCount();
	void hydrateLive(com.servinglynk.hmis.warehouse.model.v2020.Exitrhy exitrhy);
	
	List<com.servinglynk.hmis.warehouse.model.v2020.Exitrhy> getAllExitExitrhys(UUID enrollmentId,Integer startIndex, Integer maxItems);
	long getExitExitrhysCount(UUID enrollmentId);
}
