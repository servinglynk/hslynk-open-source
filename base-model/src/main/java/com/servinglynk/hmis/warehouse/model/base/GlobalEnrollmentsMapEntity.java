package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentEntity;

@Entity
@Table(name = "hmis_global_enrollment_map",schema="base")
public class GlobalEnrollmentsMapEntity extends HMISModel {
	
	private UUID id;
	
	private GlobalEnrollmentEntity globalEnrollment;
	private UUID enrollmentId;
	private UUID clientId;
	private String source;
	private GenericEnrollmentEntity genericEnrollmentEntity;
	
	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "global_enrollment_id", referencedColumnName="id")
	public GlobalEnrollmentEntity getGlobalEnrollment() {
		return globalEnrollment;
	}
	public void setGlobalEnrollment(GlobalEnrollmentEntity globalEnrollment) {
		this.globalEnrollment = globalEnrollment;
	}
	
	@Column( name = "enrollment_id"  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	
	@Column( name = "client_id"  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	
	@Column(name="source")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@ManyToOne
	@JoinColumn(name = "generic_enrollment_id", referencedColumnName="id")
	public GenericEnrollmentEntity getGenericEnrollmentEntity() {
		return genericEnrollmentEntity;
	}
	public void setGenericEnrollmentEntity(GenericEnrollmentEntity genericEnrollmentEntity) {
		this.genericEnrollmentEntity = genericEnrollmentEntity;
	}
	
	
}