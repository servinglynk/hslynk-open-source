/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2017.Moveindate;
/**
 * @author Sandeep
 *
 */
public interface MoveindateDao extends ParentDao {

	   Moveindate createMoveIdDate(Moveindate moveinDate);
	   Moveindate updateMoveIdDate(Moveindate moveinDate);
	   void deletemoveInDate(Moveindate moveinDate);
	   Moveindate getMoveInDateById(UUID moveindateId);
	   List<Moveindate> getAllMoveInDate(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getMoveInDateCount(UUID enrollmentId);
}
