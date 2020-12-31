package com.servinglynk.hmis.rest;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.BedUnitReservation;
import com.servinglynk.hmis.model.BedUnitReservations;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/bedunits/{bedunitid}/reservations")
public class BedUnitReservationController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	BedUnitReservation createBedUnitReservation(@RequestBody BedUnitReservation bedUnitReservation,
			@PathVariable("bedunitid") UUID bedunitid) throws Exception {
		bedUnitReservation.setBedUnitId(bedunitid);
		return serviceFactory.getBedReservationService().createBedUnitReservation(bedUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{reservationid}")
	@APIMapping(value = "UPDATE_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void updateBedUnitReservation(BedUnitReservation bedUnitReservation,
			@PathVariable("bedunitid") UUID bedunitid,
			@PathVariable("reservationid") UUID reservationid) throws Exception {
		bedUnitReservation.setId(reservationid);
		serviceFactory.getBedReservationService().updateBedUnitReservation(bedUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{reservationid}")
	@APIMapping(value = "DELETE_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void deleteBedUnitReservation(@PathVariable("bedunitid") UUID bedunitid,@PathVariable("reservationid") UUID bedUnitReservationId) {
		serviceFactory.getBedReservationService().deleteBedUnitReservation(bedUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{reservationid}")
	@APIMapping(value = "GET_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	BedUnitReservation getBedUnitReservation(@PathVariable("bedunitid") UUID bedunitid,@PathVariable("reservationid") UUID bedUnitReservationId) {
		return serviceFactory.getBedReservationService().getBedUnitReservation(bedUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	BedUnitReservations getBedUnitReservations(@PathVariable("bedunitid") UUID bedunitid,
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		return serviceFactory.getBedReservationService().getBedUnitReservations(bedunitid,fromdate,todate,pageable);
	}
}
