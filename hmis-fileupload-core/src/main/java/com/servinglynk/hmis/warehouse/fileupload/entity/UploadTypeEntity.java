package com.servinglynk.hmis.warehouse.fileupload.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="HMIS_UPLOAD_TYPE",schema="fileupload")
public class UploadTypeEntity extends BaseEntity  {
	@Id
	@Column(name="ID")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name = "MAX_SIZE_IN_KB")
	private Long maxSizeInKb;
	
	@Column(name = "MAX_FILES")
	private Integer maxFiles;
	
	@Column(name = "DESTINATION_TYPE")
	private String storageType;
	
	@Column(name = "DESCRIPTION")
	private String uploadTypeName;
	
	@Column(name = "UPLOAD_LOCATION")
	private String uploadLocation;
	
	@Column(name="UPLOAD_TYPE_CODE")
	private String uploadTypeCode;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getMaxSizeInKb() {
		return maxSizeInKb;
	}

	public void setMaxSizeInKb(Long maxSizeInKb) {
		this.maxSizeInKb = maxSizeInKb;
	}

	public Integer getMaxFiles() {
		return maxFiles;
	}

	public void setMaxFiles(Integer maxFiles) {
		this.maxFiles = maxFiles;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getUploadTypeName() {
		return uploadTypeName;
	}

	public void setUploadTypeName(String uploadTypeName) {
		this.uploadTypeName = uploadTypeName;
	}

	public String getUploadLocation() {
		return uploadLocation;
	}

	public void setUploadLocation(String uploadLocation) {
		this.uploadLocation = uploadLocation;
	}

	public String getUploadTypeCode() {
		return uploadTypeCode;
	}

	public void setUploadTypeCode(String uploadTypeCode) {
		this.uploadTypeCode = uploadTypeCode;
	}
}