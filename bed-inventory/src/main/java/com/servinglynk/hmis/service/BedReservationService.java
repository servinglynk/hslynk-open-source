package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.BedUnitReservation;
import com.servinglynk.hmis.model.BedUnitReservations;

public interface BedReservationService {
	BedUnitReservation createBedUnitReservation(BedUnitReservation bedUnitReservation);
	void updateBedUnitReservation(BedUnitReservation bedUnitReservation);
	void deleteBedUnitReservation(UUID bedUnitReservationId);
	BedUnitReservation getBedUnitReservation(UUID bedUnitReservationId);
	BedUnitReservations getBedUnitReservations(UUID bedunitid, Pageable pageable);
}