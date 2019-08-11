package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.BaseClientsService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConverter;
import com.servinglynk.hmis.warehouse.client.baseclients.BaseClientService;
import com.servinglynk.hmis.warehouse.core.model.BaseClients;
import com.servinglynk.hmis.warehouse.model.base.Client;
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
}
