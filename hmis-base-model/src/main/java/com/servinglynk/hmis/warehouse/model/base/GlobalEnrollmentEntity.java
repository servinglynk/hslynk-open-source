package com.servinglynk.hmis.warehouse.model.base;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hmis_global_enrollment",schema="base")
public class GlobalEnrollmentEntity extends HMISModel {

	
	private UUID id;
	
	private java.util.UUID dedupClientId;
	
	private List<GlobalEnrollmentsMapEntity> enrollments;

	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	
	@Column( name = "dedup_client_id"  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getDedupClientId() {
		return this.dedupClientId;

	}

	public void setDedupClientId(final java.util.UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}

	@OneToMany(mappedBy = "globalEnrollment")
	public List<GlobalEnrollmentsMapEntity> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<GlobalEnrollmentsMapEntity> enrollments) {
		this.enrollments = enrollments;
	}	
}