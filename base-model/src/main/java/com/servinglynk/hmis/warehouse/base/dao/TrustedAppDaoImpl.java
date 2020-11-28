package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.TrustedAppEntity;
import com.servinglynk.hmis.warehouse.model.base.TrustedAppProjectGroupMapEntity;

public class TrustedAppDaoImpl extends QueryExecutorImpl implements TrustedAppDao {

	@Override
	public TrustedAppEntity updateTrustedApp(TrustedAppEntity trustedAppEntity) {
			update(trustedAppEntity);
		return trustedAppEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TrustedAppEntity findByExternalId(String externalId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TrustedAppEntity.class);
		criteria.add(Restrictions.eq("externalId",externalId));
		List<TrustedAppEntity> trustedAppEntities = (List<TrustedAppEntity>) findByCriteria(criteria);
		if(trustedAppEntities.size()>0) return trustedAppEntities.get(0);
		return null;
	}

	@Override
	public void deleteTrustedApp(TrustedAppEntity trustedAppEntity) {
		delete(trustedAppEntity);
		
	}

	@Override
	public void create(TrustedAppEntity trustedAppEntity) {
		insert(trustedAppEntity);
		
	}
	
	
	public List<TrustedAppProjectGroupMapEntity> projectGroupHasTrustedAppAccess(String exteranlId,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TrustedAppProjectGroupMapEntity.class);
		criteria.createAlias("trustedApp", "trustedApp");
		criteria.add(Restrictions.eq("trustedApp.externalId", exteranlId));
		if(projectGroupCode!=null) {
			criteria.createAlias("projectGroup", "projectGroup");
			criteria.add(Restrictions.eq("projectGroup.projectGroupCode", projectGroupCode));
		}
		List<TrustedAppProjectGroupMapEntity> entities = (List<TrustedAppProjectGroupMapEntity>) find(criteria);
		return entities;
	}
	
	public List<TrustedAppProjectGroupMapEntity> getTrustedAppProjectGroups(String exteranlId,UUID projectGroupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TrustedAppProjectGroupMapEntity.class);
		criteria.createAlias("trustedApp", "trustedApp");
		criteria.add(Restrictions.eq("trustedApp.externalId", exteranlId));
		if(projectGroupId!=null) {
			criteria.createAlias("projectGroup", "projectGroup");
			criteria.add(Restrictions.eq("projectGroup.id", projectGroupId));
		}
		List<TrustedAppProjectGroupMapEntity> entities = (List<TrustedAppProjectGroupMapEntity>) find(criteria);
		return entities;
	}

	public List<TrustedAppProjectGroupMapEntity> getTrustedAppsByProjectGroup(UUID projectGroupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TrustedAppProjectGroupMapEntity.class);
		if(projectGroupId!=null) {
			criteria.createAlias("projectGroup", "projectGroup");
			criteria.add(Restrictions.eq("projectGroup.id", projectGroupId));
		}
		List<TrustedAppProjectGroupMapEntity> entities = (List<TrustedAppProjectGroupMapEntity>) find(criteria);
		return entities;
	}
	
	@Override
	public TrustedAppProjectGroupMapEntity addProjectGroupToTrustedApp(TrustedAppProjectGroupMapEntity mapEntity) {
		mapEntity.setId(UUID.randomUUID());
		insert(mapEntity);
		return mapEntity;
	}

	@Override
	public void deleteProjectGroupToTrustedApp(List<TrustedAppProjectGroupMapEntity> entities) {
		for(TrustedAppProjectGroupMapEntity entity : entities) {
			delete(entity);
		}
	}

	@Override
	public List<TrustedAppEntity> getAllTrustedApps() {
		DetachedCriteria criteria = DetachedCriteria.forClass(TrustedAppEntity.class);
		List<TrustedAppEntity> trustedAppEntities = (List<TrustedAppEntity>) findByCriteria(criteria);
		return trustedAppEntities;
	}

}
