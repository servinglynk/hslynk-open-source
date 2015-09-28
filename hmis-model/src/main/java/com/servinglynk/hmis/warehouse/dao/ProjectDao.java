/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface ProjectDao extends ParentDao {


	
	   com.servinglynk.hmis.warehouse.model.live.Project createProject(com.servinglynk.hmis.warehouse.model.live.Project project);
	   com.servinglynk.hmis.warehouse.model.live.Project updateProject(com.servinglynk.hmis.warehouse.model.live.Project project);
	   void deleteProject(com.servinglynk.hmis.warehouse.model.live.Project project);
	   com.servinglynk.hmis.warehouse.model.live.Project getProjectById(UUID projectId);
	   List<com.servinglynk.hmis.warehouse.model.live.Project> getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems);
	   long getProjectCount(UUID organizationId);
}
