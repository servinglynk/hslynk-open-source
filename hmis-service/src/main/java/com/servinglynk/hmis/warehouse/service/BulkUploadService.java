package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;


public interface BulkUploadService {
	public void createBulkUploadEntry(com.servinglynk.hmis.warehouse.core.model.BulkUpload upload) throws Exception;
	public BulkUploads getBulkUploadsByStatus(String status, Account account, Integer startIndex, Integer maxItems);
}
