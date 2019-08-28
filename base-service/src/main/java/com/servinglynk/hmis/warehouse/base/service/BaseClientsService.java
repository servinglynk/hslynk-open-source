package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.BaseClients;
import com.servinglynk.hmis.warehouse.core.model.MergeClient;

public interface BaseClientsService {

	BaseClients getClientsByDedupId(UUID dedupId,Integer startIndex,Integer maxResults);

	MergeClient mergeClient(MergeClient client, String caller, UUID clientId);

	MergeClient unmergeClient(MergeClient client, String caller, UUID clientId);
}
