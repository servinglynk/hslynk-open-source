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
public interface AffiliationDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.live.Affiliation createAffiliation(com.servinglynk.hmis.warehouse.model.live.Affiliation affiliation);
	   com.servinglynk.hmis.warehouse.model.live.Affiliation updateAffiliation(com.servinglynk.hmis.warehouse.model.live.Affiliation affiliation);
	   void deleteAffiliation(com.servinglynk.hmis.warehouse.model.live.Affiliation affiliation);
	   com.servinglynk.hmis.warehouse.model.live.Affiliation getAffiliationById(UUID affiliationId);
	   List<com.servinglynk.hmis.warehouse.model.live.Affiliation> getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems);
	   long getProjectAffiliationsCount(UUID projectId);
}
