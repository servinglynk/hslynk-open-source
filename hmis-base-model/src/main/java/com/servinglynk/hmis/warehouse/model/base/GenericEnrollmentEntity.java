package com.servinglynk.hmis.warehouse.model.base;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "hmis_generic_enrollment",schema="base")
public class GenericEnrollmentEntity extends HMISModel{

	private UUID id;
	private UUID globalEnrollmentId;
	private UUID globalProjectId;
	private Boolean active;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private UUID globalHouseHoldId;
	
	@Id
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name="global_enrollment_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getGlobalEnrollmentId() {
		return globalEnrollmentId;
	}
	public void setGlobalEnrollmentId(UUID globalEnrollmentId) {
		this.globalEnrollmentId = globalEnrollmentId;
	}
	
	@Column(name="global_project_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getGlobalProjectId() {
		return globalProjectId;
	}
	public void setGlobalProjectId(UUID globalProjectId) {
		this.globalProjectId = globalProjectId;
	}
	
	@Column(name="active")
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Column(name="start_time")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	@Column(name="end_time")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="global_household_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getGlobalHouseHoldId() {
		return globalHouseHoldId;
	}
	public void setGlobalHouseHoldId(UUID globalHouseHoldId) {
		this.globalHouseHoldId = globalHouseHoldId;
	}	
}