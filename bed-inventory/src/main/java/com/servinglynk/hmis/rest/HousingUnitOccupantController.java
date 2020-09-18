package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.HousingUnitOccupant;
import com.servinglynk.hmis.model.HousingUnitOccupants;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/housingunits/{housingunitid}/occupants")
public class HousingUnitOccupantController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitOccupant createHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) {
		return serviceFactory.getHousingUnitOccupantService().createHousingUnitOccupant(housingUnitOccupant);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{occupantid}")
	@APIMapping(value = "UPDATE_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void updateHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant,@PathVariable("occupantid") UUID occupantid) {
		housingUnitOccupant.setId(occupantid);
		serviceFactory.getHousingUnitOccupantService().updateHousingUnitOccupant(housingUnitOccupant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{occupantid}")
	@APIMapping(value = "DELETE_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void deleteHousingUnitOccupant(@PathVariable("occupantid") UUID housingUnitOccupantId) {
		serviceFactory.getHousingUnitOccupantService().deleteHousingUnitOccupant(housingUnitOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{occupantid}")
	@APIMapping(value = "GET_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitOccupant getHousingUnitOccupant(@PathVariable("occupantid") UUID housingUnitOccupantId) {
		return serviceFactory.getHousingUnitOccupantService().getHousingUnitOccupant(housingUnitOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_HOUSINGUNIT_OCCUPANTS",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitOccupants getHousingUnitOccupants(Pageable pageable) {
		return serviceFactory.getHousingUnitOccupantService().getHousingUnitOccupants(pageable);
	}
}
