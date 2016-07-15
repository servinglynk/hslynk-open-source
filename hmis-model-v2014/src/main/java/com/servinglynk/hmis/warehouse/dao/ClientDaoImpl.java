/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.base.util.DedupHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ClientDaoImpl extends ParentDaoImpl implements ClientDao {
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ClientDaoImpl.class);
	@Autowired
	DedupHelper dedupHelper;
	
	@Autowired
	ParentDaoFactory daoFactory;
	
	@Override
	@Transactional
	public void hydrateStaging(ExportDomain domain) throws Exception {
	
		Export export = domain.getExport();
		//Lets make a microservice all to the dedup micro service
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(domain.getUpload().getProjectGroupCode());
		Boolean skipClientIdentifier = projectGroupEntity !=null && !projectGroupEntity.isSkipuseridentifers();
		List<Client> clients = export.getClient();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		if (clients != null && clients.size() > 0) {
			for (Client client : clients) {
				try {
				com.servinglynk.hmis.warehouse.model.v2014.Client clientModel = getModelObject(domain, client,data);
				clientModel.setFirstName(client.getFirstName());
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
				if(exportEntity !=null)
					exportEntity.addClient(clientModel);
			//	clientModel.setUser(exportEntity.getUser());
				clientModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateCreated()));
				clientModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateUpdated()));
				clientModel.setExport(exportEntity);
				//TODO: Sandeep need to get the project group from the base schema.
				com.servinglynk.hmis.warehouse.model.base.Client target = new com.servinglynk.hmis.warehouse.model.base.Client();
				BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
				if(clientModel.isInserted()) {
					target.setDateCreated(LocalDateTime.now());
					insert(target);
				}
				if(skipClientIdentifier) {
					logger.info("Calling Dedup Service for "+clientModel.getFirstName());
					String dedupedId = dedupHelper.getDedupedClient(target);
					logger.info("Dedup Id is ##### "+dedupedId);
					if(dedupedId != null) {
						clientModel.setDedupClientId(UUID.fromString(dedupedId));	
					}
				}else {
					clientModel.setFirstName("");
					clientModel.setLastName("");
					clientModel.setSsn("");
					clientModel.setMiddleName("");
					try {
						LocalDateTime dob = clientModel.getDob();
						if(dob !=null) {
							LocalDateTime newDob = LocalDateTime.of(dob.getYear(), dob.getMonth(), 01, dob.getHour(), dob.getHour(),dob.getMinute(),dob.getSecond());
							clientModel.setDob(newDob);
						}
					}catch(Exception e) {
						// Eat this exception.
					}
				}
				//clientModel.setProjectGroupCode(clientModel.getUser());
				if(clientModel.getDedupClientId() !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.Client dedupedClient = getClientByDedupCliendId(clientModel.getDedupClientId(),clientModel.getProjectGroupCode());
					/**
					 * This is where the deduping happens We check if a client with the same information exists and
					 *  If it exist then the dedupClient Object below will not be null and we will pass on its ID into the enrollment object later on.
					 *  But if a client does not exist we create a new client and the ClientUUID is passed on to the map.
					 *  This will we will not create new client records in the client table if a client is enrollment at multiple organizations.
					 */
					if(dedupedClient !=null) {
						clientModel.setId(dedupedClient.getId());
					}
				}
					performSaveOrUpdate(clientModel);
				} catch(Exception e ){
					String errorMessage = "Exception beause of the client::"+client.getPersonalID() +" Exception ::"+e.getMessage();
					logger.error(errorMessage);
					throw new Exception(errorMessage, e);
				}
			}
	}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Client.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Client getModelObject(ExportDomain domain, Client client ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Client clientModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			clientModel = (com.servinglynk.hmis.warehouse.model.v2014.Client) getModel(com.servinglynk.hmis.warehouse.model.v2014.Client.class, client.getPersonalID(), getProjectGroupCode(domain),false);
		
		if(clientModel == null) {
			clientModel = new com.servinglynk.hmis.warehouse.model.v2014.Client();
			clientModel.setId(UUID.randomUUID());
			clientModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(clientModel, domain,client.getPersonalID(),data.i+data.j);
		return clientModel;
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
	public com.servinglynk.hmis.warehouse.model.v2014.Client createClient(
			com.servinglynk.hmis.warehouse.model.v2014.Client client) {
			client.setId(UUID.randomUUID());
			insert(client);
			com.servinglynk.hmis.warehouse.model.base.Client baseClient = new com.servinglynk.hmis.warehouse.model.base.Client();
			BeanUtils.copyProperties(client, baseClient);
			baseClient.setSchemaYear("2014");
			insert(baseClient);
		return client;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Client updateClient(
			com.servinglynk.hmis.warehouse.model.v2014.Client client) {
			update(client);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.v2014.Client client) {
			delete(client);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Client getClientById(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);
		criteria.add(Restrictions.eq("id", clientId));
		List<com.servinglynk.hmis.warehouse.model.v2014.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2014.Client>) findByCriteria(criteria);
		if(clients.size()>0) return clients.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Client getClientByDedupCliendId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2014.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2014.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Client getClientByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2014.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2014.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2014.Client> getAllClients(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);	
		List<com.servinglynk.hmis.warehouse.model.v2014.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2014.Client>) findByCriteria(criteria,startIndex,maxItems);
		return clients;
	}
	
	public long getClientsCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);	
		return countRows(criteria);
	}
}
