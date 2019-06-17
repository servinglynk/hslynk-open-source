package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;

public interface ClientService {

	
	Client createClient(Client client,String caller);
	Client updateClient(Client client,String caller);
	Client deleteClient(UUID clientId,String caller);
	Client getClientById(UUID clientId);
	Clients getAllClients(String projectGroupCode,Integer startIndex, Integer maxItems);
	Client unmergeClient(Client client, String caller, UUID clientId);
	Client mergeClient(Client client, String caller, UUID clientId);
}
