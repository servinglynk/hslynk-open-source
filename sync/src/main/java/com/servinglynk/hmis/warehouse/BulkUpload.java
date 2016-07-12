package com.servinglynk.hmis.warehouse;

import java.util.UUID;

enum Status {
	STAGING,
	LIVE,
	DELETED,
	ERROR,
	PURGED;

	public static Status getEnum(String s){
		if(STAGING.name().equals(s.trim())){
			return STAGING;
		}else if(LIVE.name().equals(s.trim())){
			return LIVE;
		}else if(DELETED.name().equals(s.trim())){
			return DELETED;
		}else if (ERROR.name().equals(s.trim())){
			return ERROR;
		}else if (PURGED.name().equals(s.trim())){
			return PURGED;
		}
		return null;
	}
}

public class BulkUpload {
	private UUID exportId;
	private String projectGroupCode;
	private Long id;
	private Long year;
	private Status status;

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

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
