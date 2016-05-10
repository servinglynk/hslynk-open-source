package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;
@Entity
public class Employment extends BaseModel{
	
	@Column(name="information_date")
	public Timestamp information_date;
	@Column(name="employed")		
	public Integer employed;
	@Column(name="employment_type")
	public Integer employment_type;
	@Column(name="not_employed_reason")
	public Integer not_employed_reason;
	@Column(name="enrollmentid")
	public UUID enrollmentid;
	@Column(name="id")
	public UUID id;
	public Timestamp getInformation_date() {
		return information_date;
	}
	public void setInformation_date(Timestamp information_date) {
		this.information_date = information_date;
	}
	public Integer getEmployed() {
		return employed;
	}
	public void setEmployed(Integer employed) {
		this.employed = employed;
	}
	public Integer getEmployment_type() {
		return employment_type;
	}
	public void setEmployment_type(Integer employment_type) {
		this.employment_type = employment_type;
	}
	public Integer getNot_employed_reason() {
		return not_employed_reason;
	}
	public void setNot_employed_reason(Integer not_employed_reason) {
		this.not_employed_reason = not_employed_reason;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
		
}
