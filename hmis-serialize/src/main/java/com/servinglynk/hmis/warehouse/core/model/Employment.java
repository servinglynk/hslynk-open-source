package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("employment")
public class Employment extends ClientModel{


       private UUID employmentId;

       private Integer employed;

       private Integer employmentType;

       private Integer notEmployedReason;
       
       private Date informationDate;

	public UUID getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(UUID employmentId) {
		this.employmentId = employmentId;
	}

	public Integer getEmployed() {
		return employed;
	}

	public void setEmployed(Integer employed) {
		this.employed = employed;
	}

	public Integer getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(Integer employmentType) {
		this.employmentType = employmentType;
	}

	public Integer getNotEmployedReason() {
		return notEmployedReason;
	}

	public void setNotEmployedReason(Integer notEmployedReason) {
		this.notEmployedReason = notEmployedReason;
	}

	public Date getInformationDate() {
		return informationDate;
	}

	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}
 }