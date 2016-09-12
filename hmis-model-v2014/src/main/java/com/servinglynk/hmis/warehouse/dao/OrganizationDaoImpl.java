/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.model.base.OrganizationEntity;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class OrganizationDaoImpl extends ParentDaoImpl implements
		OrganizationDao {
	
	@Autowired
	private ParentDaoFactory factory;
	
	private static final Logger logger = LoggerFactory
			.getLogger(OrganizationDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		 List<Organization> organizations = domain.getExport().getOrganization();
		 Data data =new Data();
		 Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Organization.class, getProjectGroupCode(domain));
		 com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Organization.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		 if(organizations != null && !organizations.isEmpty())
		 {
			 for(Organization organization : organizations)
			 {
				 com.servinglynk.hmis.warehouse.model.v2014.Organization model = null;
				 try {
					 model = getModelObject(domain, organization,data,modelMap);
					 model.setOrganizationcommonname(organization.getOrganizationCommonName());
					 model.setOrganizationname(organization.getOrganizationName());
					 model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateCreated()));
					 model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(organization.getDateUpdated()));
					 model.setExport(exportEntity);
				//	 OrganizationEntity baseOrganization = new OrganizationEntity();
					// BeanUtils.copyProperties(baseOrganization, organizationModel);
					// factory.getHmisOrganizationDao().createOrganization(baseOrganization);
					 if(!isFullRefresh(domain)) {
							HmisBaseModel hmisBaseModel = modelMap.get(model.getSourceSystemId());
							if(hmisBaseModel !=null) {
								modelMatch(hmisBaseModel, model);
							}	
						}
					 performSaveOrUpdate(model);
				 }catch(Exception e) {
					 String errorMessage = "Failure in Organization:::"+organization.toString()+ " with exception"+e.getLocalizedMessage();
					 if (model != null) {
						 Error2014 error = new Error2014();
						 error.model_id = model.getId();
						 error.bulk_upload_ui = domain.getUpload().getId();
						 error.project_group_code = domain.getUpload().getProjectGroupCode();
						 error.source_system_id = model.getSourceSystemId();
						 error.type = ErrorType.ERROR;
						 error.error_description = errorMessage;
						 error.date_created = model.getDateCreated();
						 performSave(error);
					 }
					 logger.error(errorMessage);
				 }
			 }
		 }
		 hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Organization.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Organization getModelObject(ExportDomain domain,Organization organization ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Organization organizationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			organizationModel = (com.servinglynk.hmis.warehouse.model.v2014.Organization) getModel(com.servinglynk.hmis.warehouse.model.v2014.Organization.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Organization.class, organization.getOrganizationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(organizationModel == null) {
			organizationModel = new com.servinglynk.hmis.warehouse.model.v2014.Organization();
			organizationModel.setId(UUID.randomUUID());
			organizationModel.setRecordToBeInserted(true);
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
