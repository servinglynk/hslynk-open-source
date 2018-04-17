/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;

/**
 * @author Sandeep
 *
 */
public interface ProjectDao extends ParentDao {
	   com.servinglynk.hmis.warehouse.model.v2017.Project createProject(com.servinglynk.hmis.warehouse.model.v2017.Project project);
	   com.servinglynk.hmis.warehouse.model.v2017.Project updateProject(com.servinglynk.hmis.warehouse.model.v2017.Project project);
	   void deleteProject(com.servinglynk.hmis.warehouse.model.v2017.Project project);
	   com.servinglynk.hmis.warehouse.model.v2017.Project getProjectById(UUID projectId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.Project> getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems);
	   long getProjectCount(String getAllProjects);
	   void populateUserProjectGroupCode(HmisBaseModel model,String caller);
	Boolean checkProjectExists(String projectName, String sourceSystemId);
}
