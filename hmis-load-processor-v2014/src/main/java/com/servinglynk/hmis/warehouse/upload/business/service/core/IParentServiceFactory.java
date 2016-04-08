package com.servinglynk.hmis.warehouse.upload.business.service.core;

import com.servinglynk.hmis.warehouse.upload.service.IBulkUploadService;

public interface IParentServiceFactory {
	IBulkUploadService getBulkUploadService();
}
