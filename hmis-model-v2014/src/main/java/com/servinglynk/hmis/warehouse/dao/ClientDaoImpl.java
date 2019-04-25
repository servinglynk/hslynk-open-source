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
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.DedupHelper;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.common.security.AuditUtil;
import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;
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
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ClientDaoImpl extends ParentDaoImpl<com.servinglynk.hmis.warehouse.model.v2014.Client> implements ClientDao {
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ClientDaoImpl.class);
	@Autowired
	DedupHelper dedupHelper;
	
	@Autowired
	ParentDaoFactory daoFactory;
	
	protected String dedupSessionKey = null;
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
	
		Export export = domain.getExport();
		//Lets make a microservice all to the dedup micro service
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(domain.getUpload().getProjectGroupCode());
		Boolean skipClientIdentifier = projectGroupEntity !=null && projectGroupEntity.isSkipuseridentifers();
		List<Client> clients = export.getClient();
		try {
			dedupSessionKey = dedupHelper.getAuthenticationHeader();
		}catch(Exception e) {
			logger.error("Throwing an error while getting the dedup session id"+e.getStackTrace());
		}
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Client.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Client.class, getProjectGroupCode(domain));
		if (CollectionUtils.isNotEmpty(clients)) {
			for(Client client : clients) {
				processData(client, domain, data, modelMap, dedupSessionKey, skipClientIdentifier,exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Client.class.getSimpleName(), domain, exportEntity);
	}
	public void processData(Client client,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,String dedupSessionKey,Boolean skipClientIdentifier,com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
			com.servinglynk.hmis.warehouse.model.v2014.Client model = null;
			try {
			model = getModelObject(domain, client,data,modelMap,dedupSessionKey,skipClientIdentifier);
			model.setFirstName(client.getFirstName());
			model.setDob(BasicDataGenerator.getLocalDateTime(client
					.getDOB()));
			model
					.setDobDataQuality(ClientDobDataQualityEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(client
											.getDOBDataQuality())));
			model.setEthnicity(ClientEthnicityEnum
					.lookupEnum(String.valueOf(client.getEthnicity())));
			model.setGender(ClientGenderEnum.lookupEnum(String
					.valueOf(client.getGender())));
			model.setLastName(client.getLastName());
			model.setMiddleName(client.getMiddleName());
			model
					.setNameDataQuality(ClientNameDataQualityEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(client
											.getNameDataQuality())));
			model.setNameSuffix(client.getNameSuffix());
			model.setOtherGender(client.getOtherGender());
			model.setRace(ClientRaceEnum
					.lookupEnum(BasicDataGenerator
							.getStringValue(client.getRace())));
			model.setSsn(client.getSSN());
			model
					.setSsnDataQuality(ClientSsnDataQualityEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(client
											.getSSNDataQuality())));
			model
					.setVeteranStatus(ClientVeteranStatusEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(client
											.getVeteranStatus())));
			model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateUpdated()));
			model.setExport(exportEntity);
			performSaveOrUpdate(model);	
			UUID userId = model.getUserId();
			if(model.isRecordToBoInserted()) {
				daoFactory.getClientTrackerDao().createTracker(model.getId(), model.getProjectGroupCode(), model.isDeleted(), "INSERT","BULK_UPLOAD",userId != null ? userId.toString() : null);
			}
			if(!model.isRecordToBoInserted()){
				daoFactory.getClientTrackerDao().createTracker(model.getId(), model.getProjectGroupCode(), model.isDeleted(), "UPDATE","BULK_UPLOAD",userId != null ? userId.toString() : null);
			}
			// Inserting client in base schema	
			if(!model.isIgnored()) {
				com.servinglynk.hmis.warehouse.model.base.Client base = new com.servinglynk.hmis.warehouse.model.base.Client();
				BeanUtils.copyProperties(model, base, new String[] {"enrollments","veteranInfoes"});
				base.setDateUpdated(LocalDateTime.now());
				base.setSchemaYear("2014");
				insertOrUpdate(base);	
			}
			// Inserting client in base schema		
		
			} catch(Exception ex ){
				String errorMessage = "Exception because of the client::"+client.getPersonalID() +" Exception ::"+ex.getMessage();
				if(model != null){
					Error2014 error = new Error2014();
					error.model_id = model.getId();
					error.bulk_upload_ui = domain.getUpload().getId();
					error.project_group_code = domain.getUpload().getProjectGroupCode();
					error.source_system_id = model.getSourceSystemId();
					error.type = ErrorType.ERROR;
					error.error_description = errorMessage;
					error.date_created = model.getDateCreated();
					performSave(error);
				}
				logger.error(errorMessage);
			}
	}
	/**
	 * This is where the deduping happens We check if a client with the same information exists and
	 *  If it exist then the dedupClient Object below will not be null and we will pass on its ID into the enrollment object later on.
	 *  But if a client does not exist we create a new client and the ClientUUID is passed on to the map.
	 *  This will we will not create new client records in the client table if a client is enrollment at multiple organizations.
	 */
	public com.servinglynk.hmis.warehouse.model.v2014.Client getUniqueClient(String dedupSessionKey,Boolean skipClientIdentifier,com.servinglynk.hmis.warehouse.model.v2014.Client clientModelFromDB,com.servinglynk.hmis.warehouse.model.v2014.Client clientModel,boolean forAPI) {
		com.servinglynk.hmis.warehouse.model.base.Client  target = new com.servinglynk.hmis.warehouse.model.base.Client();
		BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
		if(!skipClientIdentifier) {
			logger.info("Calling Dedup Service for "+clientModel.getFirstName());
			String dedupedId = dedupHelper.getDedupedClient(target,dedupSessionKey);
			logger.info("Dedup Id is ##### "+dedupedId);
			if(dedupedId != null) {
				UUID dedupId = UUID.fromString(dedupedId);
				if(clientModelFromDB == null && forAPI && dedupedId != null && StringUtils.isNotBlank(clientModel.getProjectGroupCode())) {
					com.servinglynk.hmis.warehouse.model.v2014.Client dedupClientFromDB = getClientByDedupCliendId(dedupId,clientModel.getProjectGroupCode());
					modelMatch(dedupClientFromDB, clientModel);
				}
				if(!forAPI && clientModelFromDB !=null) {
					modelMatch(clientModelFromDB, clientModel);
				}
				clientModel.setDedupClientId(dedupId);
			}
		}else {
			if(clientModelFromDB !=null) {
				clientModelFromDB.setFirstName("");
				clientModelFromDB.setLastName("");
				clientModelFromDB.setSsn("");
				clientModelFromDB.setMiddleName("");
				try {
					LocalDateTime dob = clientModelFromDB.getDob();
					if(dob !=null) {
						LocalDateTime newDob = LocalDateTime.of(dob.getYear(), dob.getMonth(), 01, dob.getHour(), dob.getHour(),dob.getMinute(),dob.getSecond());
						clientModelFromDB.setDob(newDob);
					}
					return clientModelFromDB;
				}catch(Exception e) {
					// Eat this exception.
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
		}
		return clientModel;
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Client getModelObject(ExportDomain domain, Client client ,Data data, Map<String,HmisBaseModel> modelMap, String dedupSessionKey, Boolean skipClientIdentifier) {
		com.servinglynk.hmis.warehouse.model.v2014.Client modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain)) {
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Client) getModel(com.servinglynk.hmis.warehouse.model.v2014.Client.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Client.class, client.getPersonalID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		}
		com.servinglynk.hmis.warehouse.model.v2014.Client model = new com.servinglynk.hmis.warehouse.model.v2014.Client(); 
		if(client != null) {
			model.setFirstName(client.getFirstName() != null ?client.getFirstName():null);
			model.setLastName(client.getLastName() != null ?client.getLastName():null);
			model.setDob(BasicDataGenerator.getLocalDateTime(client
					.getDOB()));
			model.setGender(ClientGenderEnum.lookupEnum(String
					.valueOf(client.getGender())));
			model
			.setSsnDataQuality(ClientSsnDataQualityEnum
					.lookupEnum(BasicDataGenerator
							.getStringValue(client
									.getSSNDataQuality())));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateUpdated()));
		}
		if(modelFromDB == null) {
			model.setId(UUID.randomUUID());
			model.setRecordToBeInserted(true);
		}
		model = getUniqueClient(dedupSessionKey, skipClientIdentifier,modelFromDB,model,false);
		if(!isFullRefresh(domain)) {
			if(!model.isIgnored()) {
				if(!model.isRecordToBoInserted()) {
					++data.j;
				}
				if(model.isRecordToBoInserted()) {
					++data.i;
				}
			}
		}
		hydrateCommonFields(model, domain,client.getPersonalID(),data);
		performMatch(domain,modelFromDB,model,data);
		return model;
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
			com.servinglynk.hmis.warehouse.model.v2014.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
			client.setId(UUID.randomUUID());
			baseClient.setSchemaYear("2014");
			String projectGroupCode = AuditUtil.getLoginUserProjectGroup();
			UUID dedupedId = daoFactory.getHmisClientDao().determindDedupId(baseClient, projectGroupCode);
			if(dedupedId!=null) {
				client.setDedupClientId(dedupedId);
				baseClient.setDedupClientId(dedupedId);
			}
			client.setDateUpdated(LocalDateTime.now());
			baseClient.setDateUpdated(LocalDateTime.now());
			// Lets check if a client exits in the same schema version and if does update the client.
			com.servinglynk.hmis.warehouse.model.v2014.Client clientByDedupCliendId = getClientByDedupCliendId(dedupedId, projectGroupCode);
			if(clientByDedupCliendId == null) {
				insert(client);
				baseClient.setId(client.getId());
				insert(baseClient);
			}else {
				update(client);
				baseClient.setId(client.getId());
				update(baseClient);
			}
		return client;
	}

	
	@SuppressWarnings("unchecked")
	public Client getClientByssid(final String ssid,final String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(Restrictions.eq("source_system_id", ssid.trim()));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<Client> clients = (List<Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}
	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Client updateClient(
			com.servinglynk.hmis.warehouse.model.v2014.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
		baseClient.setSchemaYear("2014");
			update(client);
			update(baseClient);
			daoFactory.getClientTrackerDao().createTracker(client.getId(), client.getProjectGroupCode(), client.isDeleted(), "UPDATE", null, null);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.v2014.Client client) {
			delete(client);
			daoFactory.getClientTrackerDao().createTracker(client.getId(), client.getProjectGroupCode(), true, "DELETE",null,null);
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Client getClientById(UUID clientId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);

		List<UUID> shatedClients = AuditUtil.getSharedClients();		
		criteria.add(Restrictions.eq("id", clientId));
		if(shatedClients.contains(clientId)) {
		}else {
			criteria.add(Restrictions.eq("projectGroupCode", AuditUtil.getLoginUserProjectGroup()));			
		}
			criteria.add(Restrictions.eq("deleted", false));
		List<com.servinglynk.hmis.warehouse.model.v2014.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2014.Client>) getByCriteria(criteria);
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
	public List<com.servinglynk.hmis.warehouse.model.v2014.Client> getAllClients(String projectGroupCode, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);
		System.out.println(projectGroupCode);
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2014.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2014.Client>) findByCriteria(criteria,startIndex,maxItems);
		return clients;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2014.Client> getAllNullDedupIdClients() {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);
		criteria.add(Restrictions.isNull("dedupClientId"));
		criteria.add(Restrictions.neOrIsNotNull("firstName", ""));
		criteria.add(Restrictions.neOrIsNotNull("lastName", ""));
		List<String> allActiveProjectGroupCodes = daoFactory.getProjectGroupDao().getAllActiveProjectGroupCodes();
		criteria.add(Restrictions.in("projectGroupCode", allActiveProjectGroupCodes));
		List<com.servinglynk.hmis.warehouse.model.v2014.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2014.Client>) findByCriteria(criteria);
		return clients;
	}
		
	@Override
	public void updateDedupClient(
			com.servinglynk.hmis.warehouse.model.v2014.Client client,String dedupSessionKey) {
	    com.servinglynk.hmis.warehouse.model.base.Client basClient = daoFactory.getBaseClientDao().getClient(client.getId());
	    if(basClient == null) {
	    	basClient = new  com.servinglynk.hmis.warehouse.model.base.Client();
	    	BeanUtils.copyProperties(client, basClient, new String[] {"enrollments","veteranInfoes"});
	    	basClient.setSchemaYear("2014");
	     }
	     String  dedupedId = dedupHelper.getDedupedClient(basClient,dedupSessionKey);
	     logger.info("Calling Dedup Service for "+client.getFirstName());
		 client.setDateUpdated(LocalDateTime.now());
		 client.setDedupClientId(UUID.fromString(dedupedId));
		 getCurrentSession().update(client);
		 basClient.setDedupClientId(UUID.fromString(dedupedId));
		 basClient.setDateUpdated(LocalDateTime.now());
		 insert(basClient);
		 getCurrentSession().flush();
		 getCurrentSession().clear();
	}
	
	public long getClientsCount(String projectGroupCode){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Client.class);	
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return countRows(criteria);
	}
}
