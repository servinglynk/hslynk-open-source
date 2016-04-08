package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Lastgradecompleted extends BaseModel {

	@Column(name = "lastgradecompleted")
	public String lastgradecompleted;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	public String getLastgradecompleted() {
		return lastgradecompleted;
	}
	public void setLastgradecompleted(String lastgradecompleted) {
		this.lastgradecompleted = lastgradecompleted;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
}
