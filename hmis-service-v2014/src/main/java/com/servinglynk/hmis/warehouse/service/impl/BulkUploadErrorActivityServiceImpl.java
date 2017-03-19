package com.servinglynk.hmis.warehouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.BulkUploadActivities;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadError;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadErrors;
import com.servinglynk.hmis.warehouse.model.v2014.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
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
		List<Error2014> bulkUploadErrors = daoFactory.getBulkUploadErrorDao().getBulkUploadErrorByUploadId(bulkUploadId);
		List<BulkUploadError> bulkErrors = new ArrayList<BulkUploadError>();
		for(Error2014 error2014 : bulkUploadErrors ){
			BulkUploadError error  = new BulkUploadError();
			error.setBulk_upload_ui(error2014.getBulk_upload_ui());
			error.setDate_created(error2014.getDate_created());
			error.setError_description(error2014.getError_description());
			error.setModel_id(error2014.getModel_id());
			error.setSource_system_id(error2014.getSource_system_id());
			error.setProject_group_code(error2014.getProject_group_code());
			error.setTable_name(error2014.getTable_name());
			error.setType(error2014.getType().name());
			bulkErrors.add(error);
		}
		errors.setBulkUploadErrors(bulkErrors);
		return errors;
	}
}
