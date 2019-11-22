package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Primary;

import com.servinglynk.hmis.warehouse.model.base.Project;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectUserEntity;

public class BaseProjectDaoImpl extends QueryExecutorImpl implements BaseProjectDao {

	   public  Project createProject( Project project){
		   insert(project);
		   this.createDefaultProjectSubGroup(project);
		   return project;
	   }
	   public  Project updateProject( Project project){
		   update(project);
		   return project;
	   }
	   public void deleteProject( Project project){
	       delete(project);
	   }
	     public  Project getProjectById(UUID projectId){
		      DetachedCriteria criteria=DetachedCriteria.forClass( Project.class);
		      criteria.add(Restrictions.eq("id", projectId));
		      List< Project> projects = (List< Project>) findByCriteria(criteria);
		      if(!projects.isEmpty()) return projects.get(0);
		      return null;
	   }
	   public List< Project> getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass( Project.class);
	       criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
	       return (List< Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(String projectGroupCode){
	       DetachedCriteria criteria=DetachedCriteria.forClass( Project.class);
	       criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
	       return countRows(criteria);
	   }
	   
	   
	   public ProjectSubGroupEntity createDefaultProjectSubGroup(Project project) {
		   ProjectSubGroupEntity projectSubGroupEntity = new ProjectSubGroupEntity();
		   projectSubGroupEntity.setId(UUID.randomUUID());
		   projectSubGroupEntity.setProjectSubGroupName(project.getProjectname());
		   projectSubGroupEntity.setUserDefined(false);
		   projectSubGroupEntity.setDateCreated(project.getDateCreated());
		   projectSubGroupEntity.setDateUpdated(project.getDateUpdated());
		   projectSubGroupEntity.setDeleted(false);
		   projectSubGroupEntity.setProjectGroupCode(project.getProjectGroupCode());
		   projectSubGroupEntity.setUser(project.getUser().getId());

		   insert(projectSubGroupEntity);
		   ProjectSubGroupProjectMapEntity entity = new ProjectSubGroupProjectMapEntity();
		   entity.setId(UUID.randomUUID());
		   entity.setProjectId(project);
		   entity.setProjectSubGroup(projectSubGroupEntity);
		   entity.setDateCreated(project.getDateCreated());
		   entity.setDateUpdated(project.getDateUpdated());
		   entity.setDeleted(false);
		   entity.setProjectGroupCode(project.getProjectGroupCode());
		   entity.setUser(project.getUser().getId());
		   insert(entity);
		   return projectSubGroupEntity;
	   }
	public void createProjectUser(ProjectUserEntity projectUserEntity) {
		projectUserEntity.setId(UUID.randomUUID());
		insert(projectUserEntity);
		
	}
	public List<ProjectUserEntity> getProjectUserByProjectId(UUID projectId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectUserEntity.class);
		criteria.createAlias("project", "project");
		criteria.add(Restrictions.eq("project.id", projectId));
		
		return (List<ProjectUserEntity>) findByCriteria(criteria);
	}
	public void deleteProjectUser(ProjectUserEntity projectUserEntity) {
		delete(projectUserEntity);
		
	}
	public List<ProjectUserEntity> getProjectUserMap(UUID projectId, UUID userId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectUserEntity.class);
		criteria.createAlias("project", "project");
		criteria.createAlias("projectUser","projectUser");
		criteria.add(Restrictions.eq("project.id", projectId));
		criteria.add(Restrictions.eq("projectUser.id",userId));
		return (List<ProjectUserEntity>) findByCriteria(criteria);
	}

}