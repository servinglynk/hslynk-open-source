package com.servinglynk.hmis.rest;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.BedOccupants;
import com.servinglynk.hmis.model.BedUnitReservations;
import com.servinglynk.hmis.model.RoomReservations;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/cleints/{dedupClientId}")
public class ClientsController extends BaseController {
	
	@RequestMapping(value = "/bedunits/occupants",method = RequestMethod.GET)
	@APIMapping(value = "GET_OCCUPANTS",checkSessionToken = true,checkTrustedApp = true)
	public BedOccupants getClientBedUnitOccupants(@PathVariable("dedupClientId") UUID dedupClientId,
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			@RequestParam(value = "future",required = false ) boolean futureInfo,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		if(fromdate!= null || todate !=null) {
			fromdate= new Date();
		}
		return serviceFactory.getBedOccupantService().getClientBedUnitOccupants(dedupClientId,fromdate,todate,pageable);
	}
	
	
	@RequestMapping(value = "/bedunits/reservations",method = RequestMethod.GET)
	@APIMapping(value = "GET_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	public BedUnitReservations getClientBedUnitReservations(@PathVariable("dedupClientId") UUID dedupClientId,
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			@RequestParam(value = "future",required = false ) boolean futureInfo,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		if(fromdate!= null || todate !=null) {
			fromdate= new Date();
		}
		return serviceFactory.getBedReservationService().getClientBedUnitReservations(dedupClientId,fromdate,todate,pageable);
	}
	
	@RequestMapping(value = "/rooms/reservations",method = RequestMethod.GET)
	@APIMapping(value = "GET_ROOM_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	public RoomReservations getClientRoomReservations(@PathVariable("dedupClientId") UUID dedupClientId,
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			@RequestParam(value = "future",required = false ) boolean futureInfo,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		if(fromdate!= null || todate !=null) {
			fromdate= new Date();
		}
		return serviceFactory.getRoomReservationService().getClientRoomReservations(dedupClientId,fromdate,todate,pageable);
	}
	

}
