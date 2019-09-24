/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Error2017;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DateofengagementDaoImpl extends ParentDaoImpl implements
		DateofengagementDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DateofengagementDaoImpl.class);
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception
	{
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement.class, getProjectGroupCode(domain));
		List<DateOfEngagement> dateOfEngagements = domain.getExport().getDateOfEngagement();
		if(CollectionUtils.isNotEmpty(dateOfEngagements))
		{
			for(DateOfEngagement dateOfEngagement: dateOfEngagements)
			{
				Dateofengagement dateOfEngagementModel = null;
			 try {
				 dateOfEngagementModel = getModelObject(domain, dateOfEngagement,data,modelMap);
				 dateOfEngagementModel.setDateofengagement(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateOfEngagement()));
				 Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, dateOfEngagement.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
				 dateOfEngagementModel.setEnrollmentid(enrollmentModel);
				 dateOfEngagementModel.setExport(exportEntity);
				 dateOfEngagementModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateCreated()));
				 dateOfEngagementModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateUpdated()));
				 performSaveOrUpdate(dateOfEngagementModel,domain);
			 } catch(Exception e) {
				 String errorMessage = "Exception beause of the Dateofengagement::"+dateOfEngagement.getDateOfEngagementID() +" Exception ::"+e.getMessage();
				 if(dateOfEngagementModel != null){
					 Error2017 error = new Error2017();
					 error.model_id = dateOfEngagementModel.getId();
					 error.bulk_upload_ui = domain.getUpload().getId();
					 error.project_group_code = domain.getUpload().getProjectGroupCode();
					 error.source_system_id = dateOfEngagementModel.getSourceSystemId();
					 error.type = ErrorType.ERROR;
					 error.error_description = errorMessage;
					 error.date_created = dateOfEngagementModel.getDateCreated();
					 performSave(error);
				 }
				 logger.error(errorMessage);
			 }
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Disabilities.class.getSimpleName(), domain,exportEntity);

	}
	
	public com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement getModelObject(ExportDomain domain, DateOfEngagement dateofengagement ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement) getModel(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement.class, dateofengagement.getDateOfEngagementID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement model = new com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(dateofengagement.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,dateofengagement.getDateOfEngagementID(),data);
		return model;
	}


	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement dateofengagement){
	       dateofengagement.setId(UUID.randomUUID());
	       insert(dateofengagement);
	       return dateofengagement;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement dateofengagement){
	       update(dateofengagement);
	       return dateofengagement;
	   }
	   public void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement dateofengagement){
	       delete(dateofengagement);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement getDateofengagementById(UUID dateofengagementId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement.class);
		      criteria.add(Restrictions.eq("id", dateofengagementId));
		      List<com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDateofengagementsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
