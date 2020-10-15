package com.servinglynk.hmis.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.servinglynk.hmis.model.SubscriptionModel;
import com.servinglynk.hmis.model.Subscriptions;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController extends BaseController {

	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	public SubscriptionModel registerSubscription(@Valid @RequestBody SubscriptionModel subscription) throws Exception {
		return serviceFactory.getSubscriptionService().registerSubscription(subscription);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{subscriptionid}")
	@APIMapping(value = "CREATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	public void updateSubscription(@RequestBody SubscriptionModel subscription,
			@PathVariable("subscriptionid") UUID  subscriptionid
			) throws Exception {
			subscription.setId(subscriptionid);
		 serviceFactory.getSubscriptionService().updateSubscription(subscription);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{subscriptionid}")
	@APIMapping(value = "CREATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	public void deleteSubscription(	@PathVariable("subscriptionid") UUID  subscriptionid) {
		serviceFactory.getSubscriptionService().deleteSubscription(subscriptionid);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{subscriptionid}")
	@APIMapping(value = "CREATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	public 	SubscriptionModel getSubscriptionById(	@PathVariable("subscriptionid") UUID  subscriptionid) {
		return serviceFactory.getSubscriptionService().getSubscriptionById(subscriptionid);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "CREATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	public 	Subscriptions getAllSubscriptions(Pageable pageable) {
		return serviceFactory.getSubscriptionService().getAllSubscriptions(pageable);
	}	
	
	@RequestMapping(method = RequestMethod.POST,value = "/receiver")
	@APIMapping(value = "CREATE_AREA",checkSessionToken = true,checkTrustedApp = true)
	public void subscriptionUpdateReceiver(HttpServletRequest request,HttpServletResponse response) {
		ContentCachingRequestWrapper req = new ContentCachingRequestWrapper(request);
		  String body = null;
		    if (req.getContentLength() > 0) {
		      body = new String(req.getContentAsByteArray());
		    }
		    body = body.replaceAll("(\\r|\\n)", "");
		    
		    System.out.println("subscription update received "+body);
	
	}
}