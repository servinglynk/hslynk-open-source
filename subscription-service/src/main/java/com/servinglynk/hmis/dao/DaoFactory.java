package com.servinglynk.hmis.dao;

import com.servinglynk.hmis.repository.SubscriptionContactRepository;
import com.servinglynk.hmis.repository.SubscriptionRepository;

public interface DaoFactory {

	SubscriptionRepository getSubscriptionRepository();
	SubscriptionContactRepository getSubscriptionContactRepository();
}
