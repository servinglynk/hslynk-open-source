/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.base.OrganizationEntity;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class OrganizationDaoImpl extends ParentDaoImpl implements
		OrganizationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(OrganizationDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		 List<Organization> organizations = domain.getExport().getOrganization();
		 com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		 Data data =new Data();
		 Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Organization.class, getProjectGroupCode(domain));
		 if(organizations != null && !organizations.isEmpty())
		 {
			 for(Organization organization : organizations)
			 {
				 try {
					 com.servinglynk.hmis.warehouse.model.v2015.Organization organizationModel = getModelObject(domain, organization,data,modelMap);
					 organizationModel.setOrganizationcommonname(organization.getOrganizationCommonName());
					 organizationModel.setOrganizationname(organization.getOrganizationName());
					 organizationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateCreated()));
					 organizationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateUpdated()));
					 organizationModel.setExport(exportEntity);
					 exportEntity.addOrganization(organizationModel);
					 performSaveOrUpdate(organizationModel);
				 } catch(Exception e){
					 logger.error("Exception beause of the organization::"+organization.getOrganizationID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				 }
			 }
		 }
		 hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Organization.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2015.Organization getModelObject(ExportDomain domain, Organization organization ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Organization organizationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			organizationModel = (com.servinglynk.hmis.warehouse.model.v2015.Organization) getModel(com.servinglynk.hmis.warehouse.model.v2015.Organization.class, organization.getOrganizationID(), getProjectGroupCode(domain),false,modelMap);
		
		if(organizationModel == null) {
			organizationModel = new com.servinglynk.hmis.warehouse.model.v2015.Organization();
			organizationModel.setId(UUID.randomUUID());
			organizationModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(organizationModel, domain,organization.getOrganizationID(),data.i+data.j);
		return organizationModel;
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

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

}
