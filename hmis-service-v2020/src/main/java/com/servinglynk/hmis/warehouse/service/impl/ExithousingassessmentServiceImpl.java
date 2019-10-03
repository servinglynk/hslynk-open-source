package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Exithousingassessment;
import com.servinglynk.hmis.warehouse.core.model.Exithousingassessments;
import com.servinglynk.hmis.warehouse.service.ExithousingassessmentService;
import com.servinglynk.hmis.warehouse.service.converter.ExithousingassessmentConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExithousingassessmentNotFoundException;


public class ExithousingassessmentServiceImpl extends ServiceBase implements ExithousingassessmentService  {

   @Transactional
   public Exithousingassessment createExithousingassessment(Exithousingassessment exithousingassessment,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment pExithousingassessment = ExithousingassessmentConverter.modelToEntity(exithousingassessment, null);
       com.servinglynk.hmis.warehouse.model.v2020.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit == null) throw new ExitNotFoundException();
       pExithousingassessment.setExitid(pExit);
       pExithousingassessment.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pExithousingassessment, caller);
       daoFactory.getExithousingassessmentDao().createExithousingassessment(pExithousingassessment);
       exithousingassessment.setExithousingassessmentId(pExithousingassessment.getId());
       return exithousingassessment;
   }


   @Transactional
   public Exithousingassessment updateExithousingassessment(Exithousingassessment exithousingassessment,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit == null) throw new ExitNotFoundException();
       com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment pExithousingassessment = daoFactory.getExithousingassessmentDao().getExithousingassessmentById(exithousingassessment.getExithousingassessmentId());
       if(pExithousingassessment==null) throw new ExithousingassessmentNotFoundException();

       ExithousingassessmentConverter.modelToEntity(exithousingassessment, pExithousingassessment);
       pExithousingassessment.setExitid(pExit);
       pExithousingassessment.setDateUpdated(LocalDateTime.now());
       pExithousingassessment.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getExithousingassessmentDao().updateExithousingassessment(pExithousingassessment);
       exithousingassessment.setExithousingassessmentId(pExithousingassessment.getId());
       return exithousingassessment;
   }


   @Transactional
   public Exithousingassessment deleteExithousingassessment(UUID exithousingassessmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment pExithousingassessment = daoFactory.getExithousingassessmentDao().getExithousingassessmentById(exithousingassessmentId);
       if(pExithousingassessment==null) throw new ExithousingassessmentNotFoundException();

       daoFactory.getExithousingassessmentDao().deleteExithousingassessment(pExithousingassessment);
       return new Exithousingassessment();
   }


   @Transactional
   public Exithousingassessment getExithousingassessmentById(UUID exithousingassessmentId){
       com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment pExithousingassessment = daoFactory.getExithousingassessmentDao().getExithousingassessmentById(exithousingassessmentId);
       if(pExithousingassessment==null) throw new ExithousingassessmentNotFoundException();

       return ExithousingassessmentConverter.entityToModel( pExithousingassessment );
   }


   @Transactional
   public Exithousingassessments getAllExitExithousingassessments(UUID exitId,Integer startIndex, Integer maxItems){
       Exithousingassessments exithousingassessments = new Exithousingassessments();
        List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment> entities = daoFactory.getExithousingassessmentDao().getAllExitExithousingassessments(exitId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment entity : entities){
           exithousingassessments.addExithousingassessment(ExithousingassessmentConverter.entityToModel(entity));
        }
        long count = daoFactory.getExithousingassessmentDao().getExitExithousingassessmentsCount(exitId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(exithousingassessments.getExithousingassessments().size());
        pagination.setTotal((int)count);
        exithousingassessments.setPagination(pagination);
        return exithousingassessments;
   }


}
