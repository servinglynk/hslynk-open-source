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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DisabilitiesDaoImpl extends ParentDaoImpl implements
		DisabilitiesDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DisabilitiesDaoImpl.class);
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
	{
		Export export = domain.getExport();
		List<Disabilities> disabilitiesList = export.getDisabilities();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(disabilitiesList!=null && disabilitiesList.size() > 0 )
		{
			for(Disabilities disabilities : disabilitiesList)
			{
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities model = getModelObject(domain, disabilities, data, modelMap);
				try {
					model = getModelObject(domain, disabilities, data, modelMap);
					model.setDisabilityresponse(BasicDataGenerator.getIntegerValue(disabilities.getDisabilityResponse()));
					model.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDisabilityType())));
					model.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDocumentationOnFile())));
					model.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getIndefiniteAndImpairs())));
					model.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHHowConfirmed())));
					model.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHSMIInformation())));
					model.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getReceivingServices())));
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),Enrollment.class, disabilities.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(disabilities.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDataCollectionStage())));
					model.setExport(exportEntity);
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Exception in Disabilities :"+disabilities.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(), domain, exportEntity);
	}
		
	public com.servinglynk.hmis.warehouse.model.v2014.Disabilities getModelObject(ExportDomain domain, Disabilities disabilities ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Disabilities modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Disabilities) getModel(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class, disabilities.getDisabilitiesID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		  com.servinglynk.hmis.warehouse.model.v2014.Disabilities model = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
		  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,disabilities.getDisabilitiesID(),data);
		
		return model;
	}
	
	   public com.servinglynk.hmis.warehouse.model.v2014.Disabilities createDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities){
	       disabilities.setId(UUID.randomUUID()); 
	       insert(disabilities);
	       return disabilities;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Disabilities updateDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities){
	       update(disabilities);
	       return disabilities;
	   }
	   public void deleteDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities){
	       delete(disabilities);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Disabilities getDisabilitiesById(UUID disabilitiesId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
		      criteria.add(Restrictions.eq("id", disabilitiesId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities> getAllEnrollmentDisabilitiess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDisabilitiessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
