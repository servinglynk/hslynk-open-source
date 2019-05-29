package com.servinglynk.hmis.warehouse.model;

public class UploadLine {
	
	private String id;
	private String contentType;
	private Long fileSize;
	private String fileName;
	private String uploadLocation;
	private String uploadHeaderId;
	private String documentName;
	private String documentCategory;
	private String documentInfo;
	private Parameters additionalInfo;
	
	public Parameters getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Parameters additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	private String ownerId;
	
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadLocation() {
		return uploadLocation;
	}
	public void setUploadLocation(String uploadLocation) {
		this.uploadLocation = uploadLocation;
	}
	public String getUploadHeaderId() {
		return uploadHeaderId;
	}
	public void setUploadHeaderId(String uploadHeaderId) {
		this.uploadHeaderId = uploadHeaderId;
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
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

}
