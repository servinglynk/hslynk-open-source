package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.annotation.APIMapping;
import com.servinglynk.hmis.model.BedUnitReservation;
import com.servinglynk.hmis.model.BedUnitReservations;

@RestController
@RequestMapping("/bedunits/{bedunitid}/reservations")
public class BedUnitReservationController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	BedUnitReservation createBedUnitReservation(@RequestBody BedUnitReservation bedUnitReservation,
			@PathVariable("bedunitid") UUID bedunitid) {
		bedUnitReservation.setBedUnitId(bedunitid);
		return serviceFactory.getBedReservationService().createBedUnitReservation(bedUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{reservationid}")
	@APIMapping(value = "UPDATE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void updateBedUnitReservation(BedUnitReservation bedUnitReservation,@PathVariable("reservationid") UUID reservationid) {
		bedUnitReservation.setId(reservationid);
		serviceFactory.getBedReservationService().updateBedUnitReservation(bedUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{reservationid}")
	@APIMapping(value = "DELETE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void deleteBedUnitReservation(@PathVariable("reservationid") UUID bedUnitReservationId) {
		serviceFactory.getBedReservationService().deleteBedUnitReservation(bedUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{reservationid}")
	@APIMapping(value = "GET_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	BedUnitReservation getBedUnitReservation(@PathVariable("reservationid") UUID bedUnitReservationId) {
		return serviceFactory.getBedReservationService().getBedUnitReservation(bedUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_OCCUPANTS",checkSessionToken = true,checkTrustedApp = true)
	BedUnitReservations getBedUnitReservations(Pageable pageable) {
		return serviceFactory.getBedReservationService().getBedUnitReservations(pageable);
	}
}
