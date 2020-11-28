package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.TrustedAppEntity;
import com.servinglynk.hmis.warehouse.model.base.TrustedAppProjectGroupMapEntity;

public interface TrustedAppDao {
	
	public TrustedAppEntity updateTrustedApp(TrustedAppEntity trustedAppEntity);
	
	public TrustedAppEntity findByExternalId(String externalId);
	
	public void deleteTrustedApp(TrustedAppEntity trustedAppEntity);

	public void create(TrustedAppEntity trustedAppEntity);
	
	List<TrustedAppProjectGroupMapEntity> projectGroupHasTrustedAppAccess(String exteranlId,String projectGroupCode);

	public TrustedAppProjectGroupMapEntity addProjectGroupToTrustedApp(TrustedAppProjectGroupMapEntity mapEntity);

	public void deleteProjectGroupToTrustedApp(List<TrustedAppProjectGroupMapEntity> entities);

	public List<TrustedAppEntity> getAllTrustedApps();
	
	public List<TrustedAppProjectGroupMapEntity> getTrustedAppsByProjectGroup(UUID projectGroupId);
	
	List<TrustedAppProjectGroupMapEntity> getTrustedAppProjectGroups(String exteranlId,UUID projectGroupId);

}
