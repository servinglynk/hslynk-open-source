package com.servinglynk.hmis.warehouse.service.impl;

import com.servinglynk.hmis.warehouse.core.model.BulkUploadActivities;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadErrors;
import com.servinglynk.hmis.warehouse.service.BulkUploadService;

public class BulkUploadServiceImpl  extends ServiceBase implements BulkUploadService {

	public BulkUploadActivities getBulkUploadActivities(Long bulkUploadId) {
		BulkUploadActivities activities = new BulkUploadActivities();
		return activities;
	}
	
	public BulkUploadErrors getBulkUploadErrors(Long bulkUploadId) {
		BulkUploadErrors errors = new BulkUploadErrors();
		return errors;
	}
}
