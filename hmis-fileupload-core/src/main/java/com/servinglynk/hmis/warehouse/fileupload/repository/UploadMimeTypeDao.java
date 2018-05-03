package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.List;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadMimeTypeEntity;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadTypeEntity;

public interface UploadMimeTypeDao {
	
	void save(UploadMimeTypeEntity object);
	
	List<UploadMimeTypeEntity> findByUploadType(UploadTypeEntity uploadType);

}