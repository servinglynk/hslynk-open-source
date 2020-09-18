package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.RoomModel;
import com.servinglynk.hmis.model.Rooms;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/shelters/{shelterid}/areas/{areaid}/rooms")
public class RoomController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_ROOM",checkSessionToken = true,checkTrustedApp = true)
	RoomModel createRoom(@RequestBody RoomModel room,@PathVariable("shelterid") UUID shelterid,@PathVariable("areaid") UUID areaid) {
		room.setAreaId(areaid);
		room.setShelterId(shelterid);
		return serviceFactory.getRoomService().createRoom(room);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{roomid}")
	@APIMapping(value = "UPDATE_ROOM",checkSessionToken = true,checkTrustedApp = true)
	void updateRoom(@RequestBody RoomModel room,@PathVariable("roomid") UUID roomid,@PathVariable("shelterid") UUID shelterid,@PathVariable("areaid") UUID areaid) {
		room.setId(roomid);
		room.setAreaId(areaid);
		room.setShelterId(shelterid);
		serviceFactory.getRoomService().updateRoom(room);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{roomid}")
	@APIMapping(value = "DELETE_ROOM",checkSessionToken = true,checkTrustedApp = true)
	void deleteRoom(@PathVariable("roomid") UUID roomId,@PathVariable("shelterid") UUID shelterid,@PathVariable("areaid") UUID areaid) {
		serviceFactory.getRoomService().deleteRoom(roomId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{roomid}")
	@APIMapping(value = "GET_ROOM",checkSessionToken = true,checkTrustedApp = true)
	RoomModel getRoom(@PathVariable("roomid") UUID roomId,@PathVariable("shelterid") UUID shelterid,@PathVariable("areaid") UUID areaid) {
		return serviceFactory.getRoomService().getRoom(roomId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_ROOMS",checkSessionToken = true,checkTrustedApp = true)
	Rooms getAreas(@PathVariable("shelterid") UUID shelterid,@PathVariable("areaid") UUID areaid,Pageable pageable) {
		return serviceFactory.getRoomService().getRooms(shelterid,areaid,pageable);
	}
}
