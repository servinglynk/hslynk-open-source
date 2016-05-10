package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Exit extends BaseModel {

	@Column(name = "destination")
	public String destination;
	@Column(name = "exitdate")
	public Timestamp exitdate;
	@Column(name = "otherdestination")
	public String otherdestination;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the exitdate
	 */
	public Timestamp getExitdate() {
		return exitdate;
	}

	/**
	 * @param exitdate
	 *            the exitdate to set
	 */
	public void setExitdate(Timestamp exitdate) {
		this.exitdate = exitdate;
	}

	/**
	 * @return the otherdestination
	 */
	public String getOtherdestination() {
		return otherdestination;
	}

	/**
	 * @param otherdestination
	 *            the otherdestination to set
	 */
	public void setOtherdestination(String otherdestination) {
		this.otherdestination = otherdestination;
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

}
