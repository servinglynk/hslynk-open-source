package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.BulkUpload;

public interface BulkUploaderWorkerDao extends BaseDao{
	public List<BulkUpload> findUnProcessedUploads(String status) throws Exception;
	public List<BulkUpload> findBulkUploadByStatus(String status) throws Exception;
	public List<BulkUpload> findBulkUploadByStatusAndYear(String status,Long year) throws Exception;	
	public List<BulkUpload> findBulkUploadForCustAdmin(String status,UUID userId,String projectGroup) throws Exception;
	public List<BulkUpload> findBulkUploadFoSuperAdmin(String status) throws Exception;
	public List<BulkUpload> findBulkUploadForDevelopers(String status,UUID userId,String projectGroup) throws Exception;
	public List<BulkUpload> findBulkUploadByProjectGroupCode(String projectGroupCode) throws Exception;
	}
