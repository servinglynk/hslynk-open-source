package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface ClientManagementDao {

	void deleteClientIdentities(UUID clientId,UUID dedupClientId,String projectGroupCode,UUID userId);

	void mergeClientIdentities(UUID currentDedupId, UUID targetDedupId, UUID clientId, String projectGroupCode);

	List<UUID> getMergeableClients(UUID clientDedupId, String projectGroupCode);
}