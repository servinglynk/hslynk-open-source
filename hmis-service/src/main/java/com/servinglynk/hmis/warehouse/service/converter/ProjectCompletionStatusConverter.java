package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
public class ProjectCompletionStatusConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus modelToEntity (ProjectCompletionStatus model ,com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus();
       entity.setId(model.getProjectCompletionStatusId());
       entity.setEarlyexitreason(ProjectcompletionstatusEarlyexitreasonEnum.valueOf(model.getEarlyExitReason()));
       entity.setProjectcompletionstatus(ProjectcompletionstatusProjectcompletionstatusEnum.valueOf(model.getProjectCompletionStatus()));
       return entity;    
   }


   public static ProjectCompletionStatus entityToModel (com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus entity) {
       ProjectCompletionStatus model = new ProjectCompletionStatus();
       model.setProjectCompletionStatusId(entity.getId());
       model.setEarlyExitReason(entity.getEarlyexitreason().name());
       model.setProjectCompletionStatus(entity.getProjectcompletionstatus().name());
       return model;
   }


}
