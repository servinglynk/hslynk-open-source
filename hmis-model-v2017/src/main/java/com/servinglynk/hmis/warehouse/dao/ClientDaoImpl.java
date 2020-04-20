
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
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
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
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class, String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap, domain.getUpload().getId());
		Data data = new Data();
		String projectGroupCode= getProjectGroupCode(domain);
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Client.class, projectGroupCode);
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupByGroupCode(projectGroupCode);
		List<Client> clients = export.getClient();
		if (CollectionUtils.isNotEmpty(clients)) {
			for (Client client : clients) {
				com.servinglynk.hmis.warehouse.model.v2017.Client clientModel = null;
				try {
					clientModel = (com.servinglynk.hmis.warehouse.model.v2017.Client) modelMap.get(client.getPersonalID());
					if(clientModel != null) {
						if(projectGroupEntity.isDetermineDedupBySsid()) {
							clientModel.setRecordToBeInserted(false);
						}
					}else {
						clientModel = new com.servinglynk.hmis.warehouse.model.v2017.Client();
						clientModel.setRecordToBeInserted(true);
						clientModel.setId(UUID.randomUUID());
					}
					populateClient(client, clientModel);
					/**
					 * This is where the deduping happens We check if a client with the same information exists and
					 *  If it exist then the dedupClient Object below will not be null and we will pass on its ID into the enrollment object later on.
					 *  But if a client does not exist we create a new client and the ClientUUID is passed on to the map.
					 *  This will we will not create new client records in the client table if a client is enrollment at multiple organizations.
					 */
					if(clientModel.isRecordToBoInserted()) {
						if(StringUtils.equals(projectGroupCode,"AL0024") && clientModel.getDedupClientId() == null) {
							clientModel.setDedupClientId(UUID.randomUUID());
						}else {
							clientModel = getClientFromDedup(clientModel, client, projectGroupCode);
						}
					}
					
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
					clientModel.setRace(ClientRaceEnum
							.lookupEnum(client.getRace()));
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
					performSaveOrUpdate(clientModel,domain);
					
					// Inserting client in base schema	
					if(!clientModel.isIgnored()) {
						com.servinglynk.hmis.warehouse.model.base.Client target = new com.servinglynk.hmis.warehouse.model.base.Client();
						BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
						target.setDateUpdated(LocalDateTime.now());
						target.setSchemaYear("2017");
						target.setId(clientModel.getId());
						target.setDedupClientId(clientModel.getDedupClientId());
						insertOrUpdate(target);	
					}
				} catch (Exception e) {
					e.printStackTrace();
					String errorMessage = "Exception beause of the client::" + client.toString() + " Exception ::" + e.getMessage();
					if(clientModel != null){
						Error2017 error = new Error2017();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Client.class.getSimpleName(), domain, exportEntity);
	}
	
	
    private com.servinglynk.hmis.warehouse.model.v2017.Client getClientFromDedup(com.servinglynk.hmis.warehouse.model.v2017.Client clientModel,Client client, String projectGroupCode) {
    	com.servinglynk.hmis.warehouse.model.base.Client  target = new com.servinglynk.hmis.warehouse.model.base.Client();
		BeanUtils.copyProperties(clientModel, target, new String[] {"enrollments","veteranInfoes"});
		UUID dedupId = daoFactory.getHmisClientDao().determindDedupId(target,projectGroupCode);
		com.servinglynk.hmis.warehouse.model.v2017.Client clientByDedupCliendId = getClientByDedupCliendId(dedupId, projectGroupCode);
		if(clientByDedupCliendId != null) {
			clientByDedupCliendId.setRecordToBeInserted(false);
		}else {
			 clientByDedupCliendId = new com.servinglynk.hmis.warehouse.model.v2017.Client();
			 clientByDedupCliendId.setRecordToBeInserted(true);
			 clientByDedupCliendId.setDedupClientId(dedupId);
			 clientByDedupCliendId.setId(UUID.randomUUID());
		}
		populateClient(client, clientByDedupCliendId);
		return clientByDedupCliendId;
	}


	public void populateClient(Client client,com.servinglynk.hmis.warehouse.model.v2017.Client clientModel) {
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
			com.servinglynk.hmis.warehouse.model.v2017.Client client) {
			if(client !=null) {
				com.servinglynk.hmis.warehouse.model.v2017.Client target = new com.servinglynk.hmis.warehouse.model.v2017.Client();
				BeanUtils.copyProperties(client, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) get(com.servinglynk.hmis.warehouse.model.v2017.Export.class, client.getExport().getId());
				exportEntity.addClient(target);
				target.setExport(exportEntity);
//				com.servinglynk.hmis.warehouse.model.v2017.Client clientByDedupCliendId = getClientByDedupCliendId(client.getDedupClientId(),client.getProjectGroupCode());
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
	public com.servinglynk.hmis.warehouse.model.v2017.Client createClient(
			com.servinglynk.hmis.warehouse.model.v2017.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
			client.setId(UUID.randomUUID());
			baseClient.setSchemaYear("2017");
			client.setDateUpdated(LocalDateTime.now());
			baseClient.setDateUpdated(LocalDateTime.now());
			insert(client);
			baseClient.setId(client.getId());
			insert(baseClient);
			return client;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Client updateClient(
			com.servinglynk.hmis.warehouse.model.v2017.Client client,com.servinglynk.hmis.warehouse.model.base.Client baseClient) {
		baseClient.setSchemaYear("2017");
			update(client);
			update(baseClient);
		return client;
	}


	@Override
	public void deleteClient(
			com.servinglynk.hmis.warehouse.model.v2017.Client client) {
			delete(client);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Client getClientById(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Client.class);
		criteria.add(Restrictions.eq("id", clientId));
		List<com.servinglynk.hmis.warehouse.model.v2017.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2017.Client>) findByCriteria(criteria);
		if(clients.size()>0) return clients.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Client getClientByDedupCliendId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		criteria.add(Restrictions.isNull("parentId"));
		List<com.servinglynk.hmis.warehouse.model.v2017.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2017.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2017.Client getClientByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Client.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2017.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2017.Client>) findByCriteria(criteria);
		if(clients !=null && clients.size()>0) return clients.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.Client> getAllClients(String projectGroupCode, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Client.class);	
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2017.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2017.Client>) findByCriteria(criteria,startIndex,maxItems);
		return clients;
	}
	
	public long getClientsCount(String projectGroupCode){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Client.class);	
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return countRows(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.Client> getAllNullDedupIdClients() {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Client.class);
		List<String> allActiveProjectGroupCodes = daoFactory.getProjectGroupDao().getAllActiveProjectGroupCodes();
		criteria.add(Restrictions.isNull("dedupClientId"));
		Criterion firstNameCriterion = Restrictions.isNotNull("firstName");
		Criterion lastNameCriterion = Restrictions.isNotNull("lastName");
		criteria.add(Restrictions.and(firstNameCriterion,lastNameCriterion));
		criteria.add(Restrictions.in("projectGroupCode", allActiveProjectGroupCodes));
		Criterion versionNullCriterion = Restrictions.isNotNull("version");
		Criterion versionLessThan3Criterion = Restrictions.le("version",3L);
		criteria.add(Restrictions.or(versionNullCriterion,versionLessThan3Criterion));
		List<com.servinglynk.hmis.warehouse.model.v2017.Client> clients = (List<com.servinglynk.hmis.warehouse.model.v2017.Client>) findByCriteria(criteria);
		return clients;
	}
	
	@Override
	public void updateDedupClient(
			com.servinglynk.hmis.warehouse.model. v2017.Client client,String dedupSessionKey) {
	    com.servinglynk.hmis.warehouse.model.base.Client basClient = daoFactory.getBaseClientDao().getClient(client.getId());
	    if(basClient == null) {
	    	basClient = new  com.servinglynk.hmis.warehouse.model.base.Client();
	    	BeanUtils.copyProperties(client, basClient, new String[] {"enrollments","veteranInfoes"});
	    	basClient.setSchemaYear("2017");
	     }
	    try{
	    	 String  dedupedId = dedupHelper.getDedupedClient(basClient,dedupSessionKey);
		     logger.info("Calling Dedup Service for "+client.getFirstName());
			 client.setDateUpdated(LocalDateTime.now());
			 if(StringUtils.isNotBlank(dedupedId)) {
				 client.setDedupClientId(UUID.fromString(dedupedId));
				 getCurrentSession().update(client);
				 basClient.setDedupClientId(UUID.fromString(dedupedId));
				 basClient.setDateUpdated(LocalDateTime.now());
				 insert(basClient);
				 getCurrentSession().flush();
				 getCurrentSession().clear();
			 }
	    }catch(Exception e) {
	    	logger.error("Error populate dedup id for client: "+client.getId() + " name :"+ client.getFirstName(),e);
	    }
	    
	}
}
