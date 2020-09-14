package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.annotation.APIMapping;
import com.servinglynk.hmis.model.BedUnit;
import com.servinglynk.hmis.model.BedUnits;

@RestController
@RequestMapping("/bedunits")
public class BedUnitController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	BedUnit createBedUnit(BedUnit bedUnit) {
		return serviceFactory.getBedUnitService().createBedUnit(bedUnit);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{bedunitid}")
	@APIMapping(value = "UPDATE_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	void updateBedUnit(BedUnit bedUnit,@PathVariable("bedunitid") UUID bedunitid) {
		bedUnit.setId(bedunitid);
		serviceFactory.getBedUnitService().updateBedUnit(bedUnit);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{bedunitid}")
	@APIMapping(value = "DELETE_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	void deleteBedUnit(@PathVariable("bedunitid") UUID bedUnitId) {
		serviceFactory.getBedUnitService().deleteBedUnit(bedUnitId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{bedunitid}")
	@APIMapping(value = "GET_BEDUNIT",checkSessionToken = true,checkTrustedApp = true)
	BedUnit getBedUnit(@PathVariable("bedunitid") UUID bedUnitId) {
		return serviceFactory.getBedUnitService().getBedUnit(bedUnitId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_BEDUNITS",checkSessionToken = true,checkTrustedApp = true)
	BedUnits getBedUnits(Pageable pageable) {
		return serviceFactory.getBedUnitService().getBedUnits(pageable);
	}
}
