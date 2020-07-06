package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.BaseClientsService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.MergeClientConverter;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.core.model.BaseClients;
import com.servinglynk.hmis.warehouse.core.model.MergeClient;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class BaseClientsServiceImpl extends ServiceBase implements BaseClientsService {

	@Transactional
	public BaseClients getClientsByDedupId(UUID dedupId,Integer startIndex,Integer maxResults){
		BaseClients baseClients = new BaseClients();
		List<Client> clients =	daoFactory.getBaseClientDao().getClientsByDedupId(dedupId, startIndex, maxResults);
		if(clients.isEmpty()) throw new ResourceNotFoundException("DedupClientId not found "+dedupId);
		 for(Client pClient : clients) {
			 baseClients.addClient(ClientConverter.entityToModel(pClient));
		 }
		 
		 Long total = daoFactory.getBaseClientDao().getClientsCountByDedupId(dedupId);
		    SortedPagination pagination = new SortedPagination();
		    pagination.setFrom(startIndex);
		    pagination.setMaximum(maxResults);
		    pagination.setTotal(total.intValue());
		    pagination.setReturned(baseClients.getClients().size());
		    baseClients.setPagination(pagination);
		return baseClients;
	}
	
	@Override
	@Transactional
	public MergeClient mergeClient(MergeClient client, String caller,UUID clientId) {
		Client pClient = daoFactory.getBaseClientDao().getClient(clientId);
		if(pClient == null) throw new ClientNotFoundException();
		UUID oldDedupId = pClient.getDedupClientId();
		Client baseClient = new Client();
		MergeClientConverter.modelToEntity(client, baseClient);
		UUID dedupClientId = daoFactory.getHmisClientDao().determindDedupId(baseClient);
		baseClient.setDedupClientId(dedupClientId);
		 MergeClient entityToModel = MergeClientConverter.entityToModel(baseClient);
		 entityToModel.setOldDedupClientId(oldDedupId);
		 entityToModel.setClientId(clientId);
		 return entityToModel;
	}
	
	
	@Override
	@Transactional
	public MergeClient unmergeClient(MergeClient client, String caller,UUID clientId) {
		Client pClient = daoFactory.getBaseClientDao().getClient(clientId);
		if(pClient == null) throw new ClientNotFoundException();
		UUID oldDedupId = pClient.getDedupClientId();
       // Make essential attributes null before merge or unmerge
		
		Client baseClient = new Client();
		MergeClientConverter.modelToEntity(client, baseClient);
		// Update the dedup id of the client in Open EMPI by calling the updatePerson API in the dedup service.
		UUID dedupClientId = daoFactory.getHmisClientDao().determindDedupId(baseClient);
		baseClient.setDedupClientId(dedupClientId);
		 MergeClient entityToModel = MergeClientConverter.entityToModel(baseClient);
		 entityToModel.setOldDedupClientId(oldDedupId);
		 entityToModel.setClientId(clientId);
		 return entityToModel;
	}

	@Autowired
	private JmsTemplate jmsMessagingTemplate;
	
	@Transactional
	public void cacheClientData() {
		List<Client> clients = daoFactory.getBaseClientDao().getAllClients();
		for(Client client : clients) {
			
			ActiveMQQueue queue =  new ActiveMQQueue("cache.base.cleint");
			try {
				jmsMessagingTemplate.convertAndSend(queue,JsonUtil.coneveterObejctToString(client));
			} catch (JmsException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
