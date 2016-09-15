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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ReferralSource;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.ReferralsourceReferralsourceEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Referralsource;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ReferralsourceDaoImpl extends ParentDaoImpl implements
		ReferralsourceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ReferralsourceDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ReferralSource> referralSources = domain.getExport().getReferralSource();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Referralsource.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(referralSources !=null && !referralSources.isEmpty())
		{
			for(ReferralSource referralSource : referralSources) {
				Referralsource model = null;
				try {
					model = getModelObject(domain, referralSource,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(referralSource.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(referralSource.getDateUpdated()));
					model.setReferralsource(ReferralsourceReferralsourceEnum.lookupEnum(BasicDataGenerator.getStringValue(referralSource.getReferralSource())));
					model.setCountoutreachreferralapproaches(BasicDataGenerator.getIntegerValue(referralSource.getCountOutreachReferralApproaches()));
					Enrollment enrollmentModel = (Enrollment) getModel(Referralsource.class.getSimpleName(),Enrollment.class,referralSource.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(referralSource.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(referralSource.getDataCollectionStage())));
					
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Failure in ReferralSource:::"+referralSource.toString()+ " with exception"+e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, Referralsource.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Referralsource getModelObject(ExportDomain domain,ReferralSource referralsource ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Referralsource modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Referralsource) getModel(Referralsource.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class, referralsource.getReferralSourceID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Referralsource();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Referralsource model = new com.servinglynk.hmis.warehouse.model.v2014.Referralsource();
		  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(referralsource.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,referralsource.getReferralSourceID(),data);
		return model;
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Referralsource createReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       referralsource.setId(UUID.randomUUID()); 
	       insert(referralsource);
	       return referralsource;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Referralsource updateReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       update(referralsource);
	       return referralsource;
	   }
	   public void deleteReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       delete(referralsource);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Referralsource getReferralsourceById(UUID referralsourceId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Referralsource) get(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class, referralsourceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Referralsource> getAllEnrollmentReferralsources(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Referralsource>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentReferralsourcesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
