package com.servinglynk.hmis.warehouse.model.base;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "client_tracker", catalog = "hmis", schema = "base")
public class ClientTracker {

	private UUID id;
	private UUID clientId;
	private String serviceName;
	private String userName;
	private LocalDateTime operationAt;
	private String operation;
	private boolean deletedFlag;
	private String projectGroup;

	@Id
	@Column(name = "id", nullable = false)
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name = "client_id", nullable = false)
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	public UUID getClientId() {
		return clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	@Column(name="service_name")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="operation_at")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getOperationAt() {
		return operationAt;
	}

	public void setOperationAt(LocalDateTime operationAt) {
		this.operationAt = operationAt;
	}

	@Column(name="operation")
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name="deleted_falg")
	public boolean getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	@Column(name="project_group")
	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}
}