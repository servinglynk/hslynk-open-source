package com.servinglynk.hmis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.repository.SubscriptionContactRepository;
import com.servinglynk.hmis.repository.SubscriptionRepository;

@Component
public class DaoFactoryImpl implements DaoFactory {

	@Autowired private SubscriptionRepository subscriptionRepository;
	
	@Autowired private SubscriptionContactRepository subscriptionContactRepository;

	public SubscriptionRepository getSubscriptionRepository() {
		return subscriptionRepository;
	}

	public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}

	public SubscriptionContactRepository getSubscriptionContactRepository() {
		return subscriptionContactRepository;
	}

	public void setSubscriptionContactRepository(SubscriptionContactRepository subscriptionContactRepository) {
		this.subscriptionContactRepository = subscriptionContactRepository;
	}
	
	
}
