package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;

public class Residentialmoveindate extends BaseModel{
	@Column(name = "inpermanenthousing")			
	private String inpermanenthousing;
	@Column(name = "enrollmentid")			
	private UUID enrollmentid;
	@Column(name = "residentialmoveindate")
	private String residentialmoveindate;
	/**
	 * @return the inpermanenthousing
	 */
	public String getInpermanenthousing() {
		return inpermanenthousing;
	}
	/**
	 * @param inpermanenthousing the inpermanenthousing to set
	 */
	public void setInpermanenthousing(String inpermanenthousing) {
		this.inpermanenthousing = inpermanenthousing;
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
	/**
	 * @return the residentialmoveindate
	 */
	public String getResidentialmoveindate() {
		return residentialmoveindate;
	}
	/**
	 * @param residentialmoveindate the residentialmoveindate to set
	 */
	public void setResidentialmoveindate(String residentialmoveindate) {
		this.residentialmoveindate = residentialmoveindate;
	}
	
}
