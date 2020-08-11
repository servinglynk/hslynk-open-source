package com.servinglynk.hmis.warehouse.service.impl;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.Exits;
import com.servinglynk.hmis.warehouse.service.EnrollmentLinksService;
import com.servinglynk.hmis.warehouse.service.ExitService;
import com.servinglynk.hmis.warehouse.service.converter.ExitConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;


public class ExitServiceImpl extends ServiceBase implements ExitService  {
	
	@Autowired
	EnrollmentLinksService enrollmentLinksService;

   @Transactional
   public Exit createExit(Exit exit,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Exit pExit = ExitConverter.modelToEntity(exit, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pExit.setEnrollmentid(pEnrollment);
       pExit.setDateCreated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pExit, caller);
       daoFactory.getExitDao().createExit(pExit);
       exit.setExitId(pExit.getId());
       return exit;
   }


   @Transactional
   public Exit updateExit(Exit exit,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();

	   com.servinglynk.hmis.warehouse.model.v2017.Exit pExit = daoFactory.getExitDao().getExitById(exit.getExitId());
       if(pExit==null) throw new ExitNotFoundException();

       ExitConverter.modelToEntity(exit, pExit);
       pExit.setEnrollmentid(pEnrollment);
       pExit.setDateUpdated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       pExit.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getExitDao().updateExit(pExit);
       exit.setExitId(pExit.getId());
       return exit;
   }


   @Transactional
   public Exit deleteExit(UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit==null) throw new ExitNotFoundException();

       daoFactory.getExitDao().deleteExit(pExit);
       return new Exit();
   }


   @Transactional
   public Exit getExitById(UUID exitId,boolean includeChildLinks){
       com.servinglynk.hmis.warehouse.model.v2017.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit==null) throw new ExitNotFoundException();

       Exit exit = ExitConverter.entityToModel( pExit );
       if(includeChildLinks) {
    	   exit.setExitLinks(enrollmentLinksService.getExitLinks(pExit.getEnrollmentid().getClient().getId(), pExit.getEnrollmentid().getId(),exitId));
       }
       return exit;
   }


   @Transactional
   public Exits getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Exits exits = new Exits();
        List<com.servinglynk.hmis.warehouse.model.v2017.Exit> entities = daoFactory.getExitDao().getAllEnrollmentExits(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Exit entity : entities){
           exits.addExit(ExitConverter.entityToModel(entity));
        }
        long count = daoFactory.getExitDao().getEnrollmentExitsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(exits.getExits().size());
        pagination.setTotal((int)count);
        exits.setPagination(pagination);
        return exits;
   }


}
