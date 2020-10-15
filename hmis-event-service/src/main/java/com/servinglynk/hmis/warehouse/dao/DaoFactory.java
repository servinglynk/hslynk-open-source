package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.repository.SubscriptionRepository;

public interface DaoFactory {
	SubscriptionRepository getSubscriptionRepository();
}