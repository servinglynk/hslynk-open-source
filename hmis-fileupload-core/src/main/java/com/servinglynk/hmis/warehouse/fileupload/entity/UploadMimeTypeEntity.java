package com.servinglynk.hmis.warehouse.fileupload.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HMIS_UPLOAD_MIMETYPE",schema="fileupload")
public class UploadMimeTypeEntity extends BaseEntity{
	
	@Id
	@Column(name="ID")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "UPLOAD_TYPE_ID")
	private UploadTypeEntity uploadType;
	
	@Column(name = "MIME_TYPE")
	private String mimeType;
	
	@Column(name = "MAX_SIZE_IN_KB")
	private Long maxSizeInKb;
	
	@Column(name = "DISPLAY_NAME")
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UploadTypeEntity getUploadType() {
		return uploadType;
	}

	public void setUploadType(UploadTypeEntity uploadType) {
		this.uploadType = uploadType;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Long getMaxSizeInKb() {
		return maxSizeInKb;
	}

	public void setMaxSizeInKb(Long maxSizeInKb) {
		this.maxSizeInKb = maxSizeInKb;
	}

}
