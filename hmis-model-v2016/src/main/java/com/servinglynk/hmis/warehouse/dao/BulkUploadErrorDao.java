package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2016.Error2015;

public interface BulkUploadErrorDao {
	public List<Error2015> getBulkUploadErrorByUploadId(Long bulkUploadId);
}
