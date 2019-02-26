package com.servinglynk.hmis.warehouse.fileupload.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;
@MappedSuperclass
public class BaseEntity {

/*	@Column(name = "UNIQUE_ID")
	private String uniqueId;


	@Version
	@Column(name = "VERSION")
	private Long version;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_AT")
	private Date createdTs;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_AT")
	private Date updatedTs;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}


	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	@PrePersist
	public void init(){
		this.uniqueId = UUID.randomUUID().toString().toUpperCase();
	}
*/
}
