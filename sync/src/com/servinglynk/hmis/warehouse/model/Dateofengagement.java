package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Dateofengagement extends BaseModel{
	@Column(name="dateofengagement")
	private String dateofengagement;
	@Column(name="enrollmentid")
	private UUID enrollmentid;
	/**
	 * @return the dateofengagement
	 */
	public String getDateofengagement() {
		return dateofengagement;
	}
	/**
	 * @param dateofengagement the dateofengagement to set
	 */
	public void setDateofengagement(String dateofengagement) {
		this.dateofengagement = dateofengagement;
	}
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
}
