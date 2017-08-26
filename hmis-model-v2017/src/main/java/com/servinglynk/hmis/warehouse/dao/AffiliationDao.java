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

	
	   com.servinglynk.hmis.warehouse.model.v2017.Affiliation createAffiliation(com.servinglynk.hmis.warehouse.model.v2017.Affiliation affiliation);
	   com.servinglynk.hmis.warehouse.model.v2017.Affiliation updateAffiliation(com.servinglynk.hmis.warehouse.model.v2017.Affiliation affiliation);
	   void deleteAffiliation(com.servinglynk.hmis.warehouse.model.v2017.Affiliation affiliation);
	   com.servinglynk.hmis.warehouse.model.v2017.Affiliation getAffiliationById(UUID affiliationId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.Affiliation> getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems);
	   long getProjectAffiliationsCount(UUID projectId);
}
