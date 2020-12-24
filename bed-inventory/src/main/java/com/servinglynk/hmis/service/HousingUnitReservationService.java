package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.HousingUnitReservation;
import com.servinglynk.hmis.model.HousingUnitReservations;

public interface HousingUnitReservationService {
	HousingUnitReservation createHousingUnitReservation(HousingUnitReservation housingUnitReservation) throws Exception;
	void updateHousingUnitReservation(HousingUnitReservation housingUnitReservation) throws Exception;
	void deleteHousingUnitReservation(UUID housingUnitReservationId);
	HousingUnitReservation getHousingUnitReservation(UUID housingUnitReservationId);
	HousingUnitReservations getHousingUnitReservations(UUID housingunitid, Pageable pageable);
	HousingUnitReservations getClientHousingUnitReservations(UUID dedupClientId, Date fromdate, Date todate,
			Pageable pageable);
}