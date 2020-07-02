package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.entity.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;

public interface ClientMetaDataService {

	void createClientMetaData(ClientMetaDataModel model);
	
	void deleteClientMetaData(ClientMetaDataModel model);
	
	void indexClientMetadata(ClientMetaDataEntity entity) ;
}
