/**
 * 
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface OrganizationDao extends BaseDao {

/*	com.servinglynk.hmis.warehouse.model.live.Organization getOrganizationByYd(UUID organizationId);*/
	
	
	   com.servinglynk.hmis.warehouse.model.base.Organization createOrganization(com.servinglynk.hmis.warehouse.model.base.Organization organization);
	   com.servinglynk.hmis.warehouse.model.base.Organization updateOrganization(com.servinglynk.hmis.warehouse.model.base.Organization organization);
	   void deleteOrganization(com.servinglynk.hmis.warehouse.model.base.Organization organization);
	   com.servinglynk.hmis.warehouse.model.base.Organization getOrganizationById(UUID organizationId);
	   List<com.servinglynk.hmis.warehouse.model.base.Organization> getAllOrganizations(Integer startIndex, Integer maxItems);
	   long getOrganizationCount();
}
