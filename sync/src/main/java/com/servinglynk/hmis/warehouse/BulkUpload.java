package com.servinglynk.hmis.warehouse;

import java.util.UUID;

public class BulkUpload {
	private UUID exportId;
	private String projectGroupCode;
	private Long id;

	public UUID getExportId() {
		return exportId;
	}

	public void setExportId(UUID exportId) {
		this.exportId = exportId;
	}

	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
