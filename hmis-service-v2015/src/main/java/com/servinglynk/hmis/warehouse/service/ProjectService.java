package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projects;
public interface ProjectService {

   Project createProject(Project project,UUID organizationId,String caller);
   Project updateProject(Project project,String caller);
   Project deleteProject(UUID projectId,String caller);
   Project getProjectById(UUID projectId);
   Projects getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems);
}
