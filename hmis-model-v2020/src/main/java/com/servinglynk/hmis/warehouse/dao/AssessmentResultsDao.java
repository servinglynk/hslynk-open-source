/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

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
}
