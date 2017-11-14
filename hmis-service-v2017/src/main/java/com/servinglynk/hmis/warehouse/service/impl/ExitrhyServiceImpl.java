package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Exitrhy;
import com.servinglynk.hmis.warehouse.core.model.Exitrhys;
import com.servinglynk.hmis.warehouse.service.ExitrhyService;
import com.servinglynk.hmis.warehouse.service.converter.ExitrhyConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitrhyNotFoundException;


public class ExitrhyServiceImpl extends ServiceBase implements ExitrhyService  {

   @Transactional
   public Exitrhy createExitrhy(Exitrhy exitrhy,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Exitrhy pExitrhy = ExitrhyConverter.modelToEntity(exitrhy, null);
       com.servinglynk.hmis.warehouse.model.v2017.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit == null) throw new ExitNotFoundException();
       pExitrhy.setExitid(pExit);
       pExitrhy.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pExitrhy, caller);
       daoFactory.getExitrhyDao().createExitrhy(pExitrhy);
       exitrhy.setExitrhyId(pExitrhy.getId());
       return exitrhy;
   }


   @Transactional
   public Exitrhy updateExitrhy(Exitrhy exitrhy,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit == null) throw new ExitNotFoundException();
       com.servinglynk.hmis.warehouse.model.v2017.Exitrhy pExitrhy = daoFactory.getExitrhyDao().getExitrhyById(exitrhy.getExitrhyId());
       if(pExitrhy==null) throw new ExitrhyNotFoundException();

       ExitrhyConverter.modelToEntity(exitrhy, pExitrhy);
       pExitrhy.setExitid(pExit);
       pExitrhy.setDateUpdated(LocalDateTime.now());
       pExitrhy.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getExitrhyDao().updateExitrhy(pExitrhy);
       exitrhy.setExitrhyId(pExitrhy.getId());
       return exitrhy;
   }


   @Transactional
   public Exitrhy deleteExitrhy(UUID exitrhyId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Exitrhy pExitrhy = daoFactory.getExitrhyDao().getExitrhyById(exitrhyId);
       if(pExitrhy==null) throw new ExitrhyNotFoundException();

       daoFactory.getExitrhyDao().deleteExitrhy(pExitrhy);
       return new Exitrhy();
   }

   @Transactional
   public Exitrhy getExitrhyById(UUID exitrhyId){
       com.servinglynk.hmis.warehouse.model.v2017.Exitrhy pExitrhy = daoFactory.getExitrhyDao().getExitrhyById(exitrhyId);
       if(pExitrhy==null) throw new ExitrhyNotFoundException();

       return ExitrhyConverter.entityToModel( pExitrhy );
   }

   @Transactional
   public Exitrhys getAllExitExitrhys(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Exitrhys exitrhys = new Exitrhys();
        List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy> entities = daoFactory.getExitrhyDao().getAllExitExitrhys(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy entity : entities){
           exitrhys.addExitrhy(ExitrhyConverter.entityToModel(entity));
        }
        long count = daoFactory.getExitrhyDao().getExitExitrhysCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(exitrhys.getExitrhys().size());
        pagination.setTotal((int)count);
        exitrhys.setPagination(pagination);
        return exitrhys;
   }
}
