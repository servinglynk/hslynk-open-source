package com.servinglynk.hmis.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonRootName("housingUnitReservation")
@JsonInclude(value = Include.NON_NULL)
public class HousingUnitReservation {

	private UUID id;
	private UUID reservedCleintId;
	private UUID reservedHouseholdId;
	private Date startDate; 
	private Date endDate;
	private Client client;
	
	private HousingUnit housingUnit;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getReservedCleintId() {
		return reservedCleintId;
	}
	public void setReservedCleintId(UUID reservedCleintId) {
		this.reservedCleintId = reservedCleintId;
	}
	public UUID getReservedHouseholdId() {
		return reservedHouseholdId;
	}
	public void setReservedHouseholdId(UUID reservedHouseholdId) {
		this.reservedHouseholdId = reservedHouseholdId;
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
	public HousingUnit getHousingUnit() {
		if(housingUnit==null) housingUnit = new HousingUnit();
		return housingUnit;
	}
	public void setHousingUnit(HousingUnit housingUnit) {
		this.housingUnit = housingUnit;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}