package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.repository.ClientRepository;
import com.servinglynk.hmis.warehouse.repository.SubscriptionRepository;

public interface DaoFactory {
	SubscriptionRepository getSubscriptionRepository();
	ClientRepository getClientRepository();
}