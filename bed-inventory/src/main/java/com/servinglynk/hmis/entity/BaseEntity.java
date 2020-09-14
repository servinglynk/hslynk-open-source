package com.servinglynk.hmis.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
abstract
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@Column(name = "deleted")
	private boolean deleted;
	
	@CreatedDate
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic(optional = true)
	@Column(name = "date_created")
	protected LocalDateTime dateCreated = LocalDateTime.now();
	
	@LastModifiedDate
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic(optional = true)
	@Column(name = "date_updated")
	protected LocalDateTime dateUpdated = LocalDateTime.now();
	@Column(name = "PROJECT_GROUP_CODE")
	private String projectGroupCode;
	

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getDateCreated() {
		return this.dateCreated;
	}
	public void setDateCreated(final LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(final LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	
	
}
