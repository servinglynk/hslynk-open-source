/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;

/**
 * @author Sandeep
 *
 */
public interface ExithousingassessmentDao extends ParentDao {

	 List<com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment> getAllExitExithousingassessments(UUID enrollmentId,Integer startIndex, Integer maxItems);

}
