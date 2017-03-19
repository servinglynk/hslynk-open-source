package com.servinglynk.hmis.warehouse.base.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.core.model.BaseProjects;
public interface ProjectService {

   BaseProject createProject(BaseProject project,UUID organizationId,String caller);
   BaseProject updateProject(BaseProject project,String caller);
   BaseProject deleteProject(UUID projectId,String caller);
   BaseProject getProjectById(UUID projectId);
   BaseProjects getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems);
}
