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

import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.BedOccupants;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/bedunits/{bedunitid}/occupants")
public class BedUnitOccupantController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	BedOccupant createBedOccupant(@RequestBody BedOccupant bedOccupant,
			@PathVariable("bedunitid") UUID bedunitid) throws Exception  {
		bedOccupant.getBedUnit().setId(bedunitid);
		return serviceFactory.getBedOccupantService().createBedOccupant(bedOccupant);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{occupantid}")
	@APIMapping(value = "UPDATE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void updateBedOccupant(@RequestBody BedOccupant bedOccupant,@PathVariable("bedunitid") UUID bedunitid,@PathVariable("occupantid") UUID occupantid)  throws Exception {
		bedOccupant.setId(occupantid);
		bedOccupant.getBedUnit().setId(bedunitid);
		serviceFactory.getBedOccupantService().updateBedOccupant(bedOccupant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{occupantid}")
	@APIMapping(value = "DELETE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void deleteBedOccupant(@PathVariable("bedunitid") UUID bedunitid,@PathVariable("occupantid") UUID bedOccupantId) {
		serviceFactory.getBedOccupantService().deleteBedOccupant(bedOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{occupantid}")
	@APIMapping(value = "GET_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	BedOccupant getBedOccupant(@PathVariable("bedunitid") UUID bedunitid,@PathVariable("occupantid") UUID bedOccupantId) {
		return serviceFactory.getBedOccupantService().getBedOccupant(bedOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_OCCUPANTS",checkSessionToken = true,checkTrustedApp = true)
	BedOccupants getBedOccupants(@PathVariable("bedunitid") UUID bedunitid,	
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		return serviceFactory.getBedOccupantService().getBedOccupants(bedunitid,fromdate,todate,pageable);
	}
}
