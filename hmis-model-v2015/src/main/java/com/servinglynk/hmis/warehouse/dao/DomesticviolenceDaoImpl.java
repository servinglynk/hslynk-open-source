package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class DomesticviolenceDaoImpl extends ParentDaoImpl implements
		DomesticviolenceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DomesticviolenceDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class, getProjectGroupCode(domain));
		java.util.List<DomesticViolence> domesticViolenceList = domain.getExport().getDomesticViolence();
		if(domesticViolenceList!=null && !domesticViolenceList.isEmpty())
		{
			for(DomesticViolence domesticViolence : domesticViolenceList)
			{
				Domesticviolence domesticviolenceModel = null;
				try {
					domesticviolenceModel = getModelObject(domain, domesticViolence,data,modelMap);
					domesticviolenceModel.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getDomesticViolenceVictim())));
					domesticviolenceModel.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getWhenOccurred())));
					domesticviolenceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateCreated()));
					domesticviolenceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, domesticViolence.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					domesticviolenceModel.setExport(exportEntity);
					domesticviolenceModel.setEnrollmentid(enrollmentModel);
					domesticviolenceModel.setInformationDate(BasicDataGenerator.getLocalDateTime(domesticViolence.getInformationDate()));
					domesticviolenceModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getDataCollectionStage())));
					performSaveOrUpdate(domesticviolenceModel);
				}catch(Exception e) {
					String errorMessage = "Exception beause of the Domesticviolence::"+domesticViolence.getDomesticViolenceID() +" Exception ::"+e.getMessage();
					if(domesticviolenceModel != null){
						Error2015 error = new Error2015();
						error.model_id = domesticviolenceModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = domesticviolenceModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = domesticviolenceModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Education.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence getModelObject(ExportDomain domain, DomesticViolence domesticViolence ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence domesticviolenceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			domesticviolenceModel = (com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence) getModel(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class, domesticViolence.getDomesticViolenceID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domesticviolenceModel == null) {
			domesticviolenceModel = new com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence();
			domesticviolenceModel.setId(UUID.randomUUID());
			domesticviolenceModel.setRecordToBeInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(domesticviolenceModel, domain,domesticViolence.getDomesticViolenceID(),data,modelMap);
		return domesticviolenceModel;
	}


	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence createDomesticViolence(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence domesticViolence){
	       domesticViolence.setId(UUID.randomUUID());
	       insert(domesticViolence);
	       return domesticViolence;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence updateDomesticViolence(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence domesticViolence){
	       update(domesticViolence);
	       return domesticViolence;
	   }
	   public void deleteDomesticViolence(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence domesticViolence){
	       delete(domesticViolence);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence getDomesticViolenceById(UUID domesticViolenceId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence) get(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class, domesticViolenceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence> getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDomesticViolencesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
