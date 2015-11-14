package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("employment")
public class Employment extends ClientModel{


       private UUID employmentId;

       private String employed;

       private String employmentType;

       private String notEmployedReason;
       
       private Date informationDate;

	public UUID getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(UUID employmentId) {
		this.employmentId = employmentId;
	}

	public String getEmployed() {
		return employed;
	}

	public void setEmployed(String employed) {
		this.employed = employed;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getNotEmployedReason() {
		return notEmployedReason;
	}

	public void setNotEmployedReason(String notEmployedReason) {
		this.notEmployedReason = notEmployedReason;
	}

	public Date getInformationDate() {
		return informationDate;
	}

	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}
 }