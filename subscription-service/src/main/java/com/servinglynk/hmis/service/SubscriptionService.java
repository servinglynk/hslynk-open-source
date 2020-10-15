package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.SubscriptionModel;
import com.servinglynk.hmis.model.Subscriptions;

public interface SubscriptionService {

	SubscriptionModel registerSubscription(SubscriptionModel subscription);
	void updateSubscription(SubscriptionModel subscription);
	void deleteSubscription(UUID subscriptionid);
	SubscriptionModel getSubscriptionById(UUID subscriptionid);
	Subscriptions getAllSubscriptions(Pageable pageable);
	
}