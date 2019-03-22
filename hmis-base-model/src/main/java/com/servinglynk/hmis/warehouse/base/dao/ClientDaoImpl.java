/**
 * 
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


public class ClientDaoImpl extends BaseDaoImpl implements ClientDao {
	

	@Override
	public com.servinglynk.hmis.warehouse.model.base.Client createClient(
			com.servinglynk.hmis.warehouse.model.base.Client client) {
			client.setId(UUID.randomUUID());
			insert(client);
		return client;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.base.Client updateClient(
			com.servinglynk.hmis.warehouse.model.base.Client client) {
			update(client);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.base.Client client) {
			delete(client);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.base.Client getClientById(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.Client.class);
		criteria.add(Restrictions.eq("id", clientId));
		List<com.servinglynk.hmis.warehouse.model.base.Client> clients = (List<com.servinglynk.hmis.warehouse.model.base.Client>) findByCriteria(criteria);
		if(clients.size()>0) return clients.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.base.Client getClientByDedupCliendId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.base.Client> clients = (List<com.servinglynk.hmis.warehouse.model.base.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.base.Client> getAllClients(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.Client.class);	
		List<com.servinglynk.hmis.warehouse.model.base.Client> clients = (List<com.servinglynk.hmis.warehouse.model.base.Client>) findByCriteria(criteria,startIndex,maxItems);
		return clients;
	}
	
	
	public long getClientsCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.Client.class);	
		return countRows(criteria);
	}
}
