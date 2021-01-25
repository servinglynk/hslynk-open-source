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

import com.servinglynk.hmis.model.HousingUnitReservation;
import com.servinglynk.hmis.model.HousingUnitReservations;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/housingunits/{housingunitid}/reservations")
public class HousingUnitReservationController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitReservation createHousingUnitReservation(@RequestBody HousingUnitReservation housingUnitReservation,
			@PathVariable("housingunitid") UUID housingunitid) throws Exception {
		housingUnitReservation.getHousingUnit().setId(housingunitid);
		return serviceFactory.getHousingUnitReservationService().createHousingUnitReservation(housingUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{reservationid}")
	@APIMapping(value = "UPDATE_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void updateHousingUnitReservation(@RequestBody HousingUnitReservation housingUnitReservation,
			@PathVariable("housingunitid") UUID housingunitid,
			@PathVariable("reservationid") UUID reservationid)  throws Exception {
		housingUnitReservation.setId(reservationid);
		housingUnitReservation.getHousingUnit().setId(housingunitid);
		serviceFactory.getHousingUnitReservationService().updateHousingUnitReservation(housingUnitReservation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{reservationid}")
	@APIMapping(value = "DELETE_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void deleteHousingUnitReservation(@PathVariable("reservationid") UUID housingUnitReservationId,
			@PathVariable("housingunitid") UUID housingunitid) {
		serviceFactory.getHousingUnitReservationService().deleteHousingUnitReservation(housingUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{reservationid}")
	@APIMapping(value = "GET_HOUSINGUNIT_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitReservation getHousingUnitReservation(@PathVariable("reservationid") UUID housingUnitReservationId,
			@PathVariable("housingunitid") UUID housingunitid) {
		return serviceFactory.getHousingUnitReservationService().getHousingUnitReservation(housingUnitReservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_HOUSINGUNIT_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitReservations getHousingUnitReservations(@PathVariable("housingunitid") UUID housingunitid,
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		return serviceFactory.getHousingUnitReservationService().getHousingUnitReservations(housingunitid,fromdate,todate,pageable);
	}
}
