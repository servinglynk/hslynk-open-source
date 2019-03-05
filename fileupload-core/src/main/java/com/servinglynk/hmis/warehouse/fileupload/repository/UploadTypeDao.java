package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadTypeEntity;

public interface UploadTypeDao {
	
	UploadTypeEntity findById(UUID uploadTypeId);

	UploadTypeEntity findByCode(String uploadType);

}