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
public interface OrganizationDao extends ParentDao {

/*	com.servinglynk.hmis.warehouse.model.live.Organization getOrganizationByYd(UUID organizationId);*/
	
	
	   com.servinglynk.hmis.warehouse.model.live.Organization createOrganization(com.servinglynk.hmis.warehouse.model.live.Organization organization);
	   com.servinglynk.hmis.warehouse.model.live.Organization updateOrganization(com.servinglynk.hmis.warehouse.model.live.Organization organization);
	   void deleteOrganization(com.servinglynk.hmis.warehouse.model.live.Organization organization);
	   com.servinglynk.hmis.warehouse.model.live.Organization getOrganizationById(UUID organizationId);
	   List<com.servinglynk.hmis.warehouse.model.live.Organization> getAllOrganizations(Integer startIndex, Integer maxItems);
	   long getOrganizationCount();
}
