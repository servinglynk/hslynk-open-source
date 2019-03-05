package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadHeaderEntity;

public interface UploadHeaderDao {
	
     void save(UploadHeaderEntity entity);
     void updateUploadHeader(UploadHeaderEntity entity);
	 UploadHeaderEntity findById(UUID id);
	 void deleteHeaderEntity(UploadHeaderEntity headerEntity);
}