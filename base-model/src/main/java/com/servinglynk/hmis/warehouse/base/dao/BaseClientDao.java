package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;

public interface BaseClientDao {

	void updateClientContact(Client client);
	Client getClient(UUID clientId);
	void createClient(Client client);
	void updateClient(Client client);
	List<Client> getClientsByDedupId(UUID dedupId,Integer startIndex,Integer maxResults);
	Long getClientsCountByDedupId(UUID dedupId);
	List<Client> getAllClients();
	
	List<ClientMetaDataEntity> getAllClientsMetadata();
}