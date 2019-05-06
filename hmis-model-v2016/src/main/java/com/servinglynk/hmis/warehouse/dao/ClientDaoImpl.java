
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

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.DedupHelper;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.common.security.AuditUtil;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
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
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2016.Error2016;
import com.servinglynk.hmis.warehouse.model.v2016.HmisBaseModel;
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
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {

		Export export = domain.getExport();
		com.servinglynk.hmis.warehouse.model.v2016.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2016.Export) getModel(com.servinglynk.hmis.warehouse.model.v2016.Export.class, String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap, domain.getUpload().getId());
		Data data = new Data();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2016.Client.class, getProjectGroupCode(domain));
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(domain.getUpload().getProjectGroupCode());
		List<Client> clients = export.getClient();
		if (clients != null && clients.size() > 0) {
			for (Client client : clients) {
				com.servinglynk.hmis.warehouse.model.v2016.Client clientModel = null;
				try {
					clientModel = (com.servinglynk.hmis.warehouse.model.v2016.Client) modelMap.get(client.getPersonalID());
					if(clientModel != null) {
						if(projectGroupEntity.isDetermineDedupBySsid()) {
							clientModel.setRecordToBeInserted(false);
						}
					}else {
						clientModel = new com.servinglynk.hmis.warehouse.model.v2016.Client();
						clientModel.setId(UUID.randomUUID());
						clientModel.setRecordToBeInserted(true);
					}
					populateClient(client, clientModel);
					/**
					 * This is where the deduping happens We check if a client with the same information exists and
					 *  If it exist then the dedupClient Object below will not be null and we will pass on its ID into the enrollment object later on.
					 *  But if a client does not exist we create a new client and the ClientUUID is passed on to the map.
					 *  This will we will not create new client records in the client table if a client is enrollment at multiple organizations.
					 */
					if(clientModel.isRecordToBoInserted()) {
						clientModel = getClientFromDedup(clientModel, client, getProjectGroupCode(domain));
					}

					clientModel.setDateCreatedFromSource(BasicDataGenerator
							.getLocalDateTime(client.getDateCreated()));
					clientModel
							.setDobDataQuality(ClientDobDataQualityEnum
									.lookupEnum(BasicDataGenerator
											.getStringValue(client
													.getDOBDataQuality())));
					clientModel.setEthnicity(ClientEthnicityEnum
							.lookupEnum(String.valueOf(client.getEthnicity())));
					clientModel.setGender(ClientGenderEnum.lookupEnum(String
							.valueOf(client.getGender())));
					if (client.getMiddleName() != null) {
						clientModel.setMiddleName(client.getMiddleName().getValue());
					}

					clientModel
							.setNameDataQuality(ClientNameDataQualityEnum
									.lookupEnum(BasicDataGenerator
											.getStringValue(client
													.getNameDataQuality())));
					clientModel.setNameSuffix(client.getNameSuffix());
//					clientModel.setOtherGender(client.getOtherGender());
					clientModel.setRace(ClientRaceEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(client.getRace())));
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
					clientModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateCreated()));
					clientModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(client.getDateUpdated()));
					clientModel.setExport(exportEntity);
					//makes a microservice all to the dedup micro service
					performSaveOrUpdate(clientModel);
					hydrateCommonFields(clientModel, domain, client.getPersonalID(), data);
					if(!clientModel.isIgnored()) {
						if(!clientModel.isRecordToBoInserted()) {
							++data.j;
						}
						if(clientModel.isRecordToBoInserted()) {
							++data.i;
						}
					}
					UUID userId = clientModel.getUserId();
					if(clientModel.isRecordToBoInserted()) {
						daoFactory.getClientTrackerDao().createTracker(clientModel.getId(), clientModel.getProjectGroupCode(), clientModel.isDeleted(), "INSERT","BULK_UPLOAD",userId != null ? userId.toString() : null);
					}
					if(!clientModel.isRecordToBoInserted()){
						daoFactory.getClientTrackerDao().createTracker(clientModel.getId(), clientModel.getProjectGroupCode(), clientModel.isDeleted(), "UPDATE","BULK_UPLOAD",userId != null ? userId.toString() : null);
					}
					// Inserting client in base schema	
					if(!clientModel.isIgnored()) {
						com.servinglynk.hmis.warehouse.model.base.Client target = new com.servinglynk.hmis.warehouse.model.base.Client();
						BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
						target.setDateUpdated(LocalDateTime.now());
						target.setSchemaYear("2016");
						insertOrUpdate(target);	
					}
//					}
				} catch (Exception e) {
					String errorMessage = "Exception beause of the client::" + client.toString() + " Exception ::" + e.getMessage();
					if(clientModel != null){
						Error2016 error = new Error2016();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2016.Client.class.getSimpleName(), domain, exportEntity);
	}
	
	
	  private com.servinglynk.hmis.warehouse.model.v2016.Client getClientFromDedup(com.servinglynk.hmis.warehouse.model.v2016.Client clientModel,Client client, String projectGroupCode) {
	    	com.servinglynk.hmis.warehouse.model.base.Client  target = new com.servinglynk.hmis.warehouse.model.base.Client();
			BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
			UUID dedupId = daoFactory.getHmisClientDao().determindDedupId(target,projectGroupCode);
			com.servinglynk.hmis.warehouse.model.v2016.Client clientByDedupCliendId = getClientByDedupCliendId(dedupId, projectGroupCode);
			if(clientByDedupCliendId != null) {
				clientModel.setRecordToBeInserted(false);
				populateClient(client, clientByDedupCliendId);
			}
			return clientByDedupCliendId;
		}


		public void populateClient(Client client,com.servinglynk.hmis.warehouse.model.v2016.Client clientModel) {
			if (client.getLastName() != null) {
				clientModel.setLastName(client.getLastName().getValue());
			}
			if (client.getMiddleName() != null) {
				clientModel.setMiddleName(client.getMiddleName().getValue());
			}
			if (client.getFirstName() != null) {
				clientModel.setFirstName(client.getFirstName().getValue());
			}
			clientModel.setDob(BasicDataGenerator.getLocalDateTime(client
					.getDOB()));
			if (client.getSSN() != null) {
				clientModel.setSsn(client.getSSN().getValue());
			}
	    }
	
	
	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.v2016.Client client) {
			if(client !=null) {
				com.servinglynk.hmis.warehouse.model.v2016.Client target = new com.servinglynk.hmis.warehouse.model.v2016.Client();
				BeanUtils.copyProperties(client, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2016.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2016.Export) get(com.servinglynk.hmis.warehouse.model.v2016.Export.class, client.getExport().getId());
				exportEntity.addClient(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2016.Client clientByDedupCliendId = getClientByDedupCliendId(client.getDedupClientId(),client.getProjectGroupCode());
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
	public com.servinglynk.hmis.warehouse.model.v2016.Client createClient(
			com.servinglynk.hmis.warehouse.model.v2016.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
			client.setId(UUID.randomUUID());
			baseClient.setSchemaYear("2016");
			client.setDateUpdated(LocalDateTime.now());
			baseClient.setDateUpdated(LocalDateTime.now());
			insert(client);
			baseClient.setId(client.getId());
			insert(baseClient);	
			return client;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2016.Client updateClient(
			com.servinglynk.hmis.warehouse.model.v2016.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
		baseClient.setSchemaYear("2016");
			update(client);
			update(baseClient);
			daoFactory.getClientTrackerDao().createTracker(client.getId(), client.getProjectGroupCode(), client.isDeleted(), "UPDATE",null,null);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.v2016.Client client) {
			delete(client);
			daoFactory.getClientTrackerDao().createTracker(client.getId(), client.getProjectGroupCode(), true, "DELETE",null,null);
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2016.Client getClientById(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Client.class);
		List<UUID> shatedClients = AuditUtil.getSharedClients();		
		criteria.add(Restrictions.eq("id", clientId));
		if(shatedClients.contains(clientId)) {
		}else {
			criteria.add(Restrictions.eq("projectGroupCode", AuditUtil.getLoginUserProjectGroup()));			
		}
			criteria.add(Restrictions.eq("deleted", false));

		List<com.servinglynk.hmis.warehouse.model.v2016.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2016.Client>) getByCriteria(criteria);
		if(clients.size()>0) return clients.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2016.Client getClientByDedupCliendId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2016.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2016.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2016.Client getClientByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2016.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2016.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2016.Client> getAllClients(String projectGroupCode, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Client.class);	
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2016.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2016.Client>) findByCriteria(criteria,startIndex,maxItems);
		return clients;
	}
	
	public long getClientsCount(String projectGroupCode){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Client.class);	
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return countRows(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2016.Client> getAllNullDedupIdClients() {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Client.class);
		criteria.add(Restrictions.isNull("dedupClientId"));
		criteria.add(Restrictions.isNotNull("firstName"));
		criteria.add(Restrictions.isNotNull("lastName"));
		List<String> allActiveProjectGroupCodes = daoFactory.getProjectGroupDao().getAllActiveProjectGroupCodes();
		criteria.add(Restrictions.in("projectGroupCode", allActiveProjectGroupCodes));
		List<com.servinglynk.hmis.warehouse.model.v2016.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2016.Client>) findByCriteria(criteria);
		return clients;
	}
	
	@Override
	public void updateDedupClient(
			com.servinglynk.hmis.warehouse.model.v2016.Client client,String dedupSessionKey) {
	    com.servinglynk.hmis.warehouse.model.base.Client basClient = daoFactory.getBaseClientDao().getClient(client.getId());
	    if(basClient == null) {
	    	basClient = new  com.servinglynk.hmis.warehouse.model.base.Client();
	    	BeanUtils.copyProperties(client, basClient, new String[] {"enrollments","veteranInfoes"});
	    	basClient.setSchemaYear("2016");
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
}
