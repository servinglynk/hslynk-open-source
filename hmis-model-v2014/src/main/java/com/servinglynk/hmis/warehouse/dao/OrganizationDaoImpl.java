/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class OrganizationDaoImpl extends ParentDaoImpl implements
		OrganizationDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(OrganizationDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		 List<Organization> organizations = domain.getExport().getOrganization();
		 Long i=new Long(0L);
		 Data data =new Data();
		 com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		 if(organizations != null && !organizations.isEmpty())
		 {
			 for(Organization organization : organizations)
			 {
				 try {
					 com.servinglynk.hmis.warehouse.model.v2014.Organization organizationModel = getModelObject(domain, organization,data);
					 organizationModel.setOrganizationcommonname(organization.getOrganizationCommonName());
					 organizationModel.setOrganizationname(organization.getOrganizationName());
					 organizationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateCreated()));
					 organizationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateUpdated()));
					 organizationModel.setExport(exportEntity);
					 if(exportEntity !=null)
						 exportEntity.addOrganization(organizationModel);
					 performSaveOrUpdate(organizationModel);
				 }catch(Exception e) {
					 logger.error("Failure in Organization:::"+organization.toString()+ " with exception"+e.getLocalizedMessage());
					 throw new Exception(e);
				 }
			 }
		 }
		 hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Organization.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Organization getModelObject(ExportDomain domain,Organization organization ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Organization organizationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			organizationModel = (com.servinglynk.hmis.warehouse.model.v2014.Organization) getModel(com.servinglynk.hmis.warehouse.model.v2014.Organization.class, organization.getOrganizationID(), getProjectGroupCode(domain),false);
		
		if(organizationModel == null) {
			organizationModel = new com.servinglynk.hmis.warehouse.model.v2014.Organization();
			organizationModel.setId(UUID.randomUUID());
			organizationModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(organizationModel, domain,organization.getOrganizationID(),data.i+data.j);
		return organizationModel;
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
