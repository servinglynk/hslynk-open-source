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
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2020.Error2017;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentCocDaoImpl extends ParentDaoImpl implements
		EnrollmentCocDao {
	private static final Logger logger = LoggerFactory
			.getLogger(EnrollmentCocDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */     
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {

		List<EnrollmentCoC> enrollmentCoCs = domain.getExport().getEnrollmentCoC();
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class, getProjectGroupCode(domain));
		if(CollectionUtils.isNotEmpty(enrollmentCoCs))
		{
			for(EnrollmentCoC enrollmentCoc : enrollmentCoCs)
			{
				EnrollmentCoc enrollmentCocModel = null;
				try {
					enrollmentCocModel = getModelObject(domain, enrollmentCoc,data,modelMap);
					enrollmentCocModel.setCocCode(enrollmentCoc.getCocCode());
					enrollmentCocModel.setHouseholdId(enrollmentCoc.getHouseholdID());
					enrollmentCocModel.setInformationDate(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateCreated()));
					enrollmentCocModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateCreated()));
					enrollmentCocModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, enrollmentCoc.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					enrollmentCocModel.setEnrollmentid(enrollmentModel);
					enrollmentCocModel.setExport(exportEntity);
					enrollmentCocModel.setInformationDate(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getInformationDate()));
					enrollmentCocModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum((enrollmentCoc.getDataCollectionStage())));
					performSaveOrUpdate(enrollmentCocModel,domain);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the enrollmentCoc::"+enrollmentCoc.getEnrollmentCoCID() +" Exception ::"+e.getMessage();
					if(enrollmentCocModel != null){
						Error2017 error = new Error2017();
						error.model_id = enrollmentCocModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = enrollmentCocModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = enrollmentCocModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc getModelObject(ExportDomain domain, EnrollmentCoC enrollmentCoc ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc) getModel(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class, enrollmentCoc.getEnrollmentCoCID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc model = new com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,enrollmentCoc.getEnrollmentCoCID(),data);
		return model;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc createEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc enrollmentCoc){
	       enrollmentCoc.setId(UUID.randomUUID()); 
	       insert(enrollmentCoc);
	       return enrollmentCoc;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc updateEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc enrollmentCoc){
	       update(enrollmentCoc);
	       return enrollmentCoc;
	   }
	   public void deleteEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc enrollmentCoc){
	       delete(enrollmentCoc);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc getEnrollmentCocById(UUID enrollmentCocId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class);
		      criteria.add(Restrictions.eq("id", enrollmentCocId));
		      List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc> getAllEnrollmentEnrollmentCocs(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentEnrollmentCocsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }


	public com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc getEnrollmentCocByDedupEnrollmentCocId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc> enrollmentCoc = (List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc>) findByCriteria(criteria);
		if(enrollmentCoc !=null && enrollmentCoc.size()>0) return enrollmentCoc.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc> getAllEnrollmentCoc(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class);	
		List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc> enrollmentCoc = (List<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc>) findByCriteria(criteria,startIndex,maxItems);
		return enrollmentCoc;
	}
	
	
	public long getEnrollmentCocCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc.class);	
		return countRows(criteria);
	}


}
