/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.helper.ChronicHomelessCalcHelper;
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
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilitiesModel = getModelObject(domain, disabilities, data, modelMap);
				try {
					disabilitiesModel = getModelObject(domain, disabilities, data, modelMap);
					disabilitiesModel.setDisabilityresponse(BasicDataGenerator.getIntegerValue(disabilities.getDisabilityResponse()));
					disabilitiesModel.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDisabilityType())));
					disabilitiesModel.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDocumentationOnFile())));
					disabilitiesModel.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getIndefiniteAndImpairs())));
					disabilitiesModel.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHHowConfirmed())));
					disabilitiesModel.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHSMIInformation())));
					disabilitiesModel.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getReceivingServices())));
					disabilitiesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateCreated()));
					disabilitiesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),Enrollment.class, disabilities.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					disabilitiesModel.setEnrollmentid(enrollmentModel);
					disabilitiesModel.setInformationDate(BasicDataGenerator.getLocalDateTime(disabilities.getInformationDate()));
					disabilitiesModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDataCollectionStage())));
					disabilitiesModel.setExport(exportEntity);
					performSaveOrUpdate(disabilitiesModel);
				}catch(Exception e) {
					String errorMessage = "Exception in Disabilities :"+disabilities.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
					if (disabilitiesModel != null) {
						Error2014 error = new Error2014();
						error.model_id = disabilitiesModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = disabilitiesModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = disabilitiesModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(), domain, exportEntity);
	}
		
	public com.servinglynk.hmis.warehouse.model.v2014.Disabilities getModelObject(ExportDomain domain, Disabilities disabilities ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilitiesModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			disabilitiesModel = (com.servinglynk.hmis.warehouse.model.v2014.Disabilities) getModel(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class, disabilities.getDisabilitiesID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(disabilitiesModel == null) {
			disabilitiesModel = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
			disabilitiesModel.setId(UUID.randomUUID());
			disabilitiesModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(disabilitiesModel, domain,disabilities.getDisabilitiesID(),data.i+data.j);
		return disabilitiesModel;
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
	       return (com.servinglynk.hmis.warehouse.model.v2014.Disabilities) get(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class, disabilitiesId);
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
