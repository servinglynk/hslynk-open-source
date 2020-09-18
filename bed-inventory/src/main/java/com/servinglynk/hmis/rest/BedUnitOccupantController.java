package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.BedOccupants;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/bedunits/{bedunitid}/occupants")
public class BedUnitOccupantController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	BedOccupant createBedOccupant(BedOccupant bedOccupant) {
		return serviceFactory.getBedOccupantService().createBedOccupant(bedOccupant);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{occupantid}")
	@APIMapping(value = "UPDATE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void updateBedOccupant(BedOccupant bedOccupant,@PathVariable("occupantid") UUID occupantid) {
		bedOccupant.setId(occupantid);
		serviceFactory.getBedOccupantService().updateBedOccupant(bedOccupant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{occupantid}")
	@APIMapping(value = "DELETE_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void deleteBedOccupant(@PathVariable("occupantid") UUID bedOccupantId) {
		serviceFactory.getBedOccupantService().deleteBedOccupant(bedOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{occupantid}")
	@APIMapping(value = "GET_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	BedOccupant getBedOccupant(@PathVariable("occupantid") UUID bedOccupantId) {
		return serviceFactory.getBedOccupantService().getBedOccupant(bedOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_OCCUPANTS",checkSessionToken = true,checkTrustedApp = true)
	BedOccupants getBedOccupants(Pageable pageable) {
		return serviceFactory.getBedOccupantService().getBedOccupants(pageable);
	}
}
