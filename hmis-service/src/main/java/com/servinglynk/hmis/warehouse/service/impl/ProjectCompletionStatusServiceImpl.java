package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatuses;
import com.servinglynk.hmis.warehouse.service.ProjectCompletionStatusService;
import com.servinglynk.hmis.warehouse.service.converter.ProjectCompletionStatusConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectCompletionStatusNotFoundException;


public class ProjectCompletionStatusServiceImpl extends ServiceBase implements ProjectCompletionStatusService  {

   @Transactional
   public ProjectCompletionStatus createProjectCompletionStatus(ProjectCompletionStatus projectCompletionStatus,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus pProjectCompletionStatus = ProjectCompletionStatusConverter.modelToEntity(projectCompletionStatus, null);
       com.servinglynk.hmis.warehouse.model.live.Exit pExit = daoFactory.getExitDao().getExitById(exitId); 
       if(pExit == null) throw new ExitNotFoundException(); 
       pProjectCompletionStatus.setExitid(pExit); 
       pProjectCompletionStatus.setDateCreated(LocalDateTime.now());
       pProjectCompletionStatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectcompletionstatusDao().createProjectCompletionStatus(pProjectCompletionStatus);
       projectCompletionStatus.setProjectCompletionStatusId(pProjectCompletionStatus.getId());
       return projectCompletionStatus;
   }


   @Transactional
   public ProjectCompletionStatus updateProjectCompletionStatus(ProjectCompletionStatus projectCompletionStatus,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Exit pExit = daoFactory.getExitDao().getExitById(exitId); 
       if(pExit == null) throw new ExitNotFoundException(); 
       com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus pProjectCompletionStatus = daoFactory.getProjectcompletionstatusDao().getProjectCompletionStatusById(projectCompletionStatus.getProjectCompletionStatusId());
       if(pProjectCompletionStatus==null) throw new ProjectCompletionStatusNotFoundException();

       ProjectCompletionStatusConverter.modelToEntity(projectCompletionStatus, pProjectCompletionStatus);
       pProjectCompletionStatus.setExitid(pExit); 
       pProjectCompletionStatus.setDateUpdated(LocalDateTime.now());
       pProjectCompletionStatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectcompletionstatusDao().updateProjectCompletionStatus(pProjectCompletionStatus);
       projectCompletionStatus.setProjectCompletionStatusId(pProjectCompletionStatus.getId());
       return projectCompletionStatus;
   }


   @Transactional
   public ProjectCompletionStatus deleteProjectCompletionStatus(UUID projectCompletionStatusId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus pProjectCompletionStatus = daoFactory.getProjectcompletionstatusDao().getProjectCompletionStatusById(projectCompletionStatusId);
       if(pProjectCompletionStatus==null) throw new ProjectCompletionStatusNotFoundException();

       daoFactory.getProjectcompletionstatusDao().deleteProjectCompletionStatus(pProjectCompletionStatus);
       return new ProjectCompletionStatus();
   }


   @Transactional
   public ProjectCompletionStatus getProjectCompletionStatusById(UUID projectCompletionStatusId){
       com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus pProjectCompletionStatus = daoFactory.getProjectcompletionstatusDao().getProjectCompletionStatusById(projectCompletionStatusId);
       if(pProjectCompletionStatus==null) throw new ProjectCompletionStatusNotFoundException();

       return ProjectCompletionStatusConverter.entityToModel( pProjectCompletionStatus );
   }


   @Transactional
   public ProjectCompletionStatuses getAllEnrollmentProjectCompletionStatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
       ProjectCompletionStatuses projectCompletionStatuss = new ProjectCompletionStatuses();
        List<com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus> entities = daoFactory.getProjectcompletionstatusDao().getAllExitProjectCompletionStatuses(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus entity : entities){
           projectCompletionStatuss.addProjectCompletionStatus(ProjectCompletionStatusConverter.entityToModel(entity));
        }
        long count = daoFactory.getProjectcompletionstatusDao().getExitProjectCompletionStatusesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(projectCompletionStatuss.getProjectCompletionStatuss().size());
        pagination.setTotal((int)count);
        projectCompletionStatuss.setPagination(pagination);
        return projectCompletionStatuss; 
   }


}
