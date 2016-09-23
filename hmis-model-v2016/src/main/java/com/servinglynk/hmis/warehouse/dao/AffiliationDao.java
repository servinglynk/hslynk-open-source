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

	
	   com.servinglynk.hmis.warehouse.model.v2016.Affiliation createAffiliation(com.servinglynk.hmis.warehouse.model.v2016.Affiliation affiliation);
	   com.servinglynk.hmis.warehouse.model.v2016.Affiliation updateAffiliation(com.servinglynk.hmis.warehouse.model.v2016.Affiliation affiliation);
	   void deleteAffiliation(com.servinglynk.hmis.warehouse.model.v2016.Affiliation affiliation);
	   com.servinglynk.hmis.warehouse.model.v2016.Affiliation getAffiliationById(UUID affiliationId);
	   List<com.servinglynk.hmis.warehouse.model.v2016.Affiliation> getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems);
	   long getProjectAffiliationsCount(UUID projectId);
}
