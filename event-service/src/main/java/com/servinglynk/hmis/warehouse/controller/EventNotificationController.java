package com.servinglynk.hmis.warehouse.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.util.TraceUtil;
import com.servinglynk.hmis.warehouse.service.ServiceFactory;

@RestController
public class EventNotificationController {
	
	@Autowired private ServiceFactory serviceFactory;
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/rest/eventnotifications")
	@APIMapping(checkSessionToken = false,checkTrustedApp = false,value = "PROCESS_SUBSCRIPTION")
	public void processSubscrion(@RequestBody Map<String, Object> requestBody,HttpServletRequest request) {
		TraceUtil.PutTraceIdInTreadContext(request);
		
		logger.info("event notifications message "+requestBody);
		
		serviceFactory.getSubscriptionService().processSubscriptionEvent(requestBody);
	}

}
