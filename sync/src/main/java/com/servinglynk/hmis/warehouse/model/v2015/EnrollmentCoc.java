package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class EnrollmentCoc extends BaseModel {

	@Column(name = "id")
	public UUID id;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "client_code")
	public String client_code;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public String getClient_code() {
		return client_code;
	}
	public void setClient_code(String client_code) {
		this.client_code = client_code;
	}
		
}
