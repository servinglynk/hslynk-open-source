package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;

@Transactional(propagation = Propagation.REQUIRED) 
public interface BulkUploaderDao {

	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity);
	public void deleteStagingByExportId(UUID exportId);
	public void deleteLiveByExportId(UUID exportId);
	public void deleteLiveByProjectGroupCode(String projectGroupCode);
	public void moveFromStagingToLive(BulkUpload upload);
}
