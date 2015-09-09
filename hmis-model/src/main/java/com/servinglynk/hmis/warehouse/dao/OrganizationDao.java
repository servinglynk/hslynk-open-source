/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface OrganizationDao extends ParentDao {

	com.servinglynk.hmis.warehouse.model.live.Organization getOrganizationByYd(UUID organizationId);
}
