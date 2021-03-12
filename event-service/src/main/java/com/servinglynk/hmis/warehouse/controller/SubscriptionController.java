package com.servinglynk.hmis.warehouse.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.model.Subscription;

@RestController
public class SubscriptionController {
	
	@RequestMapping(method = RequestMethod.POST,value = "/rest/clients/{clientid}/subscriptions")
	@APIMapping(checkSessionToken = false,checkTrustedApp = false,value = "PROCESS_SUBSCRIPTION")
	public void createCovidSubscription(@RequestBody Subscription subscription,@PathVariable("clientid") UUID clientid) {
		
	}

}
