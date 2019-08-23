package com.servinglynk.hmis.warehouse.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.converter.ClientMetaDataConverter;
import com.servinglynk.hmis.warehouse.entity.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;

@Component
public class ClientMetaDataServiceImpl extends BaseService implements ClientMetaDataService {

	@Transactional
	public void createClientMetaData(ClientMetaDataModel model) {
		ClientMetaDataEntity entity = daoFactory.getClientMetaDataRepository().findFirstByMetaDataIdentifier(model.getMetaDataIdentifier());
		ClientMetaDataEntity entity2 = ClientMetaDataConverter.modelToEntity(entity, model);
		daoFactory.getClientMetaDataRepository().save(entity2);
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
