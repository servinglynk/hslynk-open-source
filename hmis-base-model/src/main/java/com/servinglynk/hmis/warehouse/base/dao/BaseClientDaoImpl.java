package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.Client;

public class BaseClientDaoImpl extends QueryExecutorImpl implements BaseClientDao {

	@Override
	public void updateClientContact(Client client) {
		update(client);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Client getClient(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(Restrictions.eq("id", clientId));
		List<Client> clients = (List<Client>) findByCriteria(criteria);
		if(!clients.isEmpty()) return clients.get(0);
		return null;
	}

	@Override
	public void createClient(Client client) {
		insert(client);
	}

	@Override
	public void updateClient(Client client) {
		update(client);
	}

}
