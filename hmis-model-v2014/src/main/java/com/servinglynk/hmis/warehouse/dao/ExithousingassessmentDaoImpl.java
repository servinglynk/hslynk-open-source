/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExithousingassessmentDaoImpl extends ParentDaoImpl implements
		ExithousingassessmentDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExithousingassessmentDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ExitHousingAssessment> exitHousingAssessments = domain.getExport().getExitHousingAssessment();
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Exithousingassessment.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(CollectionUtils.isNotEmpty(exitHousingAssessments)) {
			for(ExitHousingAssessment e :exitHousingAssessments) {
				processData(e, domain, data, modelMap, relatedModelMap, exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment.class.getSimpleName(), domain, exportEntity);
	}
	public void processData(ExitHousingAssessment exitHousingAssessment,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
		Exithousingassessment model = null;
		try {
			model = getModelObject(domain, exitHousingAssessment,data,modelMap);
			model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateUpdated()));
			model.setHousingassessment(ExithousingassessmentHousingassessmentEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getHousingAssessment())));
			model.setSubsidyinformation(ExithousingassessmentSubsidyinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getSubsidyInformation())));
			Exit exit = (Exit) getModel(Exithousingassessment.class.getSimpleName(),Exit.class,exitHousingAssessment.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
			model.setExitid(exit);
			model.setExport(exportEntity);
			
			performSaveOrUpdate(model);
		} catch(Exception e) {
			String errorMessage = "Exception in:"+exitHousingAssessment.getExitHousingAssessmentID()+  ":: Exception" +e.getLocalizedMessage();
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
	public com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment getModelObject(ExportDomain domain, ExitHousingAssessment exitHousingAssessment ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment) getModel(Exithousingassessment.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment.class, exitHousingAssessment.getExitHousingAssessmentID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment model = new com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,exitHousingAssessment.getExitHousingAssessmentID(),data);
		
		return model;
	}
}
