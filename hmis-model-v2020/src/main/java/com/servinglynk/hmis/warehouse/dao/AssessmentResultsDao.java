/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface AssessmentResultsDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults createAssessmentResults(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults assessmentResults);
	   com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults updateAssessmentResults(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults assessmentResults);
	   void deleteAssessmentResults(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults assessmentResults);
	   com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults getAssessmentResultsById(UUID assessmentResultsId);
	   public List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults> getAllEnrollmentAssessmentResults(
				UUID enrollmentId, Integer startIndex, Integer maxItems);
	   public long getEnrollmentAssessmentResultsCount(UUID enrollmentId);
}
