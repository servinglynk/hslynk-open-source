package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.base.HmisBulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

@Transactional(propagation = Propagation.REQUIRED) 
public interface BulkUploaderDao {

	public HmisBulkUpload performBulkUpload(HmisBulkUpload upload, ProjectGroupEntity projectGroupdEntity);
	public void deleteStagingByExportId(UUID exportId);
	public void deleteLiveByExportId(UUID exportId);
	public void deleteLiveByProjectGroupCode(String projectGroupCode);
	public void moveFromStagingToLive(HmisBulkUpload upload);
	public void undoDeleteLiveByExportId(UUID exportId);
}
