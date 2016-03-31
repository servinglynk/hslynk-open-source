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
public interface HmisOrganizationDao extends BaseDao {

/*	com.servinglynk.hmis.warehouse.model.live.Organization getOrganizationByYd(UUID organizationId);*/
	
	
	   com.servinglynk.hmis.warehouse.model.base.OrganizationEntity createOrganization(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity organization);
	   com.servinglynk.hmis.warehouse.model.base.OrganizationEntity updateOrganization(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity organization);
	   void deleteOrganization(com.servinglynk.hmis.warehouse.model.base.OrganizationEntity organization);
	   com.servinglynk.hmis.warehouse.model.base.OrganizationEntity getOrganizationById(UUID organizationId);
	   List<com.servinglynk.hmis.warehouse.model.base.OrganizationEntity> getAllOrganizations(Integer startIndex, Integer maxItems);
	   long getOrganizationCount();
}
