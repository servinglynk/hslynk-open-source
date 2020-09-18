package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.HousingUnitReservation;
import com.servinglynk.hmis.model.HousingUnitReservations;

public interface HousingUnitReservationService {
	HousingUnitReservation createHousingUnitReservation(HousingUnitReservation housingUnitReservation);
	void updateHousingUnitReservation(HousingUnitReservation housingUnitReservation);
	void deleteHousingUnitReservation(UUID housingUnitReservationId);
	HousingUnitReservation getHousingUnitReservation(UUID housingUnitReservationId);
	HousingUnitReservations getHousingUnitReservations(Pageable pageable);
}