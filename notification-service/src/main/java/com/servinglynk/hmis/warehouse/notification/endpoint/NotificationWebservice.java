package com.servinglynk.hmis.warehouse.notification.endpoint;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.notification.business.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationWebservice {
	
	final static Logger logger = Logger.getLogger(NotificationWebservice.class);
	
	
	@Autowired
	private NotificationService notificationService;

	@RequestMapping(method=RequestMethod.POST)
	public  ResponseEntity<Notification> getPersonDetail(@RequestBody Notification notification) throws Exception {
		
		logger.info("Notification Request Data "+notification.toJSONString());
		notificationService.createNotificationJob(notification);
		
		return new ResponseEntity<Notification>(notification,new HttpHeaders(), 
			      HttpStatus.OK);
	}
} 