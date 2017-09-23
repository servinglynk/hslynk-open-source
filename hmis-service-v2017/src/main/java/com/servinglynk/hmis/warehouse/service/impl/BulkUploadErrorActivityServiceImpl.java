package com.servinglynk.hmis.warehouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.BulkUploadActivities;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadError;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadErrors;
import com.servinglynk.hmis.warehouse.model.v2017.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.service.BulkUploadErrorActivityService;

public class BulkUploadErrorActivityServiceImpl  extends ServiceBase implements BulkUploadErrorActivityService {

	@Transactional
	public BulkUploadActivities getBulkUploadActivities(Long bulkUploadId) {
		BulkUploadActivities activities = new BulkUploadActivities();
		List<BulkUploadActivity> bulkUploadActivities = daoFactory.getBulkUploadActivityDao().getBulkUploadActivityByUploadId(bulkUploadId);
		List<com.servinglynk.hmis.warehouse.core.model.BulkUploadActivity> bulkActivities = new ArrayList<com.servinglynk.hmis.warehouse.core.model.BulkUploadActivity>();
		for(BulkUploadActivity bulkUploadACtivity : bulkUploadActivities  ) {
			com.servinglynk.hmis.warehouse.core.model.BulkUploadActivity activity = new com.servinglynk.hmis.warehouse.core.model.BulkUploadActivity();
			activity.setDescription(bulkUploadACtivity.getDescription());
			activity.setInserted(bulkUploadACtivity.getInserted());
			activity.setUpdated(bulkUploadACtivity.getUpdated());
			activity.setTableName(bulkUploadACtivity.getTableName());
			activity.setRecordsProcessed(bulkUploadACtivity.getRecordsProcessed());
			bulkActivities.add(activity);
		}
		activities.setBulkUploadActivities(bulkActivities);
		return activities;
	}
	@Transactional
	public BulkUploadErrors getBulkUploadErrors(Long bulkUploadId) {
		BulkUploadErrors errors = new BulkUploadErrors();
		List<Error2017> bulkUploadErrors = daoFactory.getBulkUploadErrorDao().getBulkUploadErrorByUploadId(bulkUploadId);
		List<BulkUploadError> bulkErrors = new ArrayList<BulkUploadError>();
		for(Error2017 error2015: bulkUploadErrors ){
			BulkUploadError error  = new BulkUploadError();
			error.setBulk_upload_ui(error2015.getBulk_upload_ui());
			error.setDate_created(error2015.getDate_created());
			error.setError_description(error2015.getError_description());
			error.setModel_id(error2015.getModel_id());
			error.setSource_system_id(error2015.getSource_system_id());
			error.setProject_group_code(error2015.getProject_group_code());
			error.setTable_name(error2015.getTable_name());
			error.setType(error2015.getType().name());
			bulkErrors.add(error);
		}
		errors.setBulkUploadErrors(bulkErrors);
		return errors;
	}
}
