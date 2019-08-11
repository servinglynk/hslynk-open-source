package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("bulkupload")
public class BulkUpload extends ClientModel{
	private String fileName;
	private String fileSize;
	private Long year;
	private String username;
	private String projectGroupCode;
	private String status;
	private String description;
	private String hudVersion;
	private Long id;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the hudVersion
	 */
	public String getHudVersion() {
		return hudVersion;
	}
	/**
	 * @param hudVersion the hudVersion to set
	 */
	public void setHudVersion(String hudVersion) {
		this.hudVersion = hudVersion;
	}
	
}
