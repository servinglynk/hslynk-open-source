package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.core.model.BaseClients;

public interface BaseClientsService {

	BaseClients getClientsByDedupId(UUID dedupId,Integer startIndex,Integer maxResults);

	BaseClient mergeClient(BaseClient client, String caller, UUID clientId);

	BaseClient unmergeClient(BaseClient client, String caller, UUID clientId);
}
