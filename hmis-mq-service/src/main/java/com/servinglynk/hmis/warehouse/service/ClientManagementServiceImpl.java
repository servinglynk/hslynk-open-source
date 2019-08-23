package com.servinglynk.hmis.warehouse.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;

@Component
public class ClientManagementServiceImpl extends BaseService implements ClientManagementService {

	@Transactional
	public void deleteClientIdentities(ClientMetaDataModel model) {
		daoFactory.getClientManagementDao().deleteClientIdentities(model.getClientId(),model.getClientDedupId(), model.getProjectGroupCode(), model.getUserId());
	}

	@Transactional
	public void mergeClientIdentities(ClientMetaDataModel model) {
		daoFactory.getClientManagementDao().mergeClientIdentities(model.getClientDedupId(),model.getNewDedulClientId(),model.getClientId() ,model.getProjectGroupCode());
		
	}
	
}
