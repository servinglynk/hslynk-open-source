package com.servinglynk.hmis.warehouse.service.publish.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PublishHandlerFactory {
	@Autowired @Qualifier("restPushHandler") EventPublisher restPublisher;
	@Autowired @Qualifier("emailHandler") EventPublisher emailHandler;
	
	public EventPublisher getPublisher(String channelType) {
		switch (channelType.toLowerCase()) {
		case "rest-hook":
			return restPublisher;
		case "email":
			 return emailHandler;
		default:
			 return restPublisher;
		}
	}
}
