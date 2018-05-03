package com.servinglynk.hmis.warehouse.fileupload.service;

import com.servinglynk.hmis.warehouse.fileupload.repository.UploadHeaderDaoImpl;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadLineDaoImpl;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadMimeTypeDaoImpl;

public interface FileUploadRegistry {

	UploadHeaderDaoImpl getUploadHeaderRepository();
	UploadLineDaoImpl getUploadLineRepository();
	UploadMimeTypeDaoImpl getUploadMimeTypeRepository();
}
