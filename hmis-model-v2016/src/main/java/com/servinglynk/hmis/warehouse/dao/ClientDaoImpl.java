
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
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.DedupHelper;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
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
		Validator validator = (Validator) factory.getValidator();
		String dedupSessionKey = dedupHelper.getAuthenticationHeader();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2016.Client.class, getProjectGroupCode(domain));
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(domain.getUpload().getProjectGroupCode());
		Boolean skipClientIdentifier = projectGroupEntity != null && !projectGroupEntity.isSkipuseridentifers();
		List<Client> clients = export.getClient();
		if (clients != null && clients.size() > 0) {
			for (Client client : clients) {
				com.servinglynk.hmis.warehouse.model.v2016.Client clientModel = null;
				try {
					clientModel = getModelObject(domain, client, data, modelMap,dedupSessionKey,skipClientIdentifier);
					if (client.getFirstName() != null) {
						clientModel.setFirstName(client.getFirstName().getValue());
					}

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
					if (client.getLastName() != null) {
						clientModel.setLastName(client.getLastName().getValue());
					}
					if (client.getMiddleName() != null) {
						clientModel.setMiddleName(client.getMiddleName().getValue());
					}

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
					if (client.getSSN() != null) {
						clientModel.setSsn(client.getSSN().getValue());
					}
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
					
					// Inserting client in base schema	
					if(!clientModel.isIgnored()) {
						com.servinglynk.hmis.warehouse.model.base.Client target = new com.servinglynk.hmis.warehouse.model.base.Client();
						BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
						target.setDateUpdated(LocalDateTime.now());
						target.setSchemaYear("2015");
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
	
	
	public com.servinglynk.hmis.warehouse.model.v2016.Client getModelObject(ExportDomain domain, Client client ,Data data, Map<String,HmisBaseModel> modelMap, String dedupSessionKey, Boolean skipClientIdentifier) {
		com.servinglynk.hmis.warehouse.model.v2016.Client modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain)) {
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2016.Client) getModel(com.servinglynk.hmis.warehouse.model.v2016.Client.class, client.getPersonalID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		}
		com.servinglynk.hmis.warehouse.model.v2016.Client model = new com.servinglynk.hmis.warehouse.model.v2016.Client(); 
		if(client != null) {
			model.setFirstName(client.getFirstName() != null ?client.getFirstName().getValue():null);
			model.setLastName(client.getLastName() != null ?client.getLastName().getValue():null);
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
	
	
	/**
	 * This is where the deduping happens We check if a client with the same information exists and
	 *  If it exist then the dedupClient Object below will not be null and we will pass on its ID into the enrollment object later on.
	 *  But if a client does not exist we create a new client and the ClientUUID is passed on to the map.
	 *  This will we will not create new client records in the client table if a client is enrollment at multiple organizations.
	 */
	public com.servinglynk.hmis.warehouse.model.v2016.Client getUniqueClient(String dedupSessionKey,Boolean skipClientIdentifier,com.servinglynk.hmis.warehouse.model.v2016.Client clientModelFromDB,com.servinglynk.hmis.warehouse.model.v2016.Client clientModel,boolean forAPI) {
		com.servinglynk.hmis.warehouse.model.base.Client  target = new com.servinglynk.hmis.warehouse.model.base.Client();
		BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
		if(!skipClientIdentifier) {
			logger.info("Calling Dedup Service for "+clientModel.getFirstName());
			String dedupedId = dedupHelper.getDedupedClient(target,dedupSessionKey);
			logger.info("Dedup Id is ##### "+dedupedId);
			if(dedupedId != null) {
				UUID dedupId = UUID.fromString(dedupedId);
				if(clientModelFromDB == null && forAPI && dedupedId != null && StringUtils.isNotBlank(clientModel.getProjectGroupCode())) {
					com.servinglynk.hmis.warehouse.model.v2016.Client dedupClientFromDB = getClientByDedupCliendId(dedupId,clientModel.getProjectGroupCode());
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
			com.servinglynk.hmis.warehouse.model.v2016.Client client) {
			client.setId(UUID.randomUUID());
			com.servinglynk.hmis.warehouse.model.base.Client baseClient = new com.servinglynk.hmis.warehouse.model.base.Client();
			BeanUtils.copyProperties(client, baseClient);
			baseClient.setSchemaYear("2015");
			String dedupSessionKey = dedupHelper.getAuthenticationHeader();
			BeanUtils.copyProperties(client, baseClient, new String[] {"enrollments","veteranInfoes"});
			logger.info("Calling Dedup Service for "+client.getFirstName());
			String dedupedId = dedupHelper.getDedupedClient(baseClient,dedupSessionKey);
			client.setDedupClientId(UUID.fromString(dedupedId));
			baseClient.setDedupClientId(client.getDedupClientId());
			insert(client);
			insert(baseClient);
		return client;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2016.Client updateClient(
			com.servinglynk.hmis.warehouse.model.v2016.Client client) {
			update(client);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.v2016.Client client) {
			delete(client);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2016.Client getClientById(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Client.class);
		criteria.add(Restrictions.eq("id", clientId));
		List<com.servinglynk.hmis.warehouse.model.v2016.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2016.Client>) findByCriteria(criteria);
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
}
