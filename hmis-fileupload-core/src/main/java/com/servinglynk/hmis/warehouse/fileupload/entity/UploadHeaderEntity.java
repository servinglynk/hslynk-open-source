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
@Table(name="HMIS_UPLOAD_HEADER",schema="fileupload")
public class UploadHeaderEntity extends BaseEntity{
	
	@Id
	@Column(name="ID")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "UPLOAD_TYPE_ID")
	private UploadTypeEntity uploadType;
	
	@Column(name = "NO_OF_FILES")
	private Long noOfFiles;
	
	@Column(name = "TOTAL_SIZE")
	private Long totalSize;
	
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
}