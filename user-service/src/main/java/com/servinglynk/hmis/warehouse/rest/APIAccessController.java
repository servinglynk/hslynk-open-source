package com.servinglynk.hmis.warehouse.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.APIAccess;

@RestController
@RequestMapping("/apiAccess")
public class APIAccessController extends ControllerBase {

	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="GET_API_ACCESS_DETAILS",checkSessionToken=false,checkTrustedApp=false)
	public List<APIAccess> getAPIAccessDetails(@RequestParam(value="filter",required=false,defaultValue="TM") String filter,
									@RequestParam(value="q",required=false) String q) {
		return serviceFactory.getApiAccessService().getAPIAccessDetails(filter,q);
	}
}