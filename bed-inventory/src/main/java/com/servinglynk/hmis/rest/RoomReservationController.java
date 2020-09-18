package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.RoomReservation;
import com.servinglynk.hmis.model.RoomReservations;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/shleters/{shelterid}/areas/{areaid}/rooms/{roomid}/roomreservations")
public class RoomReservationController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	RoomReservation createRoomReservation(RoomReservation roomreservation) {
		return serviceFactory.getRoomReservationService().createRoomReservation(roomreservation);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{roomreservationid}")
	@APIMapping(value = "UPDATE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void updateRoomReservation(RoomReservation roomreservation,@PathVariable("roomreservationid") UUID roomreservationid) {
		roomreservation.setId(roomreservationid);
		serviceFactory.getRoomReservationService().updateRoomReservation(roomreservation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{roomreservationid}")
	@APIMapping(value = "DELETE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void deleteRoomReservation(@PathVariable("roomreservationid") UUID roomreservationId) {
		serviceFactory.getRoomReservationService().deleteRoomReservation(roomreservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{roomreservationid}")
	@APIMapping(value = "GET_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	RoomReservation getRoomReservation(@PathVariable("roomreservationid") UUID roomreservationId) {
		return serviceFactory.getRoomReservationService().getRoomReservation(roomreservationId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_ROOM_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	RoomReservations getAreas(Pageable pageable) {
		return serviceFactory.getRoomReservationService().getRoomReservations(pageable);
	}
}
