package com.servinglynk.hmis.warehouse.upload.business.service.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.upload.service.IBulkUploadService;
import com.servinglynk.hmis.warehouse.upload.service.IBulkUploadWorker;



public class ParentServiceFactory  implements IParentServiceFactory {

	@Autowired
	IBulkUploadService bulkUploadService;

	public IBulkUploadService getBulkUploadService() {
		return bulkUploadService;
	}
	
	@Autowired
	IBulkUploadWorker bulkUploadWorker;

	public IBulkUploadWorker getBulkUploadWorker() {
		return bulkUploadWorker;
	}
}

