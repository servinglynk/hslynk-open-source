/**
 * 
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;

/**
 * @author Sandeep
 *
 */
public class OrganizationDaoImpl extends BaseDaoImpl implements
		OrganizationDao {

	
	   public com.servinglynk.hmis.warehouse.model.base.Organization createOrganization(com.servinglynk.hmis.warehouse.model.base.Organization organization){
		   organization.setId(UUID.randomUUID());
	       insert(organization);
	       return organization;
	   }
	   public com.servinglynk.hmis.warehouse.model.base.Organization updateOrganization(com.servinglynk.hmis.warehouse.model.base.Organization organization){
	       update(organization);
	       return organization;
	   }
	   public void deleteOrganization(com.servinglynk.hmis.warehouse.model.base.Organization organization){
	       delete(organization);
	   }
	   public com.servinglynk.hmis.warehouse.model.base.Organization getOrganizationById(UUID organizationId){ 
	       return (com.servinglynk.hmis.warehouse.model.base.Organization) get(com.servinglynk.hmis.warehouse.model.base.Organization.class, organizationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.base.Organization> getAllOrganizations(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.Organization.class);
	       return (List<com.servinglynk.hmis.warehouse.model.base.Organization>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getOrganizationCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.Organization.class);
	       return countRows(criteria);
	   }

}
