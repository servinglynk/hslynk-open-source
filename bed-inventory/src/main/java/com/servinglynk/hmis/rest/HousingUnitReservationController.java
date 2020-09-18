package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.HousingUnitReservation;
import com.servinglynk.hmis.model.HousingUnitReservations;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/housingunits/{housingunitid}/reservations")
public class HousingUnitReservationController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitReservation createHousingUnitReservation(HousingUnitReservation housingUnitReservation) {
		return serviceFactory.getHousingUnitReservationService().createHousingUnitReservation(housingUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{reservationid}")
	@APIMapping(value = "UPDATE_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void updateHousingUnitReservation(HousingUnitReservation housingUnitReservation,@PathVariable("reservationid") UUID reservationid) {
		housingUnitReservation.setId(reservationid);
		serviceFactory.getHousingUnitReservationService().updateHousingUnitReservation(housingUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{reservationid}")
	@APIMapping(value = "DELETE_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void deleteHousingUnitReservation(@PathVariable("reservationid") UUID housingUnitReservationId) {
		serviceFactory.getHousingUnitReservationService().deleteHousingUnitReservation(housingUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{reservationid}")
	@APIMapping(value = "GET_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitReservation getHousingUnitReservation(@PathVariable("reservationid") UUID housingUnitReservationId) {
		return serviceFactory.getHousingUnitReservationService().getHousingUnitReservation(housingUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_HOUSINGUNIT_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitReservations getHousingUnitReservations(Pageable pageable) {
		return serviceFactory.getHousingUnitReservationService().getHousingUnitReservations(pageable);
	}
}
