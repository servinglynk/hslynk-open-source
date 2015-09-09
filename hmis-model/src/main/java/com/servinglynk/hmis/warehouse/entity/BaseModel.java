package com.servinglynk.hmis.warehouse.entity;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;



@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseModel implements Entity{
	@Column(name = "created_at")
	protected Date createdAt = new java.util.Date();
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "modified_at")
	protected Date modifiedAt;	
	@Column(name = "modified_by")
	protected String modifiedBy;
/*	protected abstract void setId(Long id);
	public abstract Long getId();*/
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}	
	public String getModifiedBy() {
		return modifiedBy;
	}	
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public  String getNewGuid() {
		return UUID.randomUUID().toString().toUpperCase();
	}
	
}