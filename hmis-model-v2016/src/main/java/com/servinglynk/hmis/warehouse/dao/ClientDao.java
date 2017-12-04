package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2016.Client;

public interface ClientDao extends ParentDao {
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2016.Client client);
	
	Client createClient(Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient);
	Client updateClient(Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient);
	void deleteClient(Client client);
	Client getClientById(UUID clientId);
	List<Client> getAllClients(String username,Integer startIndex, Integer maxItems);
	long getClientsCount(String projectGroupCode);
	public com.servinglynk.hmis.warehouse.model.v2016.Client getClientByDedupCliendId(UUID id,String projectGroupCode);
	public List<com.servinglynk.hmis.warehouse.model.v2016.Client> getAllNullDedupIdClients();
	void updateDedupClient(Client client, String dedupSessionKey);
}
