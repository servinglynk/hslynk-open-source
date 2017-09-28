package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.HMISTypes;

@RestController
@RequestMapping("/hmistypes")
public class HMISTypeController extends ControllerBase {

	@RequestMapping(method=RequestMethod.GET,value="/{name}/values")
	@APIMapping(checkSessionToken=false,checkTrustedApp=true,value="GET_HMIS_DATA_ELEMENTS")
	public HMISTypes getHmisTypesByName(@PathVariable("name") String name,
			HttpServletRequest request) throws Exception {
		return serviceFactory.getHmisTypeService().getDataElements(name);
	}
	
	/*@RequestMapping(method=RequestMethod.GET,value="/values")
	@APIMapping(checkSessionToken=false,checkTrustedApp=true,value="GET_HMIS_DATA_ELEMENTS")
	public HMISTypes getHmisTypes(@RequestParam(value="startIndex", required=false) Integer startIndex, 
            @RequestParam(value="maxItems", required=false) Integer maxItems,
            HttpServletRequest request) throws Exception {
		  if (startIndex == null) startIndex =0;
          if (maxItems == null || maxItems > 30) maxItems =30;
		return serviceFactory.getHmisTypeService().getDataElements(null);
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=false,checkTrustedApp=true,value="GET_HMIS_DATA_ELEMENTS")
	public HMISTypes getHmisTypeTypes(HttpServletRequest request) throws Exception {
		return serviceFactory.getHmisTypeService().getDataElementNames();
	}
	
}
