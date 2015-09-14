package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity;

public interface DeveloperServiceDao {

	
	public DeveloperServiceEntity findByFriendlyName(String friendlyName);
	public DeveloperServiceEntity create(DeveloperServiceEntity service);
	public DeveloperServiceEntity updateService(DeveloperServiceEntity service);
	public DeveloperServiceEntity findByExternalId(String externalServiceId);
	public void deleteService(DeveloperServiceEntity service);
	public List<DeveloperServiceEntity> findByDeveloperCompanyId(UUID id, int startIndex,
			int maxItems);
	public int findCountByDeveloperCompanyId(UUID id);
}
