package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2020.Error2020;

public interface BulkUploadErrorDao {
	public List<Error2020> getBulkUploadErrorByUploadId(Long bulkUploadId);
}
