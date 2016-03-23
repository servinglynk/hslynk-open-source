package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
public class ProjectCompletionStatusConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus modelToEntity (ProjectCompletionStatus model ,com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus();
       if(model.getProjectCompletionStatusId()!=null)
       entity.setId(model.getProjectCompletionStatusId());
       if(model.getEarlyExitReason()!=null)
       entity.setEarlyexitreason(ProjectcompletionstatusEarlyexitreasonEnum.lookupEnum(model.getEarlyExitReason().toString()));
       if(model.getProjectCompletionStatus()!=null)
       entity.setProjectcompletionstatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(model.getProjectCompletionStatus().toString()));
       return entity;    
   }


   public static ProjectCompletionStatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus entity) {
       ProjectCompletionStatus model = new ProjectCompletionStatus();
       if(entity.getId()!=null)
       model.setProjectCompletionStatusId(entity.getId());
       if(entity.getEarlyexitreason()!=null)
       model.setEarlyExitReason(Integer.parseInt(entity.getEarlyexitreason().getValue()));
       if(entity.getProjectcompletionstatus()!=null)
       model.setProjectCompletionStatus(Integer.parseInt(entity.getProjectcompletionstatus().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
