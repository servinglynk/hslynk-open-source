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

import com.servinglynk.hmis.model.HousingUnitOccupant;
import com.servinglynk.hmis.model.HousingUnitOccupants;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/housingunits/{housingunitid}/occupants")
public class HousingUnitOccupantController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitOccupant createHousingUnitOccupant(
			@RequestBody HousingUnitOccupant housingUnitOccupant,
			@PathVariable("housingunitid") UUID housingunitid
			) throws Exception {
		housingUnitOccupant.getHousingUnit().setId(housingunitid);
		return serviceFactory.getHousingUnitOccupantService().createHousingUnitOccupant(housingUnitOccupant);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{occupantid}")
	@APIMapping(value = "UPDATE_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void updateHousingUnitOccupant(@RequestBody HousingUnitOccupant housingUnitOccupant,
			@PathVariable("housingunitid") UUID housingunitid,
			@PathVariable("occupantid") UUID occupantid) throws Exception {
		housingUnitOccupant.setId(occupantid);
		housingUnitOccupant.getHousingUnit().setId(housingunitid);
		serviceFactory.getHousingUnitOccupantService().updateHousingUnitOccupant(housingUnitOccupant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{occupantid}")
	@APIMapping(value = "DELETE_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	void deleteHousingUnitOccupant(@PathVariable("occupantid") UUID housingUnitOccupantId,
			@PathVariable("housingunitid") UUID housingunitid) {
		serviceFactory.getHousingUnitOccupantService().deleteHousingUnitOccupant(housingUnitOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{occupantid}")
	@APIMapping(value = "GET_HOUSINGUNIT_OCCUPANT",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitOccupant getHousingUnitOccupant(	@PathVariable("housingunitid") UUID housingunitid,
			@PathVariable("occupantid") UUID housingUnitOccupantId) {
		return serviceFactory.getHousingUnitOccupantService().getHousingUnitOccupant(housingUnitOccupantId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_HOUSINGUNIT_OCCUPANTS",checkSessionToken = true,checkTrustedApp = true)
	HousingUnitOccupants getHousingUnitOccupants(	@PathVariable("housingunitid") UUID housingunitid,
			@RequestParam(value = "fromdate",required = false )Long fromDate,
			@RequestParam(value = "todate",required = false )Long toDate,
			Pageable pageable) {
		Date fromdate = null ;
		Date todate = null;
		if(fromDate!=null) fromdate = new Date(fromDate);
		if(toDate!=null) todate = new Date(toDate);
		return serviceFactory.getHousingUnitOccupantService().getHousingUnitOccupants(housingunitid,fromdate,todate,pageable);
	}
}
