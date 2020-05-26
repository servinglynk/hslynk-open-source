package com.servinglynk.hmis.warehouse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UploadHeader  {
	
	private UUID uploadFileId;
	private Long uploadBy;
	private String uploadType;
	private Long noOfFiles;
	private Long totalSize;
	private String documentName;
	private String documentCategory;
	private String documentInfo;
	private String bucketName;
	private String uploadFolder;
	
	List<UploadLine> uploads = new ArrayList<>();

	private Parameters parameters=new Parameters();
	
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	
	public String getUploadType() {
		return uploadType;
	}
	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public Long getUploadBy() {
		return uploadBy;
	}
	public void setUploadBy(Long uploadBy) {
		this.uploadBy = uploadBy;
	}
	public UUID getUploadFileId() {
		return uploadFileId;
	}
	public void setUploadFileId(UUID uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
	public Long getNoOfFiles() {
		return noOfFiles;
	}
	public void setNoOfFiles(Long noOfFiles) {
		this.noOfFiles = noOfFiles;
	}
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentCategory() {
		return documentCategory;
	}
	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}
	public String getDocumentInfo() {
		return documentInfo;
	}
	public void setDocumentInfo(String documentInfo) {
		this.documentInfo = documentInfo;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public List<UploadLine> getUploads() {
		return uploads;
	}
	public void setUploads(List<UploadLine> uploads) {
		this.uploads = uploads;
	}
	public String getUploadFolder() {
		return uploadFolder;
	}
	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}
}