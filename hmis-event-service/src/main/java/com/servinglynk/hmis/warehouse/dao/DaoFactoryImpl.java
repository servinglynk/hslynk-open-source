package com.servinglynk.hmis.warehouse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.repository.ClientRepository;
import com.servinglynk.hmis.warehouse.repository.SubscriptionRepository;

@Component
public class DaoFactoryImpl implements DaoFactory {

	@Autowired SubscriptionRepository subscriptionRepository;
	
	@Autowired ClientRepository clientRepository;

	public SubscriptionRepository getSubscriptionRepository() {
		return subscriptionRepository;
	}

	public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}

	public ClientRepository getClientRepository() {
		return clientRepository;
	}

	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

}