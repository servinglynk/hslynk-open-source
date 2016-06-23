/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class OrganizationDaoImpl extends ParentDaoImpl implements
		OrganizationDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		 List<Organization> organizations = domain.getExport().getOrganization();
		 hydrateBulkUploadActivityStaging(organizations, com.servinglynk.hmis.warehouse.model.v2014.Organization.class.getSimpleName(), domain);
		 int i=0;
		 com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		 if(organizations != null && !organizations.isEmpty())
		 {
			 for(Organization organization : organizations)
			 {
				 com.servinglynk.hmis.warehouse.model.v2014.Organization organizationModel = new com.servinglynk.hmis.warehouse.model.v2014.Organization();
				 UUID id =UUID.randomUUID();
				 organizationModel.setId(id);
				 organizationModel.setOrganizationcommonname(organization.getOrganizationCommonName());
				 organizationModel.setOrganizationname(organization.getOrganizationName());
				  organizationModel.setDateCreated(LocalDateTime.now());
				  organizationModel.setDateUpdated(LocalDateTime.now());
				  domain.getOrganizationProjectMap().put(organization.getOrganizationID(),id);
				 organizationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateCreated()));
				 organizationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateUpdated()));
				 organizationModel.setExport(exportEntity);
				 //exportEntity.addOrganization(organizationModel);
				 i++;
				 hydrateCommonFields(organizationModel, domain,String.valueOf(organization.getOrganizationID()),i);
			 }
		 }
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Organization createOrganization(com.servinglynk.hmis.warehouse.model.v2014.Organization organization){
		   organization.setId(UUID.randomUUID());
	       insert(organization);
	       return organization;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Organization updateOrganization(com.servinglynk.hmis.warehouse.model.v2014.Organization organization){
	       update(organization);
	       return organization;
	   }
	   public void deleteOrganization(com.servinglynk.hmis.warehouse.model.v2014.Organization organization){
	       delete(organization);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Organization getOrganizationById(UUID organizationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Organization) get(com.servinglynk.hmis.warehouse.model.v2014.Organization.class, organizationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Organization> getAllOrganizations(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Organization.class);
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Organization>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getOrganizationCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Organization.class);
	       return countRows(criteria);
	   }

}
