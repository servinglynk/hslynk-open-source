package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Contact extends BaseModel{

	
	@Column( name = "contact_date")
	private Timestamp contactDate;
	
	@Column( name = "contact_location")
	private Integer contactLocation;
	
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	
	@Column( name = "id")
	private java.util.UUID id;

	public Timestamp getContactDate() {
		return contactDate;
	}

	public void setContactDate(Timestamp contactDate) {
		this.contactDate = contactDate;
	}

	public Integer getContactLocation() {
		return contactLocation;
	}

	public void setContactLocation(Integer contactLocation) {
		this.contactLocation = contactLocation;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	
	
   
}
