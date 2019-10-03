package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;
@JsonRootName("bulkUploadErrors")
public class BulkUploadErrors extends PaginatedModel {
	
	public List<BulkUploadError> bulkUploadErrors = new ArrayList<BulkUploadError>();
	
	@JsonProperty("bulkUploadErrors")
	public List<BulkUploadError> getBulkUploadErrors() {
		return bulkUploadErrors;
	}

	public void setBulkUploadErrors(List<BulkUploadError> bulkUploadErrors) {
		this.bulkUploadErrors = bulkUploadErrors;
	}
	

}
