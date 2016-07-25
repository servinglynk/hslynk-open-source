/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastGradeCompleted;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
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
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if (lastGradeCompletedList != null && !lastGradeCompletedList.isEmpty()) {
			for (LastGradeCompleted lastGradeCompleted : lastGradeCompletedList) {
				Lastgradecompleted lastGradeCompletedModel = null;
				try {
					lastGradeCompletedModel = new Lastgradecompleted();
					lastGradeCompletedModel
					.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(lastGradeCompleted
											.getLastGradeCompleted())));
					
					lastGradeCompletedModel.setDateCreatedFromSource(BasicDataGenerator
							.getLocalDateTime(lastGradeCompleted.getDateCreated()));
					lastGradeCompletedModel.setDateUpdatedFromSource(BasicDataGenerator
							.getLocalDateTime(lastGradeCompleted.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, lastGradeCompleted.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					lastGradeCompletedModel.setEnrollmentid(enrollmentModel);
					lastGradeCompletedModel.setExport(exportEntity);
					performSaveOrUpdate(lastGradeCompletedModel);
				}catch(Exception e) {
					String errorMessage = "Failure in LastGradeCompleted:::"+lastGradeCompleted.toString()+ " with exception"+e.getLocalizedMessage();
					if (lastGradeCompletedModel != null) {
						Error2014 error = new Error2014();
						error.model_id = lastGradeCompletedModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = lastGradeCompletedModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = lastGradeCompletedModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted getModelObject(ExportDomain domain,LastGradeCompleted lastGradeCompleted ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted lastGradeCompletedModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			lastGradeCompletedModel = (com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted) getModel(com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class, lastGradeCompleted.getLastGradeCompletedID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(lastGradeCompletedModel == null) {
			lastGradeCompletedModel = new com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted();
			lastGradeCompletedModel.setId(UUID.randomUUID());
			lastGradeCompletedModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(lastGradeCompletedModel, domain,lastGradeCompleted.getLastGradeCompletedID(),data.i+data.j);
		return lastGradeCompletedModel;
	}
}
