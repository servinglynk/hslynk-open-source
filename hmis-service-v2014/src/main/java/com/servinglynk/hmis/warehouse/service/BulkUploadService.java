package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.model.base.HmisBulkUpload;


public interface BulkUploadService {
	public void createBulkUploadEntry(HmisBulkUpload upload) throws Exception;
	public BulkUploads getBulkUploadsByStatus(String status, Account account, Integer startIndex, Integer maxItems);
}
