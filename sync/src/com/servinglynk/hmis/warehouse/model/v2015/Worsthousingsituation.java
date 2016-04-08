package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Worsthousingsituation extends BaseModel {
	@Column(name = "enrollmentid")			
	public UUID enrollmentid;
	@Column(name = "worsthousingsituation")
	public String worsthousingsituation;
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
	 * @return the worsthousingsituation
	 */
	public String getWorsthousingsituation() {
		return worsthousingsituation;
	}
	/**
	 * @param worsthousingsituation the worsthousingsituation to set
	 */
	public void setWorsthousingsituation(String worsthousingsituation) {
		this.worsthousingsituation = worsthousingsituation;
	}
	
}
