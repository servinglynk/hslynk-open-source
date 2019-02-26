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

	
	   com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation createWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation);
	   com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation updateWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation);
	   void deleteWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation);
	   com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation getWorsthousingsituationById(UUID worsthousingsituationId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation> getAllEnrollmentWorsthousingsituations(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentWorsthousingsituationsCount(UUID enrollmentId);
}
