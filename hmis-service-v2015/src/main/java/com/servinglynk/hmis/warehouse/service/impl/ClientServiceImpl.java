package com.servinglynk.hmis.warehouse.service.impl;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.service.ClientService;
import com.servinglynk.hmis.warehouse.service.converter.ClientConverter;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;

public class ClientServiceImpl extends ServiceBase implements ClientService {

	@Override
	@Transactional
	public Client createClient(Client client, String caller) {
		com.servinglynk.hmis.warehouse.model.v2015.Client pClient = ClientConverter.modelToEntity(client, null);
		pClient.setDateCreated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		pClient.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
		daoFactory.getClientDao().createClient(pClient);
		client.setClientId(pClient.getId());
		return client;
	}

	@Override
	@Transactional
	public Client updateClient(Client client, String caller) {
		com.servinglynk.hmis.warehouse.model.v2015.Client pClient = daoFactory.getClientDao().getClientById(client.getClientId()); 
		
		if(pClient == null ) throw new ClientNotFoundException();
		
		ClientConverter.modelToEntity(client, pClient);
			daoFactory.getClientDao().updateClient(pClient);
		return client;
	}

	@Override
	@Transactional
	public Client deleteClient(UUID clientId, String caller) {
	com.servinglynk.hmis.warehouse.model.base.Client pClient = daoFactory.getHmisClientDao().getClientById(clientId); 
		
		if(pClient == null ) throw new ClientNotFoundException();
		
		daoFactory.getHmisClientDao().deleteClient(pClient);
		return new Client();
	}

	@Override
	@Transactional
	public Client getClientById(UUID clientId) {
		com.servinglynk.hmis.warehouse.model.v2015.Client pClient = daoFactory.getClientDao().getClientById(clientId); 
		
		if(pClient == null ) throw new ClientNotFoundException();
		
		return ClientConverter.entityToModel(pClient);
	}

	@Override
	@Transactional
	public Clients getAllClients(String caller,Integer startIndex, Integer maxItems) {
		List<com.servinglynk.hmis.warehouse.model.v2015.Client> clientsList = daoFactory.getClientDao().getAllClients(startIndex,maxItems);
		Clients clients= new Clients();
		for(com.servinglynk.hmis.warehouse.model.v2015.Client pClient : clientsList){
			clients.addClient(ClientConverter.entityToModel(pClient));
		}
		
        long count = daoFactory.getHmisClientDao().getClientsCount();
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(clients.getClients().size());
        pagination.setTotal((int)count);
        clients.setPagination(pagination);

		
		return clients;
	}
	
	@Transactional
	public Clients searchClients(String searchterm) throws Exception {
		List<com.servinglynk.hmis.warehouse.model.v2015.Client> clientsList = daoFactory.getClientDao().searchClients(searchterm);
		Clients clients= new Clients();
		for(com.servinglynk.hmis.warehouse.model.v2015.Client pClient : clientsList){
			clients.addClient(ClientConverter.entityToModel(pClient));
		}
		
		return clients;
	}

}
