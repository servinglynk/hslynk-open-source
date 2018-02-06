package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.Client;

public interface ClientDao extends ParentDao {
	Client createClient(Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient);
	Client updateClient(Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient);
	void deleteClient(Client client);
	Client getClientById(UUID clientId);
	List<Client> getAllClients(String projectGroupCode, Integer startIndex, Integer maxItems);
	long getClientsCount(String projectGroupCode);
	public com.servinglynk.hmis.warehouse.model.v2014.Client getClientByDedupCliendId(UUID id,String projectGroupCode);
	public List<com.servinglynk.hmis.warehouse.model.v2014.Client> getAllNullDedupIdClients();
	void updateDedupClient(Client client, String dedupSessionKey);
}
