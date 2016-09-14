/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
import com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnum;
import com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ServicesDaoImpl extends ParentDaoImpl implements ServicesDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ServicesDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Services> servicesList = domain.getExport().getServices();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Services.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Services.class, getProjectGroupCode(domain));
		if(servicesList != null && !servicesList.isEmpty())
		{
			for(Services services : servicesList)
			{
				com.servinglynk.hmis.warehouse.model.v2014.Services model = null;
				try {
					model = getModelObject(domain, services,data,modelMap);
					model.setDateprovided(BasicDataGenerator.getLocalDateTime(services.getDateProvided()));
					model.setFaamount(new BigDecimal(String.valueOf(services.getFAAmount())));
					model.setOthertypeprovided(services.getOtherTypeProvided());
					model.setRecordtype(ServicesRecordtypeEnum.lookupEnum(services.getRecordType()));
					model.setReferraloutcome(ServicesReferraloutcomeEnum.lookupEnum(BasicDataGenerator.getStringValue(services.getReferralOutcome())));
					model.setSubtypeprovided(BasicDataGenerator.getIntegerValue(services.getSubTypeProvided()));
					model.setTypeprovided(BasicDataGenerator.getIntegerValue(services.getTypeProvided()));
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(services.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(services.getDateUpdated()));
					Enrollment enrollment = (Enrollment) getModel(com.servinglynk.hmis.warehouse.model.v2014.Services.class.getSimpleName(),Enrollment.class, services.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollment);
					model.setExport(exportEntity);
					
					performSaveOrUpdate(model);
				} catch(Exception e) {
					String errorMessage = "Failure in services:::"+services.toString()+ " with exception"+e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Services.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Services getModelObject(ExportDomain domain,Services Services ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Services servicesModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			servicesModel = (com.servinglynk.hmis.warehouse.model.v2014.Services) getModel(com.servinglynk.hmis.warehouse.model.v2014.Services.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Services.class, Services.getServicesID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(servicesModel == null) {
			servicesModel = new com.servinglynk.hmis.warehouse.model.v2014.Services();
			servicesModel.setId(UUID.randomUUID());
			servicesModel.setRecordToBeInserted(true);
			++data.i;
		}
		hydrateCommonFields(servicesModel, domain,Services.getServicesID(),data,modelMap);
		return servicesModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Services createServices(com.servinglynk.hmis.warehouse.model.v2014.Services services){
	       services.setId(UUID.randomUUID()); 
	       insert(services);
	       return services;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Services updateServices(com.servinglynk.hmis.warehouse.model.v2014.Services services){
	       update(services);
	       return services;
	   }
	   public void deleteServices(com.servinglynk.hmis.warehouse.model.v2014.Services services){
	       delete(services);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Services getServicesById(UUID servicesId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Services) get(com.servinglynk.hmis.warehouse.model.v2014.Services.class, servicesId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Services> getAllEnrollmentServicess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Services.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Services>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentServicessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Services.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
