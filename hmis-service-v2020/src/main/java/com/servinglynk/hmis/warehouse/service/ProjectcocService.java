package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.core.model.Projectcocs;
public interface ProjectcocService {

   Projectcoc createProjectcoc(Projectcoc projectcoc,UUID projectId,String caller);
   Projectcoc updateProjectcoc(Projectcoc projectcoc,UUID projectId,String caller);
   Projectcoc deleteProjectcoc(UUID projectId,String caller);
   Projectcoc getProjectcocById(UUID projectId);
   Projectcocs getAllProjectCocs(UUID projectId,Integer startIndex, Integer maxItems);
}
