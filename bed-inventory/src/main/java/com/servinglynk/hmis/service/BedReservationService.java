package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.BedUnitReservation;
import com.servinglynk.hmis.model.BedUnitReservations;

public interface BedReservationService {
	BedUnitReservation createBedUnitReservation(BedUnitReservation bedUnitReservation) throws Exception ;
	void updateBedUnitReservation(BedUnitReservation bedUnitReservation) throws Exception ;
	void deleteBedUnitReservation(UUID bedUnitReservationId);
	BedUnitReservation getBedUnitReservation(UUID bedUnitReservationId);
	BedUnitReservations getBedUnitReservations(UUID bedunitid, Date fromdate, Date todate, Pageable pageable);
	BedUnitReservations getClientBedUnitReservations(UUID dedupClientId, Date fromdate, Date todate, Pageable pageable);
}