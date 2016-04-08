package com.servinglynk.hmis.warehouse.upload.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2014.BulkUpload;
import com.servinglynk.hmis.warehouse.model.v2014.Sync;
import com.servinglynk.hmis.warehouse.upload.business.service.core.IParentService;


public interface IBulkUploadService extends IParentService {

	public List<BulkUpload> getBulkUploads(String status) throws Exception;
	public List<Sync> getSyncs();
}
