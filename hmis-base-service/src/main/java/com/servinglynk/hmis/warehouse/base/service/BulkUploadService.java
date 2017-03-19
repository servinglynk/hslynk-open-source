package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;


public interface BulkUploadService {
	public void createBulkUploadEntry(BulkUpload upload, Account account) throws Exception;
	public BulkUploads getBulkUploadsByStatus(String status, Account account, Integer startIndex, Integer maxItems);
	public BulkUploads getRecentUploads(Account account, Integer startIndex, Integer maxItems);
}
