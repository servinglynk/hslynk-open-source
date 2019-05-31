package com.servinglynk.hmis.warehouse.fileupload.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="HMIS_UPLOAD_LINE",schema="fileupload")
public class UploadLineEntity extends BaseEntity{
	
	@Id
	@Column(name="ID")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name = "CONTENT_TYPE")
	private String contentType;
	
	@Column(name = "FILE_SIZE")
	private Long fileSize;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "UPLOAD_LOCATION")
	private String uploadLocation;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "UPLOAD_HEADER_ID")
	private UploadHeaderEntity uploadHeader;
	
	@Column(name="file_original_name")
	private String fileOriginalName;
	
	@Column(name = "ADDITIONAL_INFO")
	private String additionalInfo;
	
	@Column(name = "BUCKET_NAME")
	private String bucketName;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
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

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public UploadHeaderEntity getUploadHeader() {
		return uploadHeader;
	}

	public void setUploadHeader(UploadHeaderEntity uploadHeader) {
		this.uploadHeader = uploadHeader;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getFileOriginalName() {
		return fileOriginalName;
	}

	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}

}