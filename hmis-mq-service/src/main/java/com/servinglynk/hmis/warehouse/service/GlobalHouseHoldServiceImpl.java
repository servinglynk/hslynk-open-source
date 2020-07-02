package com.servinglynk.hmis.warehouse.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.servinglynk.hmis.warehouse.converter.ClientMetaDataConverter;
import com.servinglynk.hmis.warehouse.entity.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldMapEntity;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;
import com.servinglynk.hmis.warehouse.model.HmisHouseHoldModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;

@Component
public class GlobalHouseHoldServiceImpl extends BaseService implements  GlobalHouseHoldService {

	@Autowired ClientMetaDataService clientMetaDataService;
	
	@Transactional
	public void createGlobalHouseHold(HmisHouseHoldModel model) {
		GlobalHouseHoldEntity entity = null;
		if(model.getSourceSystemId() == null && model.getSourceSystemHouseHoldId()!=null) {
			 entity =	daoFactory.getGlobalHouseHoldDao().getGlobalHouseHold(model.getSourceSystemId(), model.getSourceSystemHouseHoldId(), model.getProjectGroupCode());			
		}
		

		if(entity==null) {
			entity = new GlobalHouseHoldEntity();
			entity.setDateCreated(LocalDateTime.now());
			entity.setDateUpdated(LocalDateTime.now());
			entity.setDeleted(false);
			entity.setProjectGroupCode(model.getProjectGroupCode());
			entity.setUserId(model.getUserId());
			daoFactory.getGlobalHouseHoldDao().createGlobalHouseHold(entity);
		}
		
		GlobalHouseHoldMapEntity mapEntity = new GlobalHouseHoldMapEntity();
		mapEntity.setDateCreated(LocalDateTime.now());
		mapEntity.setDateUpdated(LocalDateTime.now());
		mapEntity.setUserId(model.getUserId());
		mapEntity.setSchemaYear(model.getSchema());
		mapEntity.setProjectGroupCode(model.getProjectGroupCode());
		mapEntity.setGlobalHouseHold(entity);
		if(model.getHmisHouseHoldId()!=null)mapEntity.setHmisHouseHoldId(model.getHmisHouseHoldId());
		if(model.getGenericHouseHoldId()!=null) mapEntity.setGenericHouseHoldId(model.getGenericHouseHoldId());
		if(model.getSchema()!=null)mapEntity.setSchemaYear(model.getSchema());
		if(model.getSourceSystemHouseHoldId()!=null)mapEntity.setSourceSystemHouseHoldId(model.getSourceSystemHouseHoldId());
		if(model.getSourceSystemId()!=null) mapEntity.setSourceSystemId(model.getSourceSystemId());
		daoFactory.getGlobalHouseHoldDao().addGlobalHouseHoldMap(mapEntity);
		model.setGlobalHouseholdId(entity.getId());
		this.createClientMetadata(model);
	}

	public void createClientMetadata(HmisHouseHoldModel hmisHouseHoldModel) {
		JSONObjectMapper mapper = new JSONObjectMapper();
		ClientMetaDataModel metaData = new ClientMetaDataModel();
		metaData.setUserId(hmisHouseHoldModel.getUserId());
		metaData.setClientId(hmisHouseHoldModel.getClientId());
		metaData.setClientDedupId(hmisHouseHoldModel.getDedupClientId());
		metaData.setDate(LocalDateTime.now());
		metaData.setProjectGroupCode(hmisHouseHoldModel.getProjectGroupCode());
		metaData.setDeleted(false);
		metaData.setMetaDataIdentifier(hmisHouseHoldModel.getGlobalHouseholdId());
		metaData.setType("globalHouseHolds");
		metaData.setId(hmisHouseHoldModel.getGlobalHouseholdId());
		try {
			metaData.setAdditionalInfo(mapper.writeValueAsString(hmisHouseHoldModel));
		} catch (JsonProcessingException e) {
		}
		
//		clientMetaDataService.createClientMetaData(metaData);
		ClientMetaDataEntity entity = daoFactory.getClientMetaDataRepository().findFirstByMetaDataIdentifier(metaData.getMetaDataIdentifier());
		ClientMetaDataEntity entity2 = ClientMetaDataConverter.modelToEntity(entity, metaData);
		daoFactory.getClientMetaDataRepository().save(entity2);
		
		clientMetaDataService.indexClientMetadata(entity2);
	}
	
	@Transactional
	public void deleteGlobalHouseHold(HmisHouseHoldModel model) {
		List<GlobalHouseHoldMapEntity> entities = daoFactory.getGlobalHouseHoldDao().getGlobalHouseHoldMapById(model.getHmisHouseHoldId(), model.getProjectGroupCode(), model.getSchema());
		for(GlobalHouseHoldMapEntity entity : entities) {
			daoFactory.getGlobalHouseHoldDao().removeGlobalHouseHoldMap(entity);
		}
	}

}
