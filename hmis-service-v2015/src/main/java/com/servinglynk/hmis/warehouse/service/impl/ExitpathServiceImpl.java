package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Exitpath;
import com.servinglynk.hmis.warehouse.core.model.Exitpaths;
import com.servinglynk.hmis.warehouse.service.ExitpathService;
import com.servinglynk.hmis.warehouse.service.converter.ExitpathConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitpathNotFoundException;


public class ExitpathServiceImpl extends ServiceBase implements ExitpathService  {

   @Transactional
   public Exitpath createExitpath(Exitpath exitpath,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Exitpath pExitpath = ExitpathConverter.modelToEntity(exitpath, null);
       com.servinglynk.hmis.warehouse.model.v2015.Exit pExit = daoFactory.getExitDao().getExitById(exitId); 
       if(pExit == null) throw new ExitNotFoundException(); 
       pExitpath.setExitid(pExit); 
       pExitpath.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pExitpath, caller);
       daoFactory.getExitpathDao().createExitpath(pExitpath);
       exitpath.setExitpathId(pExitpath.getId());
       return exitpath;
   }


   @Transactional
   public Exitpath updateExitpath(Exitpath exitpath,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Exit pExit = daoFactory.getExitDao().getExitById(exitId); 
       if(pExit == null) throw new ExitpathNotFoundException(); 
       com.servinglynk.hmis.warehouse.model.v2015.Exitpath pExitpath = daoFactory.getExitpathDao().getExitpathById(exitpath.getExitpathId());
       if(pExitpath==null) throw new ExitpathNotFoundException();

       ExitpathConverter.modelToEntity(exitpath, pExitpath);
       pExitpath.setExitid(pExit); 
       pExitpath.setDateUpdated(LocalDateTime.now());
       pExitpath.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getExitpathDao().updateExitpath(pExitpath);
       exitpath.setExitpathId(pExitpath.getId());
       return exitpath;
   }


   @Transactional
   public Exitpath deleteExitpath(UUID exitpathId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Exitpath pExitpath = daoFactory.getExitpathDao().getExitpathById(exitpathId);
       if(pExitpath==null) throw new ExitpathNotFoundException();

       daoFactory.getExitpathDao().deleteExitpath(pExitpath);
       return new Exitpath();
   }


   @Transactional
   public Exitpath getExitpathById(UUID exitpathId){
       com.servinglynk.hmis.warehouse.model.v2015.Exitpath pExitpath = daoFactory.getExitpathDao().getExitpathById(exitpathId);
       if(pExitpath==null) throw new ExitpathNotFoundException();

       return ExitpathConverter.entityToModel( pExitpath );
   }


   @Transactional
   public Exitpaths getAllExitExitpaths(UUID exitId,Integer startIndex, Integer maxItems){
       Exitpaths exitpaths = new Exitpaths();
        List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> entities = daoFactory.getExitpathDao().getAllExitExitpaths(exitId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.Exitpath entity : entities){
           exitpaths.addExitpath(ExitpathConverter.entityToModel(entity));
        }
        long count = daoFactory.getExitpathDao().getExitExitpathsCount(exitId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(exitpaths.getExitpaths().size());
        pagination.setTotal((int)count);
        exitpaths.setPagination(pagination);
        return exitpaths; 
   }


}
