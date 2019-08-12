package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;

public interface ClientManagementService {

	void deleteClientIdentities(ClientMetaDataModel model);

	void mergeClientIdentities(ClientMetaDataModel model);
}