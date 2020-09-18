package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class HousingUnitReservations {

	List<HousingUnitReservation> housingUnitReservations = new ArrayList<HousingUnitReservation>();

	public List<HousingUnitReservation> getHousingUnitReservations() {
		return housingUnitReservations;
	}

	public void setHousingUnitReservations(List<HousingUnitReservation> housingUnitReservations) {
		this.housingUnitReservations = housingUnitReservations;
	}
	
	public void addHousingUnitReservation(HousingUnitReservation housingUnitReservation) {
		this.housingUnitReservations.add(housingUnitReservation);
	}
}
