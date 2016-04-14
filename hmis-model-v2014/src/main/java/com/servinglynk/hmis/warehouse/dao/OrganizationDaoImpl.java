/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Project;
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
		 if(organizations != null && !organizations.isEmpty())
		 {
			 for(Organization organization : organizations)
			 {
				 com.servinglynk.hmis.warehouse.model.stagv2014.Organization organizationModel = new com.servinglynk.hmis.warehouse.model.stagv2014.Organization();
				 organizationModel.setId(UUID.randomUUID());
				 organizationModel.setOrganizationcommonname(organization.getOrganizationCommonName());
				 organizationModel.setOrganizationname(organization.getOrganizationName());
				  com.servinglynk.hmis.warehouse.model.stagv2014.Project project =  (com.servinglynk.hmis.warehouse.model.stagv2014.Project) get(Project.class,domain.getOrganizationProjectMap().get(BasicDataGenerator.getStringValue(organization.getOrganizationID())));
				  organizationModel.addProject(project);
				  organizationModel.setDateCreated(LocalDateTime.now());
				  organizationModel.setDateUpdated(LocalDateTime.now());
				 organizationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateCreated()));
				 organizationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateUpdated()));
				 com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				 organizationModel.setExport(exportEntity);
				 exportEntity.addOrganization(organizationModel);
				 hydrateCommonFields(organizationModel, domain,String.valueOf(organization.getOrganizationID()));
				 insertOrUpdate(organizationModel);
			 }
		 }
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2014.Organization> organizations = export.getOrganizations();
		hydrateBulkUploadActivity(organizations, com.servinglynk.hmis.warehouse.model.v2014.Organization.class.getSimpleName(), export,id);
		if(organizations != null && !organizations.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2014.Organization organization : organizations) {
				if(organization != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Organization target = new com.servinglynk.hmis.warehouse.model.v2014.Organization();
					BeanUtils.copyProperties(organization, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
				}
			}
			
			
		}
	}
	
	
/*	public com.servinglynk.hmis.warehouse.model.live.Organization getOrganizationByYd(UUID organizationId){
		return (com.servinglynk.hmis.warehouse.model.live.Organization) get(com.servinglynk.hmis.warehouse.model.live.Organization.class,organizationId);
	}*/

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
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
