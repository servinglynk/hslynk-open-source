package com.servinglynk.hmis.warehouse.model.v2016;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;


@Entity
public class Contact extends BaseModel{

	
	@Column( name = "contact_date")
	private LocalDateTime contact_date;
	
	@Column( name = "contact_location")
	private Integer contact_location;
	
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	
	@Column( name = "id")
	private java.util.UUID id;

	public LocalDateTime getContact_date() {
		return contact_date;
	}

	public void setContact_date(LocalDateTime contact_date) {
		this.contact_date = contact_date;
	}

	public Integer getContact_location() {
		return contact_location;
	}

	public void setContact_location(Integer contact_location) {
		this.contact_location = contact_location;
	}

	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

		
   
}
