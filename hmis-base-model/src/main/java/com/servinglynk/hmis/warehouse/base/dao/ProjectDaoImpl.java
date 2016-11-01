/**
 *
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.Project;

/**
 * @author Sandeep
 *
 */
public class ProjectDaoImpl extends QueryExecutorImpl implements ProjectDao {

	   public Project createProject(Project project){
	       insertOrUpdate(project);
	       return project;
	   }
	   public Project updateProject(Project project){
	       update(project);
	       return project;
	   }
	   public void deleteProject(Project project){
	       delete(project);
	   }
	   public Project getProjectById(UUID projectId){
	       return (Project) get(Project.class, projectId);
	   }
	   public List<Project> getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return (List<Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(UUID organizationId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return countRows(criteria);
	   }
}
