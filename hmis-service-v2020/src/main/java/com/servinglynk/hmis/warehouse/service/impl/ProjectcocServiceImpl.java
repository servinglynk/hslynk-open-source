package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.core.model.Projectcocs;
import com.servinglynk.hmis.warehouse.service.ProjectcocService;
import com.servinglynk.hmis.warehouse.service.converter.CocConverter;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.CocNotFoundException;


public class ProjectcocServiceImpl extends ServiceBase implements ProjectcocService  {

   @Transactional
   public Projectcoc createProjectcoc(Projectcoc projectcoc,UUID projectId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Coc pCoc = CocConverter.modelToEntity(projectcoc, null);
       com.servinglynk.hmis.warehouse.model.v2020.Project pProject = daoFactory.getProjectDao().getProjectById(projectId);
       if(pProject == null) throw new ProjectNotFoundException();
       pCoc.setProjectid(pProject);
       pCoc.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pCoc, caller);
       daoFactory.getCocDao().createCoc(pCoc);
       projectcoc.setProjectcocId(pCoc.getId());
       return projectcoc;
   }


   @Transactional
   public Projectcoc updateProjectcoc(Projectcoc projectcoc,UUID projectId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Project pProject = daoFactory.getProjectDao().getProjectById(projectId);
       if(pProject == null) throw new ProjectNotFoundException();
       com.servinglynk.hmis.warehouse.model.v2020.Coc pCoc = daoFactory.getCocDao().getCocById(projectcoc.getProjectcocId());
       if(pCoc==null) throw new CocNotFoundException();

       CocConverter.modelToEntity(projectcoc, pCoc);
       pCoc.setProjectid(pProject);
       pCoc.setDateUpdated(LocalDateTime.now());
       pCoc.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getCocDao().updateCoc(pCoc);
       projectcoc.setProjectcocId(pCoc.getId());
       return projectcoc;
   }


   @Transactional
   public Projectcoc deleteProjectcoc(UUID projectcocId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Coc pCoc = daoFactory.getCocDao().getCocById(projectcocId);
       if(pCoc==null) throw new CocNotFoundException();

       daoFactory.getCocDao().deleteCoc(pCoc);
       return new Projectcoc();
   }


   @Transactional
   public Projectcoc getProjectcocById(UUID projectcocId){
       com.servinglynk.hmis.warehouse.model.v2020.Coc pCoc = daoFactory.getCocDao().getCocById(projectcocId);
       if(pCoc==null) throw new CocNotFoundException();

       return CocConverter.entityToModel( pCoc );
   }


   @Transactional
   public Projectcocs getAllProjectCocs(UUID projectId,Integer startIndex, Integer maxItems){
	   Projectcocs cocs = new Projectcocs();
        List<com.servinglynk.hmis.warehouse.model.v2020.Coc> entities = daoFactory.getCocDao().getAllCocs(projectId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.Coc entity : entities){
        	cocs.addProjectcoc(CocConverter.entityToModel(entity));
        }
        long count = daoFactory.getCocDao().getCocsCount(projectId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(cocs.getProjectcocs().size());
        pagination.setTotal((int)count);
        cocs.setPagination(pagination);
        return cocs;
   }
   @Transactional
   public Projectcocs getAllCocsByDistictCocCode(){
	   Projectcocs cocs = new Projectcocs();
        List<com.servinglynk.hmis.warehouse.model.v2020.Coc> entities = daoFactory.getCocDao().getAllCocsByDistictCocCode();
        for(com.servinglynk.hmis.warehouse.model.v2020.Coc entity : entities){
        	cocs.addProjectcoc(CocConverter.entityToModel(entity));
        }
        SortedPagination pagination = new SortedPagination();
        pagination.setReturned(cocs.getProjectcocs().size());
        pagination.setTotal((int)entities.size());
        cocs.setPagination(pagination);
        return cocs;
   }

}
