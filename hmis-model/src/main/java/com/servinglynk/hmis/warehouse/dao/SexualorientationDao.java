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
public interface SexualorientationDao extends ParentDao {

	 	com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation createSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation);
	   com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation updateSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation);
	   void deleteSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation);
	   com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation getSexualorientationById(UUID sexualorientationId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation> getAllEnrollmentSexualorientations(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentSexualorientationsCount(UUID enrollmentId);
}
