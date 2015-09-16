package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;

@Transactional(propagation = Propagation.REQUIRED) 
public interface BulkUploaderDao {

	BulkUpload performBulkUpload(BulkUpload upload);
	public void deleteStagingByExportId(UUID exportId);
	public void deleteLiveByExportId(UUID exportId);
	public void moveFromStagingToLive(ExportDomain domain);
}
