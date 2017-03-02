package com.servinglynk.hmis.warehouse.base.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.Client;

public interface BaseClientDao {

	void updateClientContact(Client client);
	Client getClient(UUID clientId);
	void createClient(Client client);
	void updateClient(Client client);
}