/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastGradeCompleted;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class LastgradecompletedDaoImpl extends ParentDaoImpl implements
		LastgradecompletedDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LastgradecompletedDaoImpl.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.
	 * hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<LastGradeCompleted> lastGradeCompletedList = domain.getExport()
				.getLastGradeCompleted();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Lastgradecompleted.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if (lastGradeCompletedList != null && !lastGradeCompletedList.isEmpty()) {
			for (LastGradeCompleted lastGradeCompleted : lastGradeCompletedList) {
				Lastgradecompleted model = null;
				try {
					model =  getModelObject(domain, lastGradeCompleted,data,modelMap);
					model
					.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(lastGradeCompleted
											.getLastGradeCompleted())));
					
					model.setDateCreatedFromSource(BasicDataGenerator
							.getLocalDateTime(lastGradeCompleted.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator
							.getLocalDateTime(lastGradeCompleted.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Lastgradecompleted.class.getSimpleName(),Enrollment.class, lastGradeCompleted.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
					
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Failure in LastGradeCompleted:::"+lastGradeCompleted.toString()+ " with exception"+e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted getModelObject(ExportDomain domain,LastGradeCompleted lastGradeCompleted ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted model = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			model = (com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted) getModel(Lastgradecompleted.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class, lastGradeCompleted.getLastGradeCompletedID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(model == null) {
			model = new com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted();
			model.setId(UUID.randomUUID());
			model.setRecordToBeInserted(true);
			++data.i;
		}
		hydrateCommonFields(model, domain,lastGradeCompleted.getLastGradeCompletedID(),data,modelMap);
		
		return model;
	}
}
