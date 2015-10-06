package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.staging.BulkUpload;

public interface BulkUploaderWorkerDao extends ParentDao{
	public List<BulkUpload> findUnProcessedUploads(String status) throws Exception;
	public List<BulkUpload> findBulkUploadByStatus(String status) throws Exception;
	
	
	}
