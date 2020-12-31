package com.servinglynk.hmis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactoryImpl extends BaseService implements ServiceFactory {

	@Autowired private SubscriptionService subscriptionService;

	public SubscriptionService getSubscriptionService() {
		return subscriptionService;
	}

	public void setSubscriptionService(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	

}
