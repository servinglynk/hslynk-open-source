package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.v2014.BulkUpload;
import com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity;

@Transactional(propagation = Propagation.REQUIRED) 
public interface BulkUploaderDao {

	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity);
	public void deleteStagingByExportId(UUID exportId);
	public void deleteLiveByExportId(UUID exportId);
	public void deleteLiveByProjectGroupCode(String projectGroupCode);
	public void moveFromStagingToLive(BulkUpload upload);
	public void undoDeleteLiveByExportId(UUID exportId);
}
