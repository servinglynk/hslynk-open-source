package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BulkUploads;


public interface BulkUploadService {
	public com.servinglynk.hmis.warehouse.core.model.BulkUpload createBulkUploadEntry(com.servinglynk.hmis.warehouse.core.model.BulkUpload model, Account account) throws Exception;
	public BulkUploads getBulkUploadsByStatus(String status, Account account, Integer startIndex, Integer maxItems);
	public BulkUploads getRecentUploads(Account account, Integer startIndex, Integer maxItems);
	public com.servinglynk.hmis.warehouse.core.model.BulkUpload getBulkUploadId(Long bulkUploadId);
	public void deleteBulkUpload(Long bulkUploadId,String username);
	public com.servinglynk.hmis.warehouse.core.model.BulkUpload updateBulkUpload(com.servinglynk.hmis.warehouse.core.model.BulkUpload upload,String username);
}
