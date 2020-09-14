package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class BedUnitReservations {

	List<BedUnitReservation> bedUnitReservations = new ArrayList<BedUnitReservation>();

	public List<BedUnitReservation> getBedUnitReservations() {
		return bedUnitReservations;
	}

	public void setBedUnitReservations(List<BedUnitReservation> bedUnitReservations) {
		this.bedUnitReservations = bedUnitReservations;
	}
	
	public void addBedUnitReservation(BedUnitReservation bedUnitReservation) {
		this.bedUnitReservations.add(bedUnitReservation);
	}
}
