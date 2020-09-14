package com.servinglynk.hmis.model;

import java.util.Date;
import java.util.UUID;

public class BedUnitReservation {

	private UUID id;
	private UUID reservedCleintId;
	private UUID reservedHouseholdId;
	private Date reservationStateDate; 
	private Date reservationEndDateDate;
	
	private BedUnit bedUnit;
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
	public Date getReservationStateDate() {
		return reservationStateDate;
	}
	public void setReservationStateDate(Date reservationStateDate) {
		this.reservationStateDate = reservationStateDate;
	}
	public Date getReservationEndDateDate() {
		return reservationEndDateDate;
	}
	public void setReservationEndDateDate(Date reservationEndDateDate) {
		this.reservationEndDateDate = reservationEndDateDate;
	}
	public BedUnit getBedUnit() {
		return bedUnit;
	}
	public void setBedUnit(BedUnit bedUnit) {
		this.bedUnit = bedUnit;
	}
}