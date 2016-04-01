/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment;

/**
 * @author Sandeep
 *
 */
public interface ExithousingassessmentDao extends ParentDao {
	
	Exithousingassessment createExithousingassessment(Exithousingassessment exithousingassessment);
	Exithousingassessment updateExithousingassessment(Exithousingassessment exithousingassessment);
	void deleteExithousingassessment(Exithousingassessment exithousingassessment);
	Exithousingassessment getExithousingassessmentById(UUID exithousingassessmentId);
	public Exithousingassessment getExithousingassessmentByDedupExithousingassessmentId(UUID id,String projectGroupCode);
	List<Exithousingassessment> getAllExithousingassessment(Integer startIndex, Integer maxItems);
	long getExithousingassessmentCount();
	void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Exithousingassessment exithousingassessment);
	
	   List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment> getAllExitExithousingassessments(UUID exitId,Integer startIndex, Integer maxItems);
	   long getExitExithousingassessmentsCount(UUID exitId);

}
