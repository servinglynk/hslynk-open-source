package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadHeaderEntity;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadLineEntity;

public interface UploadLineDao {

	void save(UploadLineEntity object);
	UploadLineEntity findById(UUID id);
	List<UploadLineEntity> findByUploadHeader(UploadHeaderEntity headerEntity);
	void deleteUploadLine(UploadLineEntity uploadLine);
}