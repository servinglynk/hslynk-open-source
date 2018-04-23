package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectUserEnity;

public class GlobalProjectDaoImpl extends QueryExecutorImpl implements GlobalProjectDao {

	@Override
	public GlobalProjectEntity create(GlobalProjectEntity entity) {
			entity.setId(UUID.randomUUID());
			insert(entity);
		return entity;
	}

	@Override
	public void updateGlobalProject(GlobalProjectEntity entity) {
		update(entity);
	}

	@Override
	public GlobalProjectEntity getById(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<GlobalProjectEntity> entities = (List<GlobalProjectEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}

	@Override
	public List<GlobalProjectEntity> getAllGlobalProjects(Integer start, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectEntity.class);
		return (List<GlobalProjectEntity>) findByCriteria(criteria,start,maxItems);
	}

	@Override
	public Long getAllGlobalProjectsCount() {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectEntity.class);
		return countRows(criteria);
	}

	public void addProjectToGlobalProject(GlobalProjectMapEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
	}
	
	public void removeProjectToGlobalProject(GlobalProjectMapEntity entity) {
		delete(entity);
	}
	
	public GlobalProjectMapEntity getGlobalProjectMapEntity(UUID globalProjectId,UUID projectId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectMapEntity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.add(Restrictions.eq("globalProject.id", globalProjectId));
		criteria.add(Restrictions.eq("projectId",projectId));
		List<GlobalProjectMapEntity> entities = (List<GlobalProjectMapEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}
	
	public List<GlobalProjectMapEntity> getGlobalProjectMappings(UUID globalProjectId){
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectMapEntity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.add(Restrictions.eq("globalProject.id", globalProjectId));
		return (List<GlobalProjectMapEntity>) findByCriteria(criteria);
	}	
	
	
	public GlobalProjectUserEnity addUserToGlobalProject(GlobalProjectUserEnity enity) {
		enity.setId(UUID.randomUUID());
		insert(enity);
		return enity;
	}
	
	public void removeUserToGlobalProject(GlobalProjectUserEnity enity) {
		delete(enity);
	}
	
	public GlobalProjectUserEnity getGlobalProjectUserMap(UUID globalProjectId,UUID userId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectUserEnity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.createAlias("hmisUser","hmisUser");
		criteria.add(Restrictions.eq("globalProject.id", globalProjectId));
		criteria.add(Restrictions.eq("hmisUser.id",userId));
		List<GlobalProjectUserEnity> entities = (List<GlobalProjectUserEnity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}
	
	public List<GlobalProjectUserEnity> getGlobalProjecUsertMappings(UUID globalProjectId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectUserEnity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.add(Restrictions.eq("globalProject.id", globalProjectId));
		return (List<GlobalProjectUserEnity>) findByCriteria(criteria);
	}

	public Boolean checkGlobalProjectUser(List<UUID> projectids, UUID userId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectUserEnity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.createAlias("hmisUser","hmisUser");
		criteria.add(Restrictions.in("globalProject.id", projectids));
		criteria.add(Restrictions.eq("hmisUser.id",userId));
		List<GlobalProjectUserEnity> entities = (List<GlobalProjectUserEnity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return true;
		return false;
	}

	@Override
	public void removeAllProjectUsers(UUID globalProjectId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectUserEnity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.add(Restrictions.eq("globalProject.id", globalProjectId));
		List<GlobalProjectUserEnity> entities = (List<GlobalProjectUserEnity>) findByCriteria(criteria);
		for(GlobalProjectUserEnity enity : entities) {
			delete(enity);
		}
	}

	@Override
	public void removeAllProjects(UUID globalProjectId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectMapEntity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.add(Restrictions.eq("globalProject.id", globalProjectId));
		List<GlobalProjectMapEntity> entities = (List<GlobalProjectMapEntity>) findByCriteria(criteria);
		for(GlobalProjectMapEntity entity : entities) {
			delete(entity);
		}
		
	}

	@Override
	public GlobalProjectEntity getGlobalProject(String projectName, String sourceSystemId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectEntity.class);
		criteria.add(Restrictions.eq("projectName", projectName));
		criteria.add(Restrictions.eq("sourceSystemId", sourceSystemId));
		List<GlobalProjectEntity> entities = (List<GlobalProjectEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}

	@Override
	public GlobalProjectMapEntity getProjectMap(UUID globalProjectId,String schemaYear) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalProjectMapEntity.class);
		criteria.createAlias("globalProject","globalProject");
		criteria.add(Restrictions.eq("globalProject.id", globalProjectId));
		criteria.add(Restrictions.eq("source", schemaYear));
		List<GlobalProjectMapEntity> entities = (List<GlobalProjectMapEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}
}