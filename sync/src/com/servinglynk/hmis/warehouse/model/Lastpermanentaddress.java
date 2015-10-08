package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Lastpermanentaddress extends BaseModel{
	@Column(name = "addressdataquality")		
	private String addressdataquality;
	@Column(name = "lastpermanentcity")
	private String lastpermanentcity;
	@Column(name = "lastpermanentstate")
	private String lastpermanentstate;
	@Column(name = "lastpermanentstreet")
	private String lastpermanentstreet;
	@Column(name = "lastpermanentzip")
	private String lastpermanentzip;
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	public String getAddressdataquality() {
		return addressdataquality;
	}
	public void setAddressdataquality(String addressdataquality) {
		this.addressdataquality = addressdataquality;
	}
	public String getLastpermanentcity() {
		return lastpermanentcity;
	}
	public void setLastpermanentcity(String lastpermanentcity) {
		this.lastpermanentcity = lastpermanentcity;
	}
	public String getLastpermanentstate() {
		return lastpermanentstate;
	}
	public void setLastpermanentstate(String lastpermanentstate) {
		this.lastpermanentstate = lastpermanentstate;
	}
	public String getLastpermanentstreet() {
		return lastpermanentstreet;
	}
	public void setLastpermanentstreet(String lastpermanentstreet) {
		this.lastpermanentstreet = lastpermanentstreet;
	}
	public String getLastpermanentzip() {
		return lastpermanentzip;
	}
	public void setLastpermanentzip(String lastpermanentzip) {
		this.lastpermanentzip = lastpermanentzip;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

}
