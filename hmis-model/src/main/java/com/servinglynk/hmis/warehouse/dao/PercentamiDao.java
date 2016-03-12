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
public interface PercentamiDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Percentami createPercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami);
	   com.servinglynk.hmis.warehouse.model.v2014.Percentami updatePercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami);
	   void deletePercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami);
	   com.servinglynk.hmis.warehouse.model.v2014.Percentami getPercentamiById(UUID percentamiId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Percentami> getAllEnrollmentPercentamis(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentPercentamisCount(UUID enrollmentId);
}
