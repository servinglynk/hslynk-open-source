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
public interface WorsthousingsituationDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation createWorsthousingsituation(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation worsthousingsituation);
	   com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation updateWorsthousingsituation(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation worsthousingsituation);
	   void deleteWorsthousingsituation(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation worsthousingsituation);
	   com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation getWorsthousingsituationById(UUID worsthousingsituationId);
	   List<com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation> getAllEnrollmentWorsthousingsituations(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentWorsthousingsituationsCount(UUID enrollmentId);
}
