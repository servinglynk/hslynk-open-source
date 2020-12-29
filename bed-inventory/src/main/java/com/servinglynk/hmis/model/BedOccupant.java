package com.servinglynk.hmis.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("bedOccupant")
@JsonInclude(value = Include.NON_NULL)
public class BedOccupant {
	private UUID id;
	private UUID clientId;
	private UUID dedupClientId;
	private UUID enrollmentId;
	private Date startDate;
	private Date endDate;
	private Date checkOutDate;
	private String enrollmentType;
	private Boolean isActive;
	private BedUnit bedUnit;
	private Client client;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public UUID getDedupClientId() {
		return dedupClientId;
	}
	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public BedUnit getBedUnit() {
		if(bedUnit == null) bedUnit = new BedUnit();
		return bedUnit;
	}
	public void setBedUnit(BedUnit bedUnit) {
		this.bedUnit = bedUnit;
	}
	public UUID getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getEnrollmentType() {
		return enrollmentType;
	}
	public void setEnrollmentType(String enrollmentType) {
		this.enrollmentType = enrollmentType;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}