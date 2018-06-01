package com.servinglynk.hmis.warehouse.base.dao;


import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

public class ProjectGroupDaoImpl extends BaseDaoImpl implements ProjectGroupDao {

	@Override
	public ProjectGroupEntity createProjectGroup(ProjectGroupEntity projectGroupEntity) {
			insert(projectGroupEntity);
		return projectGroupEntity;
	}

	@Override
	public ProjectGroupEntity updateProjectGroup(ProjectGroupEntity projectGroupEntity) {
		update(projectGroupEntity);
		return projectGroupEntity;
	}
	
	@Override
	public void deleteProjectGroup(ProjectGroupEntity projectGroupEntity) {
		delete(projectGroupEntity);
	}
	
	@Override
	public ProjectGroupEntity getProjectGroupById(UUID projectGroupId){
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectGroupEntity.class);
		criteria.add(Restrictions.eq("id",projectGroupId));
		java.util.List<ProjectGroupEntity> projectGroupEntities = (java.util.List<ProjectGroupEntity>) findByCriteria(criteria);
		if(projectGroupEntities.size()>0) return projectGroupEntities.get(0);
		return null;
		
	}
	
	
	@Override
	public ProjectGroupEntity getProjectGroupByGroupCode(String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectGroupEntity.class);
		criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		java.util.List<ProjectGroupEntity> projectGroupEntities = (java.util.List<ProjectGroupEntity>) findByCriteria(criteria);
		if(projectGroupEntities.size()>0) return projectGroupEntities.get(0);
		return null;
	}
		
	   public long getProjectGroupCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity.class);
	       return countRows(criteria);
	   }
	   
	   public List<com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity> getAllProjectGroups(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity.class);
	       return (List<com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity>) findByCriteria(criteria,startIndex,maxItems);
	   }
}
