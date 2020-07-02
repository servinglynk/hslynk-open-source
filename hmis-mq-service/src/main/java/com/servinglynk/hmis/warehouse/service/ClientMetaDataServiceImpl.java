package com.servinglynk.hmis.warehouse.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.converter.ClientMetaDataConverter;
import com.servinglynk.hmis.warehouse.entity.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaData;
import com.servinglynk.hmis.warehouse.repository.ClientMetaDataElasticRepository;

@Component
public class ClientMetaDataServiceImpl extends BaseService implements ClientMetaDataService {
	
	@Autowired ClientMetaDataElasticRepository clientMetaDataElasticRepository;

	@Transactional
	public void createClientMetaData(ClientMetaDataModel model) {
		ClientMetaDataEntity entity = daoFactory.getClientMetaDataRepository().findFirstByMetaDataIdentifier(model.getMetaDataIdentifier());
		ClientMetaDataEntity entity2 = ClientMetaDataConverter.modelToEntity(entity, model);
		daoFactory.getClientMetaDataRepository().save(entity2);		
		indexClientMetadata(entity2);
	}
	
	
	public void indexClientMetadata(ClientMetaDataEntity entity) {

			ClientMetaData  cacheEntity = new ClientMetaData();
			cacheEntity.setAdditionalinfo(entity.getAdditionalInfo());
			cacheEntity.setClientdedupid(entity.getClientDedupId()+"");
			cacheEntity.setClientid(entity.getClientId()+"");
			if(entity.getDate()!=null) cacheEntity.setDate(Date.from(entity.getDate().atZone(ZoneId.systemDefault()).toInstant()));
			cacheEntity.setDatecreated(Date.from(entity.getDateCreated().atZone(ZoneId.systemDefault()).toInstant()));
			cacheEntity.setDateupdated(Date.from(entity.getDateUpdated().atZone(ZoneId.systemDefault()).toInstant()));
			cacheEntity.setDeleted(entity.isDeleted());
			cacheEntity.setId(entity.getId()+"");
			cacheEntity.setMetadataidentifier(entity.getMetaDataIdentifier()+"");
			cacheEntity.setProjectgroupcode(entity.getProjectGroupCode());
			cacheEntity.setType(entity.getType());
			cacheEntity.setUserid(entity.getUserId());
			clientMetaDataElasticRepository.save(cacheEntity);
	}
	
	@Transactional
	public void deleteClientMetaData(ClientMetaDataModel model) {
		ClientMetaDataEntity entity = daoFactory.getClientMetaDataRepository().findFirstByMetaDataIdentifier(model.getMetaDataIdentifier());
		if(entity!=null) {
			entity.setDeleted(true);
			entity.setDateUpdated(LocalDateTime.now());
			daoFactory.getClientMetaDataRepository().save(entity);
		}
	}
}
