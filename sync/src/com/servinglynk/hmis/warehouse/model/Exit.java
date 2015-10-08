package com.servinglynk.hmis.warehouse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Exit extends BaseModel {

	@Column(name = "destination")
	private String destination;
	@Column(name = "exitdate")
	private Date exitdate;
	@Column(name = "otherdestination")
	private String otherdestination;
	@Column(name = "enrollmentid")
	private String enrollmentid;

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
	public Date getExitdate() {
		return exitdate;
	}

	/**
	 * @param exitdate
	 *            the exitdate to set
	 */
	public void setExitdate(Date exitdate) {
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
	public String getEnrollmentid() {
		return enrollmentid;
	}

	/**
	 * @param enrollmentid
	 *            the enrollmentid to set
	 */
	public void setEnrollmentid(String enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

}
