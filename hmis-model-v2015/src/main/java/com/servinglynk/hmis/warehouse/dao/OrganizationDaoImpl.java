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
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.base.OrganizationEntity;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.model.stagv2015.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class OrganizationDaoImpl extends ParentDaoImpl implements
		OrganizationDao {
	
	@Autowired
	private ParentDaoFactory factory;

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
				 com.servinglynk.hmis.warehouse.model.stagv2015.Organization organizationModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Organization();
				 organizationModel.setId(UUID.randomUUID());
				 organizationModel.setOrganizationcommonname(organization.getOrganizationCommonName());
				 organizationModel.setOrganizationname(organization.getOrganizationName());
				  com.servinglynk.hmis.warehouse.model.stagv2015.Project project =  (com.servinglynk.hmis.warehouse.model.stagv2015.Project) get(Project.class,domain.getOrganizationProjectMap().get(BasicDataGenerator.getStringValue(organization.getOrganizationID())));
				  organizationModel.addProject(project);
				  organizationModel.setDateCreated(LocalDateTime.now());
				  organizationModel.setDateUpdated(LocalDateTime.now());
				 organizationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateCreated()));
				 organizationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateUpdated()));
				 com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				 organizationModel.setExport(exportEntity);
				 exportEntity.addOrganization(organizationModel);
				 hydrateCommonFields(organizationModel, domain);
				 insertOrUpdate(organizationModel);
			 }
		 }
	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Organization> organizations = export.getOrganizations();
		hydrateBulkUploadActivity(organizations, com.servinglynk.hmis.warehouse.model.v2015.Organization.class.getSimpleName(), export);
		if(organizations != null && !organizations.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Organization organization : organizations) {
				if(organization != null) {
					com.servinglynk.hmis.warehouse.model.v2015.Organization target = new com.servinglynk.hmis.warehouse.model.v2015.Organization();
					BeanUtils.copyProperties(organization, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					target.setExport(exportEntity);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
					hydrateCommonFields(target);
				//	factory.getProjectDao().hydrateLive(export);
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
	
	   public com.servinglynk.hmis.warehouse.model.v2015.Organization createOrganization(com.servinglynk.hmis.warehouse.model.v2015.Organization organization){
		   organization.setId(UUID.randomUUID());
	       insert(organization);
	       OrganizationEntity entity = new OrganizationEntity();
	       BeanUtils.copyProperties(organization, entity);
	       insert(entity);
	       return organization;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Organization updateOrganization(com.servinglynk.hmis.warehouse.model.v2015.Organization organization){
	       update(organization);
	       return organization;
	   }
	   public void deleteOrganization(com.servinglynk.hmis.warehouse.model.v2015.Organization organization){
	       delete(organization);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Organization getOrganizationById(UUID organizationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2015.Organization) get(com.servinglynk.hmis.warehouse.model.v2015.Organization.class, organizationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Organization> getAllOrganizations(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Organization.class);
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Organization>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getOrganizationCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Organization.class);
	       return countRows(criteria);
	   }

}
