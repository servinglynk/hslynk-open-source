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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Project;
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
		 if(organizations != null && !organizations.isEmpty())
		 {
			 for(Organization organization : organizations)
			 {
				 com.servinglynk.hmis.warehouse.model.staging.Organization organizationModel = new com.servinglynk.hmis.warehouse.model.staging.Organization();
				 organizationModel.setId(UUID.randomUUID());
				 organizationModel.setOrganizationcommonname(organization.getOrganizationCommonName());
				 organizationModel.setOrganizationname(organization.getOrganizationName());
				  com.servinglynk.hmis.warehouse.model.staging.Project project =  (com.servinglynk.hmis.warehouse.model.staging.Project) get(Project.class,domain.getOrganizationProjectMap().get(BasicDataGenerator.getStringValue(organization.getOrganizationID())));
				  organizationModel.addProject(project);
				 organizationModel.setDateCreated(BasicDataGenerator.getLocalDateTime(organization.getDateCreated()));
				 organizationModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(organization.getDateUpdated()));
				 com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				 organizationModel.setExport(exportEntity);
				 exportEntity.addOrganization(organizationModel);
				 insertOrUpdate(organizationModel);
			 }
		 }
	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Organization> organizations = export.getOrganizations();
		if(organizations != null && !organizations.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Organization organization : organizations) {
				if(organization != null) {
					com.servinglynk.hmis.warehouse.model.live.Organization target = new com.servinglynk.hmis.warehouse.model.live.Organization();
					BeanUtils.copyProperties(organization, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
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
	
	   public com.servinglynk.hmis.warehouse.model.live.Organization createOrganization(com.servinglynk.hmis.warehouse.model.live.Organization organization){
	       insert(organization);
	       return organization;
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Organization updateOrganization(com.servinglynk.hmis.warehouse.model.live.Organization organization){
	       update(organization);
	       return organization;
	   }
	   public void deleteOrganization(com.servinglynk.hmis.warehouse.model.live.Organization organization){
	       delete(organization);
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Organization getOrganizationById(UUID organizationId){ 
	       return (com.servinglynk.hmis.warehouse.model.live.Organization) get(com.servinglynk.hmis.warehouse.model.live.Organization.class, organizationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.live.Organization> getAllOrganizations(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Organization.class);
	       return (List<com.servinglynk.hmis.warehouse.model.live.Organization>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getOrganizationCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Organization.class);
	       return countRows(criteria);
	   }

}
