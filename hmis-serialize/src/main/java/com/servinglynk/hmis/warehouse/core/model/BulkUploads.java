package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class BulkUploads extends PaginatedModel  {
    private List<BulkUpload> bulkUploads = new ArrayList<BulkUpload>();

	public List<BulkUpload> getBulkUploads() {
		return bulkUploads;
	}

	public void setBulkUploads(List<BulkUpload> bulkUploads) {
		this.bulkUploads = bulkUploads;
	}
	public void addBulkUpload(BulkUpload upload) {
		bulkUploads.add(upload);
	}
    
}
