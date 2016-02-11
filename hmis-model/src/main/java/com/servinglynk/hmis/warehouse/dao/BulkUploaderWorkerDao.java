package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.BulkUpload;

public interface BulkUploaderWorkerDao extends ParentDao{
	public List<BulkUpload> findUnProcessedUploads(String status) throws Exception;
	public List<BulkUpload> findBulkUploadByStatus(String status) throws Exception;	
	public List<BulkUpload> findBulkUploadForCustAdmin(String status,UUID userId,String projectGroup) throws Exception;
	public List<BulkUpload> findBulkUploadFoSuperAdmin(String status) throws Exception;
	public List<BulkUpload> findBulkUploadForDevelopers(String status,UUID userId,String projectGroup) throws Exception;
	public List<BulkUpload> findBulkUploadByProjectGroupCode(String projectGroupCode) throws Exception;
	}
