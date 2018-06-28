package com.servinglynk.hmis.warehouse.service.impl;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.service.ClientService;
import com.servinglynk.hmis.warehouse.service.converter.ClientConverter;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;
import com.servinglynk.hmis.warehouse.model.v2016.Enrollment;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;

public class ClientServiceImpl extends ServiceBase implements ClientService {

	@Override
	@Transactional
	public Client createClient(Client client, String caller) {
		com.servinglynk.hmis.warehouse.model.v2016.Client pClient = ClientConverter.modelToEntity(client, null);
		pClient.setDateCreated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		daoFactory.getProjectDao().populateUserProjectGroupCode(pClient, caller);
		com.servinglynk.hmis.warehouse.model.base.Client baseClient = new com.servinglynk.hmis.warehouse.model.base.Client();
		BeanUtils.copyProperties(pClient,baseClient);
		baseClient.setPhoneNumber(client.getPhoneNumber());
		baseClient.setEmailAddress(client.getEmailAddress());

		daoFactory.getClientDao().createClient(pClient,baseClient);
		client.setClientId(pClient.getId());
		return client;
	}

	@Override
	@Transactional
	public Client updateClient(Client client, String caller) {
		com.servinglynk.hmis.warehouse.model.v2016.Client pClient = daoFactory.getClientDao().getClientById(client.getClientId());

		if(pClient == null ) throw new ClientNotFoundException();

		ClientConverter.modelToEntity(client, pClient);
		com.servinglynk.hmis.warehouse.model.base.Client baseClient = new com.servinglynk.hmis.warehouse.model.base.Client();
		BeanUtils.copyProperties(pClient, baseClient);
		baseClient.setPhoneNumber(client.getPhoneNumber());
		baseClient.setEmailAddress(client.getEmailAddress());


		daoFactory.getClientDao().updateClient(pClient,baseClient);
		return client;
	}

	@Override
	@Transactional
	public Client deleteClient(UUID clientId, String caller) {
		
		com.servinglynk.hmis.warehouse.model.v2016.Client pClient = daoFactory.getClientDao().getClientById(clientId); 
		
		if(pClient == null ) throw new ClientNotFoundException();
		
		Set<Enrollment> enrollments = pClient.getEnrollments();
		for(Enrollment enrollment : enrollments) {
			daoFactory.getEnrollmentDao().delete(enrollment);
		}
		
		daoFactory.getClientDao().deleteClient(pClient);
	com.servinglynk.hmis.warehouse.model.base.Client baseClient = daoFactory.getHmisClientDao().getClientById(clientId);

		if(pClient == null ) throw new ClientNotFoundException();

		daoFactory.getHmisClientDao().deleteClient(baseClient);
		return new Client();
	}

	@Override
	@Transactional
	public Client getClientById(UUID clientId) {
		com.servinglynk.hmis.warehouse.model.v2016.Client pClient = daoFactory.getClientDao().getClientById(clientId); 
		
		if(pClient == null ) throw new ClientNotFoundException();
		Client client = ClientConverter.entityToModel(pClient);
		com.servinglynk.hmis.warehouse.model.base.Client baseClient =	daoFactory.getBaseClientDao().getClient(clientId);
		if(baseClient!=null){
			client.setPhoneNumber(baseClient.getPhoneNumber());
			client.setEmailAddress(baseClient.getEmailAddress());
		}		
		return client;
	}

	@Override
	@Transactional
	public Clients getAllClients(String projectGroupCode,Integer startIndex, Integer maxItems) {
		List<com.servinglynk.hmis.warehouse.model.v2016.Client> clientsList = daoFactory.getClientDao().getAllClients(projectGroupCode,startIndex,maxItems);
		Clients clients= new Clients();
		for(com.servinglynk.hmis.warehouse.model.v2016.Client pClient : clientsList){
			Client client = ClientConverter.entityToModel(pClient);
			com.servinglynk.hmis.warehouse.model.base.Client baseClient =	daoFactory.getBaseClientDao().getClient(pClient.getId());
			if(baseClient!=null){
				client.setPhoneNumber(baseClient.getPhoneNumber());
				client.setEmailAddress(baseClient.getEmailAddress());
			}		
			clients.addClient(client);
		}

        long count = daoFactory.getClientDao().getClientsCount(projectGroupCode);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(clients.getClients().size());
        pagination.setTotal((int)count);
        clients.setPagination(pagination);


		return clients;
	}

}
