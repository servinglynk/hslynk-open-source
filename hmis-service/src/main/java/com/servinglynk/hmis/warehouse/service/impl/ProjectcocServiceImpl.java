package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.core.model.Projectcocs;
import com.servinglynk.hmis.warehouse.service.ProjectcocService;
import com.servinglynk.hmis.warehouse.service.converter.ProjectcocConverter;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectcocNotFoundException;


public class ProjectcocServiceImpl extends ServiceBase implements ProjectcocService  {

   @Transactional
   public Projectcoc createProjectcoc(Projectcoc projectcoc,UUID projectId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Projectcoc pProjectcoc = ProjectcocConverter.modelToEntity(projectcoc, null);
       com.servinglynk.hmis.warehouse.model.live.Project pProject = daoFactory.getProjectDao().getProjectById(projectId); 
       if(pProject == null) throw new ProjectNotFoundException(); 
       pProjectcoc.setProjectid(pProject); 
       pProjectcoc.setDateCreated(LocalDateTime.now());
 //      pProjectcoc.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectcocDao().createProjectcoc(pProjectcoc);
       projectcoc.setProjectcocId(pProjectcoc.getId());
       return projectcoc;
   }


   @Transactional
   public Projectcoc updateProjectcoc(Projectcoc projectcoc,UUID projectId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Project pProject = daoFactory.getProjectDao().getProjectById(projectId); 
       if(pProject == null) throw new ProjectNotFoundException(); 
       com.servinglynk.hmis.warehouse.model.live.Projectcoc pProjectcoc = daoFactory.getProjectcocDao().getProjectcocById(projectcoc.getProjectcocId());
       if(pProjectcoc==null) throw new ProjectcocNotFoundException();

       ProjectcocConverter.modelToEntity(projectcoc, pProjectcoc);
       pProjectcoc.setProjectid(pProject); 
       pProjectcoc.setDateUpdated(LocalDateTime.now());
   //    pProjectcoc.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectcocDao().updateProjectcoc(pProjectcoc);
       projectcoc.setProjectcocId(pProjectcoc.getId());
       return projectcoc;
   }


   @Transactional
   public Projectcoc deleteProjectcoc(UUID projectcocId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Projectcoc pProjectcoc = daoFactory.getProjectcocDao().getProjectcocById(projectcocId);
       if(pProjectcoc==null) throw new ProjectcocNotFoundException();

       daoFactory.getProjectcocDao().deleteProjectcoc(pProjectcoc);
       return new Projectcoc();
   }


   @Transactional
   public Projectcoc getProjectcocById(UUID projectcocId){
       com.servinglynk.hmis.warehouse.model.live.Projectcoc pProjectcoc = daoFactory.getProjectcocDao().getProjectcocById(projectcocId);
       if(pProjectcoc==null) throw new ProjectcocNotFoundException();

       return ProjectcocConverter.entityToModel( pProjectcoc );
   }


   @Transactional
   public Projectcocs getAllProjectProjectcocs(UUID projectId,Integer startIndex, Integer maxItems){
       Projectcocs projectcocs = new Projectcocs();
        List<com.servinglynk.hmis.warehouse.model.live.Projectcoc> entities = daoFactory.getProjectcocDao().getAllProjectProjectcocs(projectId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Projectcoc entity : entities){
           projectcocs.addProjectcoc(ProjectcocConverter.entityToModel(entity));
        }
        long count = daoFactory.getProjectcocDao().getProjectProjectcocsCount(projectId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(projectcocs.getProjectcocs().size());
        pagination.setTotal((int)count);
        projectcocs.setPagination(pagination);
        return projectcocs; 
   }


}
