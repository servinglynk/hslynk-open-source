
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
import java.util.Map;
import java.util.UUID;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import com.servinglynk.hmis.warehouse.base.util.DedupHelper;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.FirstName;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.LastName;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.MiddleName;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.SSN;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;
import com.servinglynk.hmis.warehouse.enums.HashStatusEnum;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
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
	ParentDaoFactory daoFactory;
	
	@Autowired
	DedupHelper dedupHelper;
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {

		Export export = domain.getExport();
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class, String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap, domain.getUpload().getId());
		Data data = new Data();
		String projectGroupCode= getProjectGroupCode(domain);
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, projectGroupCode);
		List<Client> clients = export.getClient();
		if (CollectionUtils.isNotEmpty(clients)) {
			for (Client client : clients) {
				com.servinglynk.hmis.warehouse.model.v2020.Client clientModel = null;
				try {
					clientModel = (com.servinglynk.hmis.warehouse.model.v2020.Client) modelMap.get(client.getPersonalID());
					if(clientModel == null) {
						clientModel = new com.servinglynk.hmis.warehouse.model.v2020.Client();
						clientModel.setRecordToBeInserted(true);
						clientModel.setId(UUID.randomUUID());
					}
					populateClient(client, clientModel);
					
					clientModel
							.setDobDataQuality(ClientDobDataQualityEnum
									.lookupEnum(client
													.getDOBDataQuality()));
					clientModel.setEthnicity(ClientEthnicityEnum
							.lookupEnum(String.valueOf(client.getEthnicity())));
					clientModel.setGender(ClientGenderEnum.lookupEnum(String
							.valueOf(client.getGender())));

					clientModel
							.setNameDataQuality(ClientNameDataQualityEnum
									.lookupEnum(client
													.getNameDataQuality()));
					clientModel.setNameSuffix(client.getNameSuffix());
					List<String> race = client.getRace();
					if(CollectionUtils.isNotEmpty(race)) {
						clientModel.setRace(ClientRaceEnum
								.lookupEnum(race.get(0)));
						if(race.size() > 1) {
							clientModel.setRace1(ClientRaceEnum
									.lookupEnum(race.get(1)));
						}
					}
					clientModel
							.setSsnDataQuality(ClientSsnDataQualityEnum
									.lookupEnum(client
													.getSSNDataQuality()));
					clientModel
							.setVeteranStatus(ClientVeteranStatusEnum
									.lookupEnum(client
													.getVeteranStatus()));
					clientModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateCreated()));
					clientModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateUpdated()));
					clientModel.setExport(exportEntity);
					hydrateCommonFields(clientModel, domain, client.getPersonalID(), data);
					//makes a microservice all to the dedup micro service
					if(!clientModel.isIgnored()) {
						if(!clientModel.isRecordToBoInserted()) {
							++data.j;
						}
						if(clientModel.isRecordToBoInserted()) {
							++data.i;
						}
					}
					com.servinglynk.hmis.warehouse.model.base.Client  target = new com.servinglynk.hmis.warehouse.model.base.Client();
					BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
					UUID dedupId = daoFactory.getHmisClientDao().determindDedupId(target,projectGroupCode);
					clientModel.setDedupClientId(dedupId);
//					createOrUpdatebaseCleint(target);
//					
//					performSaveOrUpdate(clientModel,domain);
					
					// Inserting client in base schema	
					target.setDateUpdated(LocalDateTime.now());
					target.setSchemaYear("2020");
					target.setId(clientModel.getId());
					target.setDedupClientId(clientModel.getDedupClientId());
					createOrUpdatebaseCleint(target);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					String errorMessage = "Exception beause of the client::" + client.toString() + " Exception ::" + e.getMessage();
					if(clientModel != null){
						Error2020 error = new Error2020();
						error.model_id = clientModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = clientModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = clientModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Client.class.getSimpleName(), domain, exportEntity);
	}
	
	
    private com.servinglynk.hmis.warehouse.model.v2020.Client getClientFromDedup(com.servinglynk.hmis.warehouse.model.v2020.Client clientModel,Client client, String projectGroupCode) {
    	com.servinglynk.hmis.warehouse.model.base.Client  target = new com.servinglynk.hmis.warehouse.model.base.Client();
		BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
		UUID dedupId = daoFactory.getHmisClientDao().determindDedupId(target,projectGroupCode);
		
		com.servinglynk.hmis.warehouse.model.v2020.Client clientByDedupCliendId = getClientByDedupCliendId(dedupId, projectGroupCode);
		if(clientByDedupCliendId != null) {
			clientByDedupCliendId.setRecordToBeInserted(false);
		}else {
			 clientByDedupCliendId = new com.servinglynk.hmis.warehouse.model.v2020.Client();
			 clientByDedupCliendId.setRecordToBeInserted(true);
			 clientByDedupCliendId.setDedupClientId(dedupId);
			 clientByDedupCliendId.setId(UUID.randomUUID());
		}
		populateClient(client, clientByDedupCliendId);
		return clientByDedupCliendId;
	}


	public void populateClient(Client client,com.servinglynk.hmis.warehouse.model.v2020.Client clientModel) {
		LastName lastName = client.getLastName();
		if (lastName != null) {
			clientModel.setLastName(lastName.getValue());
			clientModel.setLastNameHashStatus(HashStatusEnum.lookupEnum(lastName.getHashStatus()));
		}
		MiddleName middleName = client.getMiddleName();
		if (middleName != null) {
			clientModel.setMiddleName(middleName.getValue());
			clientModel.setMiddleNameHashStatus(HashStatusEnum.lookupEnum(middleName.getHashStatus()));
		}
		FirstName firstName = client.getFirstName();
		if (firstName != null) {
			clientModel.setFirstName(firstName.getValue());
			clientModel.setFirstNameHashStatus(HashStatusEnum.lookupEnum(firstName.getHashStatus()));
		}
		clientModel.setDob(BasicDataGenerator.getLocalDateTime(client
				.getDOB()));
		SSN ssn = client.getSSN();
		if (ssn != null) {
			clientModel.setSsn(ssn.getValue());
			clientModel.setSsnHashStatus(HashStatusEnum.lookupEnum(ssn.getHashStatus()));
		}
    }
	
	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.v2020.Client client) {
			if(client !=null) {
				com.servinglynk.hmis.warehouse.model.v2020.Client target = new com.servinglynk.hmis.warehouse.model.v2020.Client();
				BeanUtils.copyProperties(client, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) get(com.servinglynk.hmis.warehouse.model.v2020.Export.class, client.getExport().getId());
				exportEntity.addClient(target);
				target.setExport(exportEntity);
//				com.servinglynk.hmis.warehouse.model.v2020.Client clientByDedupCliendId = getClientByDedupCliendId(client.getDedupClientId(),client.getProjectGroupCode());
				/*if(clientByDedupCliendId ==null) {
					insert(target);	
				}*/
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
	public com.servinglynk.hmis.warehouse.model.v2020.Client createClient(
			com.servinglynk.hmis.warehouse.model.v2020.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
			client.setId(UUID.randomUUID());
			baseClient.setSchemaYear("2020");
			client.setDateUpdated(LocalDateTime.now());
			baseClient.setDateUpdated(LocalDateTime.now());
			insert(client);
			baseClient.setId(client.getId());
			insert(baseClient);
			createOrUpdatebaseCleint(baseClient);
			return client;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Client updateClient(
			com.servinglynk.hmis.warehouse.model.v2020.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
		baseClient.setSchemaYear("2020");
			update(client);
			update(baseClient);
			createOrUpdatebaseCleint(baseClient);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.v2020.Client client) {
			delete(client);
			deleteCacheClient(client);
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Client getClientById(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Client.class);
    criteria.add(Restrictions.eq("id", clientId));
		List<com.servinglynk.hmis.warehouse.model.v2020.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2020.Client>) findByCriteria(criteria);
		if(clients.size()>0) return clients.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Client getClientByDedupCliendId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		criteria.add(Restrictions.isNull("parentId"));
		List<com.servinglynk.hmis.warehouse.model.v2020.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2020.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2020.Client getClientByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2020.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2020.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.Client> getAllClients(String projectGroupCode, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Client.class);	
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2020.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2020.Client>) findByCriteria(criteria,startIndex,maxItems);
		return clients;
	}
	
	public long getClientsCount(String projectGroupCode){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Client.class);	
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return countRows(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.Client> getAllNullDedupIdClients() {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Client.class);
		List<String> allActiveProjectGroupCodes = daoFactory.getProjectGroupDao().getAllActiveProjectGroupCodes();
		criteria.add(Restrictions.isNull("dedupClientId"));
		Criterion firstNameCriterion = Restrictions.isNotNull("firstName");
		Criterion lastNameCriterion = Restrictions.isNotNull("lastName");
		criteria.add(Restrictions.and(firstNameCriterion,lastNameCriterion));
		criteria.add(Restrictions.in("projectGroupCode", allActiveProjectGroupCodes));
		
		Criterion nullVersionCriterion = Restrictions.isNull("version");
		Criterion versionLessThan3Criterion = Restrictions.le("version",3L);
		criteria.add(Restrictions.or(nullVersionCriterion,versionLessThan3Criterion));
		List<com.servinglynk.hmis.warehouse.model.v2020.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2020.Client>) findByCriteria(criteria);
		return clients;
	}
	
	@Override
	public void updateDedupClient(
			com.servinglynk.hmis.warehouse.model.v2020.Client client,String dedupSessionKey) {
	    com.servinglynk.hmis.warehouse.model.base.Client basClient = daoFactory.getBaseClientDao().getClient(client.getId());
	    if(basClient == null) {
	    	basClient = new  com.servinglynk.hmis.warehouse.model.base.Client();
	    	BeanUtils.copyProperties(client, basClient, new String[] {"enrollments","veteranInfoes"});
	    	basClient.setSchemaYear("2020");
	     }
	    try{
	    	 String  dedupedId = dedupHelper.getDedupedClient(basClient,dedupSessionKey);
		     logger.info("Calling Dedup Service for "+client.getFirstName());
			 client.setDateUpdated(LocalDateTime.now());
			 if(StringUtils.isNotBlank(dedupedId)) {
				 client.setDedupClientId(UUID.fromString(dedupedId));
				 basClient.setDedupClientId(UUID.fromString(dedupedId));
				 basClient.setDateUpdated(LocalDateTime.now());
				 insert(basClient);
				 getCurrentSession().flush();
				 getCurrentSession().clear();
			 }
			 Long version = client.getVersion();
		    	if(version != null) {
		    		version++;
		    	} else {
		    		version = 1L;
		    	}
		    	client.setVersion(version);
			 getCurrentSession().update(client);
	    }catch(Exception e) {
	    	Long version = client.getVersion();
	    	if(version != null) {
	    		version++;
	    	} else {
	    		version = 1L;
	    	}
	    	client.setVersion(version);
	    	getCurrentSession().update(client);
	    	logger.error("Error populate dedup id for client: "+client.getId() + " name :"+ client.getFirstName(),e);
	    }
	    
	}
	
	@Autowired JmsTemplate jmsMessagingTemplate;
	
	public void createOrUpdatebaseCleint(com.servinglynk.hmis.warehouse.model.base.Client baseCleint) {

		ActiveMQQueue queue = new ActiveMQQueue("cache.base.cleint");
		try {
			jmsMessagingTemplate.convertAndSend(queue,JsonUtil.coneveterObejctToString(baseCleint));
		} catch (JmsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCacheClient(com.servinglynk.hmis.warehouse.model.v2020.Client client) {

		ActiveMQQueue queue = new ActiveMQQueue("delete.cached.base.cleint");
		try {
			jmsMessagingTemplate.convertAndSend(queue,  client.getId()+"");
		} catch (JmsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
