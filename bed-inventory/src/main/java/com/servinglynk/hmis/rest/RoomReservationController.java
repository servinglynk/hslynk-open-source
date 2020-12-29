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

import com.servinglynk.hmis.model.RoomReservation;
import com.servinglynk.hmis.model.RoomReservations;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/shelters/{shelterid}/areas/{areaid}/rooms/{roomid}/reservations")
public class RoomReservationController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	RoomReservation createRoomReservation(@RequestBody RoomReservation roomreservation,
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid			
			) throws Exception {
			roomreservation.getRoom().setId(roomid);
		return serviceFactory.getRoomReservationService().createRoomReservation(roomreservation);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{roomreservationid}")
	@APIMapping(value = "UPDATE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void updateRoomReservation(@RequestBody RoomReservation roomreservation,
			@PathVariable("roomreservationid") UUID roomreservationid,
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid	) throws Exception  {
		roomreservation.setId(roomreservationid);
		roomreservation.getRoom().setAreaId(roomid);
		serviceFactory.getRoomReservationService().updateRoomReservation(roomreservation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{roomreservationid}")
	@APIMapping(value = "DELETE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void deleteRoomReservation(@PathVariable("roomreservationid") UUID roomreservationId,
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid	) {
		serviceFactory.getRoomReservationService().deleteRoomReservation(roomreservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{roomreservationid}")
	@APIMapping(value = "GET_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	RoomReservation getRoomReservation(@PathVariable("roomreservationid") UUID roomreservationId,
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid	) {
		return serviceFactory.getRoomReservationService().getRoomReservation(roomreservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_ROOM_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	RoomReservations getAreas(
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid,
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		return serviceFactory.getRoomReservationService().getRoomReservations(roomid,fromdate,todate,pageable);
	}
}
