package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.HousingUnit;
import com.servinglynk.hmis.model.HousingUnits;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/housingunits")
public class HousingUnitController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_HOUSINGUNIT",checkSessionToken = true,checkTrustedApp = true)
	HousingUnit createHousingUnit(HousingUnit housingUnit) {
		return serviceFactory.getHousingUnitService().createHousingUnit(housingUnit);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{housingunitid}")
	@APIMapping(value = "UPDATE_HOUSINGUNIT",checkSessionToken = true,checkTrustedApp = true)
	void updateHousingUnit(HousingUnit housingUnit,@PathVariable("housingunitid") UUID housingunitid) {
		housingUnit.setId(housingunitid);
		serviceFactory.getHousingUnitService().updateHousingUnit(housingUnit);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{housingunitid}")
	@APIMapping(value = "DELETE_HOUSINGUNIT",checkSessionToken = true,checkTrustedApp = true)
	void deleteHousingUnit(@PathVariable("housingunitid") UUID housingUnitId) {
		serviceFactory.getHousingUnitService().deleteHousingUnit(housingUnitId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{housingunitid}")
	@APIMapping(value = "GET_HOUSINGUNIT",checkSessionToken = true,checkTrustedApp = true)
	HousingUnit getHousingUnit(@PathVariable("housingunitid") UUID housingUnitId) {
		return serviceFactory.getHousingUnitService().getHousingUnit(housingUnitId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_HOUSINGUNITS",checkSessionToken = true,checkTrustedApp = true)
	HousingUnits getHousingUnits(Pageable pageable) {
		return serviceFactory.getHousingUnitService().getHousingUnits(pageable);
	}
}
