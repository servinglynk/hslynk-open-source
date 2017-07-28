package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2017.Error2016;

public interface BulkUploadErrorDao {
	public List<Error2016> getBulkUploadErrorByUploadId(Long bulkUploadId);
}
