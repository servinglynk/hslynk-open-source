package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ClientDataElementsEntity;

public interface ClientDataElementDao extends QueryExecutor {

	List<ClientDataElementsEntity> getClientDataElements(UUID clientId);
}