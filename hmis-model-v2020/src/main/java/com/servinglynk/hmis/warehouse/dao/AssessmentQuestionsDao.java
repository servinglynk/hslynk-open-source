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
public interface AssessmentQuestionsDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions createAssessmentQuestions(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions AssessmentQuestions);
	   com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions updateAssessmentQuestions(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions AssessmentQuestions);
	   void deleteAssessmentQuestions(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions AssessmentQuestions);
	   com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions getAssessmentQuestionsById(UUID AssessmentQuestionsId);
	   public List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions> getAllEnrollmentAssessmentQuestions(
				UUID enrollmentId, int startIndex, int maxItems);
	   public long getEnrollmentAssessmentQuestionsCount(UUID enrollmentId);
}
