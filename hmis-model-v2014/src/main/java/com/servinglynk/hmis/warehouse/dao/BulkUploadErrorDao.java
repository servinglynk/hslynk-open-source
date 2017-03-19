package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

public interface BulkUploadErrorDao {
	public List<Error2014> getBulkUploadErrorByUploadId(Long bulkUploadId);
}
