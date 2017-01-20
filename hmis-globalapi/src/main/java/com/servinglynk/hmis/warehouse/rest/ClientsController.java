package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Parameters;

@RestController
public class ClientsController extends ControllerBase {

	@RequestMapping(value="/clients/{clientid}/dataelements",method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	public Parameters getClientDataElements(@PathVariable("clientid") UUID clientId, HttpServletRequest request) throws Exception{
	    return 	serviceFactory.getClientDataElementsService().getClientDataElements(clientId);
	}
}