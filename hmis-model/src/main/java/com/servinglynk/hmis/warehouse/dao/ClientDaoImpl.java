/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.dao.helper.DedupHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Gender;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.restful.model.AppRequest;
import com.servinglynk.hmis.warehouse.restful.model.AuthenticationRequest;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ClientDaoImpl extends ParentDaoImpl implements ClientDao {
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	
	@Autowired
	DedupHelper dedupHelper;
	
	@Autowired
	ParentDaoFactory daoFactory;
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
	
		Export export = domain.getExport();
		List<Client> clients = export.getClient();
		if (clients != null && clients.size() > 0) {
			for (Client client : clients) {
				com.servinglynk.hmis.warehouse.model.staging.Client clientModel = new com.servinglynk.hmis.warehouse.model.staging.Client();
				clientModel.setFirstName(client.getFirstName());
				clientModel.setDateCreated(BasicDataGenerator
						.getLocalDateTime(client.getDateCreated()));
				clientModel.setDob(BasicDataGenerator.getLocalDateTime(client
						.getDOB()));
				clientModel
						.setDobDataQuality(ClientDobDataQualityEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getDOBDataQuality())));
				clientModel.setEthnicity(ClientEthnicityEnum
						.lookupEnum(String.valueOf(client.getEthnicity())));
				clientModel.setGender(ClientGenderEnum.lookupEnum(String
						.valueOf(client.getGender())));
				clientModel.setLastName(client.getLastName());
				clientModel.setMiddleName(client.getMiddleName());
				clientModel
						.setNameDataQuality(ClientNameDataQualityEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getNameDataQuality())));
				clientModel.setNameSuffix(client.getNameSuffix());
				clientModel.setOtherGender(client.getOtherGender());
				clientModel.setRace(ClientRaceEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(client.getRace())));
				clientModel.setSsn(client.getSSN());
				clientModel
						.setSsnDataQuality(ClientSsnDataQualityEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getSSNDataQuality())));
				clientModel
						.setVeteranStatus(ClientVeteranStatusEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getVeteranStatus())));
				UUID clientUUID = UUID.randomUUID();
				clientModel.setId(clientUUID);
				UUID exportId = domain.getExportId();
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, exportId);
				exportEntity.addClient(clientModel);
				clientModel.setUser(exportEntity.getUser());
				clientModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateCreated()));
				clientModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateUpdated()));
				hydrateCommonFields(clientModel, domain);
				clientModel.setExport(exportEntity);
				//Lets make a microservice all to the dedup micro service
				ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(domain.getUpload().getProjectGroupCode());
				if(!projectGroupEntity.isSkipuseridentifers()) {
					String dedupedId = dedupHelper.getDedupedClient(clientModel);
					if(dedupedId != null) {
						clientModel.setDedupClientId(UUID.fromString(dedupedId));	
					}
				}
				//clientModel.setProjectGroupCode(clientModel.getUser());
				clientModel.setDateCreated(LocalDateTime.now());
				clientModel.setDateUpdated(LocalDateTime.now());
				
				if(clientModel.getDedupClientId() !=null) {
					com.servinglynk.hmis.warehouse.model.live.Client dedupedClient = getClientByDedupCliendId(clientModel.getDedupClientId());
					/**
					 * This is where the deduping happens We check if a client with the same information exists and
					 *  If it exist then the dedupClient Object below will not be null and we will pass on its ID into the enrollment object later on.
					 *  But if a client does not exist we create a new client and the ClientUUID is passed on to the map.
					 *  This will we will not create new client records in the client table if a client is enrollment at multiple organizations.
					 */
					if(dedupedClient !=null) {
						clientUUID = dedupedClient.getId();
					}
					else {
						insert(clientModel);	
					}	
				}else{
					insert(clientModel);
				}
				
				domain.getClientPersonalIDMap().put(client.getPersonalID(), clientUUID);
			}
	}
	}
	

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Client> clients = export.getClients();
		if(clients !=null && !clients.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Client client : clients) {
				com.servinglynk.hmis.warehouse.model.live.Client clientByDedupCliendId = getClientByDedupCliendId(client.getDedupClientId());
				if(clientByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.live.Client target = new com.servinglynk.hmis.warehouse.model.live.Client();
					BeanUtils.copyProperties(client, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					exportEntity.addClient(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
			}
		}
	}
	
	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Client client) {
			if(client !=null) {
				com.servinglynk.hmis.warehouse.model.live.Client target = new com.servinglynk.hmis.warehouse.model.live.Client();
				BeanUtils.copyProperties(client, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, client.getExport().getId());
				exportEntity.addClient(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.live.Client clientByDedupCliendId = getClientByDedupCliendId(client.getDedupClientId());
				if(clientByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	
	
    
	private Date getDateInFormat(String dob) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
        	formatter = new SimpleDateFormat("yyyy-MM-dd");
              date = (Date)((DateFormat) formatter).parse(dob);
            
            String s = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.live.Client createClient(
			com.servinglynk.hmis.warehouse.model.live.Client client) {
			client.setId(UUID.randomUUID());
			insert(client);
		return client;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.live.Client updateClient(
			com.servinglynk.hmis.warehouse.model.live.Client client) {
			update(client);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.live.Client client) {
			delete(client);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.live.Client getClientById(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Client.class);
		criteria.add(Restrictions.eq("id", clientId));
		List<com.servinglynk.hmis.warehouse.model.live.Client> clients = (List<com.servinglynk.hmis.warehouse.model.live.Client>) findByCriteria(criteria);
		if(clients.size()>0) return clients.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.live.Client getClientByDedupCliendId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.live.Client> clients = (List<com.servinglynk.hmis.warehouse.model.live.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.staging.Client getClientByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.staging.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.staging.Client> clients = (List<com.servinglynk.hmis.warehouse.model.staging.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.live.Client> getAllClients(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Client.class);	
		List<com.servinglynk.hmis.warehouse.model.live.Client> clients = (List<com.servinglynk.hmis.warehouse.model.live.Client>) findByCriteria(criteria,startIndex,maxItems);
		return clients;
	}
	
	
	public long getClientsCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Client.class);	
		return countRows(criteria);
	}
}
