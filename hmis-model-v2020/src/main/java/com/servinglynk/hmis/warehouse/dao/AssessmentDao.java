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
public interface AssessmentDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2020.Assessment createAssessment(com.servinglynk.hmis.warehouse.model.v2020.Assessment Assessment);
	   com.servinglynk.hmis.warehouse.model.v2020.Assessment updateAssessment(com.servinglynk.hmis.warehouse.model.v2020.Assessment Assessment);
	   void deleteAssessment(com.servinglynk.hmis.warehouse.model.v2020.Assessment Assessment);
	   com.servinglynk.hmis.warehouse.model.v2020.Assessment getAssessmentById(UUID AssessmentId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.Assessment> getAllEnrollmentAssessments(UUID enrollmentId,int startIndex,int maxItems);
	   long getEnrollmentAssessmentsCount(UUID enrollmentId);
}
