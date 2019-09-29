/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

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
}
