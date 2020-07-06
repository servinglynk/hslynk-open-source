package com.servinglynk.hmis.warehouse.service;

import java.util.List;
import java.util.UUID;

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
		
		List<UUID> cleintIds =	daoFactory.getClientManagementDao().getMergeableClients(model.getClientDedupId(),model.getProjectGroupCode());
		for(UUID clientId : cleintIds) {
			
		}
		
		daoFactory.getClientManagementDao().mergeClientIdentities(model.getClientDedupId(),model.getNewDedulClientId(),model.getClientId() ,model.getProjectGroupCode());
		
	}
	
}
