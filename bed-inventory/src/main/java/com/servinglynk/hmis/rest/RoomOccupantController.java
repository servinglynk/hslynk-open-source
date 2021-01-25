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

import com.servinglynk.hmis.model.RoomOccupant;
import com.servinglynk.hmis.model.RoomOccupants;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/shelters/{shelterid}/areas/{areaid}/rooms/{roomid}")
public class RoomOccupantController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST,value = "/checkin")
	@APIMapping(value = "CREATE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	RoomOccupant createRoomReservation(@RequestBody RoomOccupant occupant,
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid			
			) throws Exception {
		occupant.getRoom().setId(roomid);
		return serviceFactory.getRoomOccupantService().createRoomOccupant(occupant);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/checkout")
	@APIMapping(value = "UPDATE_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	void updateRoomReservation(@RequestBody RoomOccupant occupant,
			
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid	) throws Exception  {
		
		occupant.getRoom().setId(roomid);
		serviceFactory.getRoomOccupantService().checkoutRoomOccupant(occupant);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/occupants/{occupantid}")
	@APIMapping(value = "GET_ROOM_RESERVATION",checkSessionToken = true,checkTrustedApp = true)
	RoomOccupant getRoomOccupant(@PathVariable("occupantid") UUID occupantid,
			@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,
			@PathVariable("roomid") UUID roomid	) {
		return serviceFactory.getRoomOccupantService().getRoomOccupant(occupantid);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/occupants")
	@APIMapping(value = "GET_ROOM_RESERVATIONS",checkSessionToken = true,checkTrustedApp = true)
	RoomOccupants getAreas(
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
		return serviceFactory.getRoomOccupantService().getRoomOccupants(roomid,fromdate,todate,pageable);
	}
}
