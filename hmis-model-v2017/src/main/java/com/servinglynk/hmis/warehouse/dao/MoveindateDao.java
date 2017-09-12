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
public interface MoveindateDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2017.Moveindate createMoveindate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveinDate);
	   com.servinglynk.hmis.warehouse.model.v2017.Moveindate updateMoveindate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveinDate);
	   void deleteMoveindate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveinDate);
	   com.servinglynk.hmis.warehouse.model.v2017.Moveindate getMoveindateById(UUID moveindateId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate> getAllEnrollmentMoveindates(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentMoveindatesCount(UUID enrollmentId);
}
