package com.servinglynk.hmis.warehouse.model.v2016;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class HealthStatus extends BaseModel {

	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "health_category")
	public String health_category;
	@Column(name = "health_status")
	public String health_status;
	@Column(name = "due_date")
	public Timestamp due_date;
	@Column(name = "id")
	public UUID id;
	@Column(name="datacollectionstage")
	public String datacollectionstage;
	@Column(name="information_date")
	private Date information_date;
	

	/**
	 * @return the datacollectionstage
	 */
	public String getDatacollectionstage() {
		return datacollectionstage;
	}

	/**
	 * @param datacollectionstage the datacollectionstage to set
	 */
	public void setDatacollectionstage(String datacollectionstage) {
		this.datacollectionstage = datacollectionstage;
	}

	/**
	 * @return the information_date
	 */
	public Date getInformation_date() {
		return information_date;
	}

	/**
	 * @param information_date the information_date to set
	 */
	public void setInformation_date(Date information_date) {
		this.information_date = information_date;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	/**
	 * @param enrollmentid
	 *            the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	/**
	 * @return the health_category
	 */
	public String getHealth_category() {
		return health_category;
	}

	/**
	 * @param health_category
	 *            the health_category to set
	 */
	public void setHealth_category(String health_category) {
		this.health_category = health_category;
	}

	/**
	 * @return the health_status
	 */
	public String getHealth_status() {
		return health_status;
	}

	/**
	 * @param health_status
	 *            the health_status to set
	 */
	public void setHealth_status(String health_status) {
		this.health_status = health_status;
	}

	/**
	 * @return the due_date
	 */
	public Timestamp getDue_date() {
		return due_date;
	}

	/**
	 * @param due_date
	 *            the due_date to set
	 */
	public void setDue_date(Timestamp due_date) {
		this.due_date = due_date;
	}

}
