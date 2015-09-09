package com.servinglynk.hmis.warehouse.entity;

import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_REJECTED;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * Model class representing a verification.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_verification")
public class VerificationEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "verification_token")
	private String token;

	@Column(name = "verification_type")
	private String type;

	@Column(name = "status")
	private String status;


	public UUID getId() {
		return this.id;
	}

	protected void setId(UUID id) {
		this.id = id;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isStatusAcceptedOrRejected() {
		if (VERIFICATION_STATUS_ACCEPTED.equalsIgnoreCase(status) || VERIFICATION_STATUS_REJECTED.equalsIgnoreCase(status)) {
			return true;
		}
		return false;
	}

	public boolean isStatusAccepted() {
		if (VERIFICATION_STATUS_ACCEPTED.equalsIgnoreCase(status)) {
			return true;
		}
		return false;
	}

	public boolean isStatusRejected() {
		if (VERIFICATION_STATUS_REJECTED.equalsIgnoreCase(status)) {
			return true;
		}
		return false;
	}
}
