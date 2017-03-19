/**
 *
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.Project;

/**
 * @author Sandeep
 *
 */
public interface ProjectDao {



	  Project createProject(Project project);
	  Project updateProject(Project project);
	   void deleteProject(Project project);
	  Project getProjectById(UUID projectId);
	   List<Project> getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems);
	   long getProjectCount(UUID organizationId);
}
