package com.servinglynk.hmis.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonRootName("housingUnitOccupant")
@JsonInclude(value = Include.NON_NULL)
public class HousingUnitOccupant {

	private UUID id;
	private UUID clientId;
	private UUID dedupClientId;
	private UUID enrollmentId;
	private Date startDate;
	private Date endDate;
	private Date checkoutDate;
	private Boolean isActive;
	private HousingUnit housingUnit;
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
	public HousingUnit getHousingUnit() {
		if(housingUnit==null) housingUnit =  new HousingUnit();
		return housingUnit;
	}
	public void setHousingUnit(HousingUnit housingUnit) {
		this.housingUnit = housingUnit;
	}
	public UUID getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
}