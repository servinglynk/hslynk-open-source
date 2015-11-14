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

	   com.servinglynk.hmis.warehouse.model.live.Percentami createPercentami(com.servinglynk.hmis.warehouse.model.live.Percentami percentami);
	   com.servinglynk.hmis.warehouse.model.live.Percentami updatePercentami(com.servinglynk.hmis.warehouse.model.live.Percentami percentami);
	   void deletePercentami(com.servinglynk.hmis.warehouse.model.live.Percentami percentami);
	   com.servinglynk.hmis.warehouse.model.live.Percentami getPercentamiById(UUID percentamiId);
	   List<com.servinglynk.hmis.warehouse.model.live.Percentami> getAllEnrollmentPercentamis(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentPercentamisCount(UUID enrollmentId);
}
