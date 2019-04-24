package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.Client;

public interface ClientDao extends BaseDao {
	
	Client createClient(Client client);
	Client updateClient(Client client);
	void deleteClient(Client client);
	Client getClientById(UUID clientId);
	List<Client> getAllClients(Integer startIndex, Integer maxItems);
	long getClientsCount();
	public com.servinglynk.hmis.warehouse.model.base.Client getClientByDedupCliendId(UUID id,String projectGroupCode);
	public com.servinglynk.hmis.warehouse.model.base.Client getClientByssid(String ssid,String projectGroupCode);
}
