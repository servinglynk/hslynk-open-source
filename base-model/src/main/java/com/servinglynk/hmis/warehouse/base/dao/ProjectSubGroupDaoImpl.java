package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupProjectMapEntity;

public class ProjectSubGroupDaoImpl extends QueryExecutorImpl implements ProjectSubGroupDao {

	public ProjectSubGroupEntity createProjectSubGroup(ProjectSubGroupEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		return entity;
	}
	
	public void deleteProjectSubGroup(ProjectSubGroupEntity entity) {
		delete(entity);
	}
	
	public void addProjectToSubgroup(ProjectSubGroupProjectMapEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
	}
	
	@Override
	public void updateProjectSubGroup(ProjectSubGroupEntity entity) {
		update(entity);
	}

	
	public void removeProjectToSubGroup(ProjectSubGroupEntity entity) {
		delete(entity);
	}

	public ProjectSubGroupEntity getProjectSubGroupById(UUID projectSubGroupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSubGroupEntity.class);
		criteria.add(Restrictions.eq("id", projectSubGroupId));
		List<ProjectSubGroupEntity> entities = (List<ProjectSubGroupEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}
	
    public ProjectSubGroupEntity getProjectsDefaultGroup(UUID projectId) {
    	DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSubGroupProjectMapEntity.class);
    	criteria.createAlias("projectId", "projectId");
    	criteria.createAlias("projectSubGroup", "projectSubGroup");
    	criteria.add(Restrictions.eq("projectId.id", projectId));
    	criteria.add(Restrictions.eq("projectSubGroup.userDefined", false));
    	List<ProjectSubGroupProjectMapEntity> entities = (List<ProjectSubGroupProjectMapEntity>) findByCriteria(criteria);
    	if(entities.isEmpty()) return null;
    	return entities.get(0).getProjectSubGroup();
    }
    
    
	public ProjectSubGroupEntity getToProjectSubGroupById(UUID projectSubGroupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSubGroupEntity.class);
		criteria.add(Restrictions.eq("id", projectSubGroupId));
		List<ProjectSubGroupEntity> entities = (List<ProjectSubGroupEntity>) find(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}
	
    public ProjectSubGroupEntity getToProjectsDefaultGroup(UUID projectId) {
    	DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSubGroupProjectMapEntity.class);
    	criteria.createAlias("projectId", "projectId");
    	criteria.createAlias("projectSubGroup", "projectSubGroup");
    	criteria.add(Restrictions.eq("projectId.id", projectId));
    	criteria.add(Restrictions.eq("projectSubGroup.userDefined", false));
    	List<ProjectSubGroupProjectMapEntity> entities = (List<ProjectSubGroupProjectMapEntity>) find(criteria);
    	if(entities.isEmpty()) return null;
    	return entities.get(0).getProjectSubGroup();

    }

	@Override
	public List<ProjectSubGroupEntity> getUserProjectSubGroups(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSubGroupEntity.class);
		criteria.add(Restrictions.eq("userDefined", true));
		List<ProjectSubGroupEntity> entities = (List<ProjectSubGroupEntity>) findByCriteria(criteria, startIndex, maxItems);
		return entities;

	}

	@Override
	public void addProjectToProjectSubGroup(ProjectSubGroupProjectMapEntity mapEntity) {
		mapEntity.setId(UUID.randomUUID());
		insert(mapEntity);
	}

	@Override
	public ProjectSubGroupProjectMapEntity getToProjectSubGroupBy(UUID projectSubGroupId, UUID projectId) {
    	DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSubGroupProjectMapEntity.class);
    	criteria.createAlias("projectId", "projectId");
    	criteria.createAlias("projectSubGroup", "projectSubGroup");
    	criteria.add(Restrictions.eq("projectId.id", projectId));
    	criteria.add(Restrictions.eq("projectSubGroup.id",projectSubGroupId));
    	criteria.add(Restrictions.eq("projectSubGroup.userDefined", true));
    	List<ProjectSubGroupProjectMapEntity> entities = (List<ProjectSubGroupProjectMapEntity>) findByCriteria(criteria);
    	if(entities.isEmpty()) return null;
    	return entities.get(0);
	}

	@Override
	public void deleteProjectSubGroupMap(ProjectSubGroupProjectMapEntity mapEntity) {
		delete(mapEntity);
	}

	
}