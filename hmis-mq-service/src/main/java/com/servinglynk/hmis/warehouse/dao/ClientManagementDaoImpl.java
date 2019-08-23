package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientManagementDaoImpl implements ClientManagementDao {

	@Autowired EntityManager entityManager;
	
	public void deleteClientIdentities(UUID clientId,UUID dedupClientId,String projectGroupCode,UUID userId) {
		Session session = entityManager.unwrap(Session.class);
		String query = "select * from base.\"deleteClientIdenties\" ('"+clientId+"','"+dedupClientId+"','"+projectGroupCode+"')";
		System.out.println("delete query "+query);
		session.createSQLQuery(query).list();
	}

	@Override
	public void mergeClientIdentities(UUID currentDedupId, UUID targetDedupId, UUID clientId, String projectGroupCode) {
		Session session = entityManager.unwrap(Session.class);
		String query = "select * from base.\"mergeClientIdenties\" ('"+currentDedupId+"','"+targetDedupId+"','"+clientId+"','"+projectGroupCode+"')";
		System.out.println("delete query "+query);
		session.createSQLQuery(query).list();
	}
	
}
