package com.servinglynk.hmis.warehouse.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Account;


public interface BulkUploadService {
	public void createBulkUploadEntry(com.servinglynk.hmis.warehouse.core.model.BulkUpload upload) throws Exception;
	public List<com.servinglynk.hmis.warehouse.core.model.BulkUpload> getBulkUploadsByStatus(String status, Account account);
}
