package com.servinglynk.hmis.warehouse.dao;

import java.awt.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity;

public class ProjectGroupDaoImpl extends QueryExecutorImpl implements ProjectGroupDao {

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
	
	
	public ProjectGroupEntity getProjectGroupById(UUID projectGroupId){
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectGroupEntity.class);
		criteria.add(Restrictions.eq("id",projectGroupId));
		java.util.List<ProjectGroupEntity> projectGroupEntities = (java.util.List<ProjectGroupEntity>) findByCriteria(criteria);
		if(projectGroupEntities.size()>0) return projectGroupEntities.get(0);
		return null;
		
	}
	
	

	@Override
	public ProjectProjectGroupMapEntity addProjectToProjectGroup(ProjectProjectGroupMapEntity projectGroupMapEntity) {
				insert(projectGroupMapEntity);
		return projectGroupMapEntity;
	}

	@Override
	public ProjectProjectGroupMapEntity deleteProjectToProjectGroup(
			ProjectProjectGroupMapEntity projectGroupMapEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void deleteProjectGroupMap(ProjectProjectGroupMapEntity entity){
		delete(entity);
	}
	

	   public long getProjectGroupCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity.class);
	       return countRows(criteria);
	   }
	   

}
