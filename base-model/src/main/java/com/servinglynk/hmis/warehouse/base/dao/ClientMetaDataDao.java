package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;

public interface ClientMetaDataDao {

	List<ClientMetaDataEntity> findClientMetaData(UUID getrDedupClientId);

	void createClientMetaData(ClientMetaDataEntity metaDataEntity);

	void updateClientMetaData(ClientMetaDataEntity metaDataEntity);

	ClientMetaDataEntity findByIdentifier(UUID id);

}
