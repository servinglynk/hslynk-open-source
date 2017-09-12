/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DateofengagementDaoImpl extends ParentDaoImpl implements
		DateofengagementDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DateofengagementDao.class);
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
	{
		List<DateOfEngagement> dateOfEngagements = domain.getExport().getDateOfEngagement();
		Long i =new Long(0L);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Dateofengagement.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(dateOfEngagements!=null && !dateOfEngagements.isEmpty())
		{
			for(DateOfEngagement e :dateOfEngagements) {
				processData(e, domain, data, modelMap, relatedModelMap, exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, Dateofengagement.class.getSimpleName(), domain, exportEntity);
	}
	
	    public void processData(DateOfEngagement dateOfEngagement,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
			Dateofengagement model = null;
			try {
				model = getModelObject(domain, dateOfEngagement,data,modelMap);
				model.setDateofengagement(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateOfEngagement()));
				Enrollment enrollmentModel = (Enrollment) getModel(Dateofengagement.class.getSimpleName(),Enrollment.class, dateOfEngagement.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
				model.setEnrollmentid(enrollmentModel);
				model.setExport(exportEntity);
				model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateCreated()));
				model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateUpdated()));
				
				performSaveOrUpdate(model);
			} catch(Exception e) {
				String errorMessage = "Exception in:"+dateOfEngagement.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
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
	  public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement getModelObject(ExportDomain domain, DateOfEngagement dateOfEngagement,Data data, Map<String,HmisBaseModel> modelMap) {
		  com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement modelFromDB = null;
		  if(!isFullRefresh(domain))
			  modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement) getModel(Dateofengagement.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class, dateOfEngagement.getDateOfEngagementID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		  if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		  }
		  com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement model = new com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		  hydrateCommonFields(model, domain,dateOfEngagement.getDateOfEngagementID(),data);
		  
		  return model;
      }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       dateofengagement.setId(UUID.randomUUID()); 
	       insert(dateofengagement);
	       return dateofengagement;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       update(dateofengagement);
	       return dateofengagement;
	   }
	   public void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       delete(dateofengagement);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement getDateofengagementById(UUID dateofengagementId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class);
		      criteria.add(Restrictions.eq("id", dateofengagementId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDateofengagementsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
