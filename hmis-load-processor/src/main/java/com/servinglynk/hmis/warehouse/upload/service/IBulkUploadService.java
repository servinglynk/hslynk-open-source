package com.servinglynk.hmis.warehouse.upload.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.staging.BulkUpload;
import com.servinglynk.hmis.warehouse.upload.business.service.core.IParentService;


public interface IBulkUploadService extends IParentService {

	public void createBulkUploadEntry(String filPath);
	public List<BulkUpload> getBulkUploads(String status) throws Exception;
}
