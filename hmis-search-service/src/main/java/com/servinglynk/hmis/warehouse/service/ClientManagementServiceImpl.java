package com.servinglynk.hmis.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ClientManagementDao;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaData;

@Component
public class ClientManagementServiceImpl extends BaseService implements ClientManagementService {
	
	@Autowired ClientManagementDao clientManagementDao;

	@Transactional
	public void deleteClientIdentities(ClientMetaDataModel model) {
		clientManagementDao.deleteClientIdentities(model.getClientId(),model.getClientDedupId(), model.getProjectGroupCode(), model.getUserId());
	}

	@Transactional
	public void mergeClientIdentities(ClientMetaDataModel model) {
		

			Page<Client> clients	= repositoryFactory.getClientElasticRepository().findByDedupclientidOrIdAndProjectgroupcode(model.getClientDedupId()+"", model.getClientDedupId()+"",model.getProjectGroupCode() , null);
			if(clients.getContent().size()!=0) {
				Client client = clients.getContent().get(0);
				client.setDedupclientid(model.getNewDedulClientId()+"");
				repositoryFactory.getClientElasticRepository().save(client);
			}
		
		
		List<ClientMetaData> clientMetaDatas = repositoryFactory.getClientMetaDataRepository().findByClientdedupidAndProjectgroupcode(model.getClientDedupId()+"", model.getProjectGroupCode());
		for(ClientMetaData metaData : clientMetaDatas) {
			metaData.setClientdedupid(model.getNewDedulClientId()+"");
			repositoryFactory.getClientMetaDataRepository().save(metaData);
		}
		clientManagementDao.mergeClientIdentities(model.getClientDedupId(),model.getNewDedulClientId(),model.getClientId() ,model.getProjectGroupCode());
		
	}
	
}
