package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.HmisBulkUpload;

public interface BulkUploaderWorkerDao extends ParentDao{
	public List<HmisBulkUpload> findUnProcessedUploads(String status) throws Exception;
	public List<HmisBulkUpload> findBulkUploadByStatus(String status) throws Exception;	
	public List<HmisBulkUpload> findBulkUploadForCustAdmin(String status,UUID userId,String projectGroup) throws Exception;
	public List<HmisBulkUpload> findBulkUploadFoSuperAdmin(String status) throws Exception;
	public List<HmisBulkUpload> findBulkUploadForDevelopers(String status,UUID userId,String projectGroup) throws Exception;
	public List<HmisBulkUpload> findBulkUploadByProjectGroupCode(String projectGroupCode) throws Exception;
	}
