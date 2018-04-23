/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;

/**
 * @author Sandeep
 *
 */
public interface ProjectDao extends ParentDao {
	   com.servinglynk.hmis.warehouse.model.v2015.Project createProject(com.servinglynk.hmis.warehouse.model.v2015.Project project);
	   com.servinglynk.hmis.warehouse.model.v2015.Project updateProject(com.servinglynk.hmis.warehouse.model.v2015.Project project);
	   void deleteProject(com.servinglynk.hmis.warehouse.model.v2015.Project project);
	   com.servinglynk.hmis.warehouse.model.v2015.Project getProjectById(UUID projectId);
	   List<com.servinglynk.hmis.warehouse.model.v2015.Project> getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems);
	   long getProjectCount(String getAllProjects);
	   void populateUserProjectGroupCode(HmisBaseModel model,String caller);
	   com.servinglynk.hmis.warehouse.model.v2015.Project checkProjectExists(String projectName, String sourceSystemId);
}
