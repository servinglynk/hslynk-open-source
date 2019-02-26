package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.core.model.BulkUploadActivities;
import com.servinglynk.hmis.warehouse.core.model.BulkUploadErrors;

public interface BulkUploadErrorActivityService {

	public BulkUploadErrors getBulkUploadErrors(Long bulkUploadId);
	public BulkUploadActivities getBulkUploadActivities(Long bulkUploadId);
}
