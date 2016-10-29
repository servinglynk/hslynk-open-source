package com.servinglynk.hmis.warehouse.model.v2016;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;
@Entity
public class Residentialmoveindate extends BaseModel{
	@Column(name = "inpermanenthousing")			
	public Integer inpermanenthousing;
	@Column(name = "enrollmentid")			
	public UUID enrollmentid;
	@Column(name = "id")			
	public UUID id;
	@Column(name = "residentialmoveindate")
	public Date residentialmoveindate;
	public Integer getInpermanenthousing() {
		return inpermanenthousing;
	}
	public void setInpermanenthousing(Integer inpermanenthousing) {
		this.inpermanenthousing = inpermanenthousing;
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
	public Date getResidentialmoveindate() {
		return residentialmoveindate;
	}
	public void setResidentialmoveindate(Date residentialmoveindate) {
		this.residentialmoveindate = residentialmoveindate;
	}
	
	
}
