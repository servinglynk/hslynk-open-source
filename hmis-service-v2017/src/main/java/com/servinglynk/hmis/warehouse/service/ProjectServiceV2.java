package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projects;
public interface ProjectServiceV2 {

   Project getProjectById(UUID projectId);
   Projects getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems);
}
