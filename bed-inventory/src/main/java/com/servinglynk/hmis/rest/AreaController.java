package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.annotation.APIMapping;
import com.servinglynk.hmis.model.AreaModel;
import com.servinglynk.hmis.model.Areas;

@RestController
@RequestMapping("/shelters/{shelterid}/areas")
public class AreaController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	AreaModel createArea(@RequestBody AreaModel area,@PathVariable("shelterid") UUID shelterid) {
		area.setShelterId(shelterid);
		return serviceFactory.getAreaService().createArea(area);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{areaid}")
	@APIMapping(value = "UPDATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	void updateArea(@RequestBody AreaModel area,@PathVariable("areaid") UUID areaid,@PathVariable("shelterid") UUID shelterid) {
		area.setId(areaid);
		area.setShelterId(shelterid);
		serviceFactory.getAreaService().updateArea(area);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{areaid}")
	@APIMapping(value = "DELETE_AREA",checkSessionToken = true,checkTrustedApp = true)
	void deleteArea(@PathVariable("areaid") UUID areaId,@PathVariable("shelterid") UUID shelterid) {
		serviceFactory.getAreaService().deleteArea(areaId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{areaid}")
	@APIMapping(value = "GET_AREA",checkSessionToken = true,checkTrustedApp = true)
	AreaModel getArea(@PathVariable("areaid") UUID areaId,@PathVariable("shelterid") UUID shelterid) {
		return serviceFactory.getAreaService().getArea(areaId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_AREAS",checkSessionToken = true,checkTrustedApp = true)
	Areas getAreas(Pageable pageable,@PathVariable("shelterid") UUID shelterid) {
		return serviceFactory.getAreaService().getAreas(shelterid,pageable);
	}
}
