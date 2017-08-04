package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
@JsonRootName("bulkUploadActivities")
public class BulkUploadActivities extends PaginatedModel{

	public List<BulkUploadActivity> bulkUploadActivities = new ArrayList<BulkUploadActivity>();
	@JsonProperty("bulkUploadActivities")
	public List<BulkUploadActivity> getBulkUploadActivities() {
		return bulkUploadActivities;
	}

	public void setBulkUploadActivities(
			List<BulkUploadActivity> bulkUploadActivities) {
		this.bulkUploadActivities = bulkUploadActivities;
	}
}
