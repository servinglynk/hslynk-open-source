/**
 * 
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.DedupHelper;
import com.servinglynk.hmis.warehouse.client.MessageSender;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;


public class ClientDaoImpl extends BaseDaoImpl implements ClientDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ClientDaoImpl.class);
	@Autowired
	DedupHelper dedupHelper;
	
	@Autowired
	BaseDaoFactory daoFactory;
	
	@Autowired MessageSender messageSender;

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
			
			// creating active mq request
			AMQEvent amqEvent = new AMQEvent();

			amqEvent.setEventType("client.delete");
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("clientId", client.getId());
			data.put("dedupClientId", client.getDedupClientId());
			data.put("projectGroupCode", client.getProjectGroupCode());
//			data.put("userId",Securit);
			amqEvent.setPayload(data);
			amqEvent.setModule("hmis");
			amqEvent.setSubsystem("clientapi");
			messageSender.sendAmqMessage(amqEvent);	
		
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
	public com.servinglynk.hmis.warehouse.model.base.Client getClientByssid(final String ssid,final String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.Client.class);
		criteria.add(Restrictions.eq("sourceSystemId", ssid.trim()));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.base.Client> clients = (List<com.servinglynk.hmis.warehouse.model.base.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
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
	
	/***
	 * This method is used to determine the dedupedId depending on a config set at a project group level.
	 * @param client
	 * @param baseClient
	 * @param projectGroupCode
	 * @return
	 */
	public UUID determindDedupId(com.servinglynk.hmis.warehouse.model.base.Client baseClient,String projectGroupCode) {
		String ssid = baseClient.getSourceSystemId();
		baseClient.setProjectGroupCode(projectGroupCode);
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(projectGroupCode);
		UUID dedupedId = null;
		if(projectGroupEntity.isDetermineDedupBySsid() && StringUtils.isNotBlank(ssid)) {
			com.servinglynk.hmis.warehouse.model.base.Client clientByssid = daoFactory.getHmisClientDao().getClientByssid(ssid, projectGroupCode);
			if(clientByssid != null) {
				dedupedId = clientByssid.getDedupClientId();
			}
		}
		
		if(dedupedId == null) {
			dedupedId = determindDedupId(baseClient);
		}
		return  dedupedId;
	}
	
	public UUID determindDedupId(com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
		String dedupSessionKey = dedupHelper.getAuthenticationHeader();
		logger.info("Calling Dedup Service for "+baseClient.getFirstName());
		String dedup = dedupHelper.getDedupedClient(baseClient,dedupSessionKey);
		if(StringUtils.isNotBlank(dedup)) {
			return UUID.fromString(dedup);
		}
		return null;
	}
	
}
