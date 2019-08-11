package com.servinglynk.hmis.warehouse.fileupload.service;

import com.servinglynk.hmis.warehouse.fileupload.repository.UploadHeaderDao;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadLineDao;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadMimeTypeDao;
import com.servinglynk.hmis.warehouse.fileupload.repository.UploadTypeDao;

public interface FileUploadDaoFactory {

	UploadHeaderDao getUploadHeaderDao();
	UploadLineDao getUploadLineDao();
	UploadTypeDao getUploadTypeDao();
	UploadMimeTypeDao getUploadMimeTypeDao();
}
