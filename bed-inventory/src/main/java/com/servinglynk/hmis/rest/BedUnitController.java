package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.BedUnit;
import com.servinglynk.hmis.model.BedUnits;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/shelters/{shelterid}/areas/{areaid}/rooms/{roomid}/bedunits")
public class BedUnitController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	BedUnit createBedUnit(@RequestBody BedUnit bedUnit,@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,@PathVariable("roomid") UUID roomid) {
		bedUnit.setRoomId(roomid);
		return serviceFactory.getBedUnitService().createBedUnit(bedUnit);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{bedunitid}")
	@APIMapping(value = "UPDATE_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	void updateBedUnit(@RequestBody BedUnit bedUnit,@PathVariable("bedunitid") UUID bedunitid
			,@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,@PathVariable("roomid") UUID roomid) {
		bedUnit.setId(bedunitid);
		bedUnit.setRoomId(roomid);
		serviceFactory.getBedUnitService().updateBedUnit(bedUnit);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{bedunitid}")
	@APIMapping(value = "DELETE_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	void deleteBedUnit(@PathVariable("bedunitid") UUID bedUnitId,@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,@PathVariable("roomid") UUID roomid) {
		serviceFactory.getBedUnitService().deleteBedUnit(bedUnitId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{bedunitid}")
	@APIMapping(value = "GET_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	BedUnit getBedUnit(@PathVariable("bedunitid") UUID bedUnitId,@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,@PathVariable("roomid") UUID roomid) {
		return serviceFactory.getBedUnitService().getBedUnit(bedUnitId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_BEDUNITS",checkSessionToken = true,checkTrustedApp = true)
	BedUnits getBedUnits(Pageable pageable,@PathVariable("shelterid") UUID shelterid,
			@PathVariable("areaid") UUID areaid,@PathVariable("roomid") UUID roomid) {
		return serviceFactory.getBedUnitService().getBedUnits(shelterid,areaid,roomid,pageable);
	}
}
