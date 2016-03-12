package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfares;
import com.servinglynk.hmis.warehouse.service.FormerWardChildWelfareService;
import com.servinglynk.hmis.warehouse.service.converter.FormerWardChildWelfareConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.FormerWardChildWelfareNotFoundException;


public class FormerWardChildWelfareServiceImpl extends ServiceBase implements FormerWardChildWelfareService  {

   @Transactional
   public FormerWardChildWelfare createFormerWardChildWelfare(FormerWardChildWelfare formerWardChildWelfare,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare pFormerWardChildWelfare = FormerWardChildWelfareConverter.modelToEntity(formerWardChildWelfare, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pFormerWardChildWelfare.setEnrollmentid(pEnrollment); 
       pFormerWardChildWelfare.setDateCreated(LocalDateTime.now());
  //     pFormerWardChildWelfare.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getFormerwardchildwelfareDao().createFormerWardChildWelfare(pFormerWardChildWelfare);
       formerWardChildWelfare.setFormerWardChildWelfareId(pFormerWardChildWelfare.getId());
       return formerWardChildWelfare;
   }


   @Transactional
   public FormerWardChildWelfare updateFormerWardChildWelfare(FormerWardChildWelfare formerWardChildWelfare,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare pFormerWardChildWelfare = daoFactory.getFormerwardchildwelfareDao().getFormerWardChildWelfareById(formerWardChildWelfare.getFormerWardChildWelfareId());
       if(pFormerWardChildWelfare==null) throw new FormerWardChildWelfareNotFoundException();

       FormerWardChildWelfareConverter.modelToEntity(formerWardChildWelfare, pFormerWardChildWelfare);
       pFormerWardChildWelfare.setEnrollmentid(pEnrollment); 
       pFormerWardChildWelfare.setDateUpdated(LocalDateTime.now());
   //    pFormerWardChildWelfare.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getFormerwardchildwelfareDao().updateFormerWardChildWelfare(pFormerWardChildWelfare);
       formerWardChildWelfare.setFormerWardChildWelfareId(pFormerWardChildWelfare.getId());
       return formerWardChildWelfare;
   }


   @Transactional
   public FormerWardChildWelfare deleteFormerWardChildWelfare(UUID formerWardChildWelfareId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare pFormerWardChildWelfare = daoFactory.getFormerwardchildwelfareDao().getFormerWardChildWelfareById(formerWardChildWelfareId);
       if(pFormerWardChildWelfare==null) throw new FormerWardChildWelfareNotFoundException();

       daoFactory.getFormerwardchildwelfareDao().deleteFormerWardChildWelfare(pFormerWardChildWelfare);
       return new FormerWardChildWelfare();
   }


   @Transactional
   public FormerWardChildWelfare getFormerWardChildWelfareById(UUID formerWardChildWelfareId){
       com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare pFormerWardChildWelfare = daoFactory.getFormerwardchildwelfareDao().getFormerWardChildWelfareById(formerWardChildWelfareId);
       if(pFormerWardChildWelfare==null) throw new FormerWardChildWelfareNotFoundException();

       return FormerWardChildWelfareConverter.entityToModel( pFormerWardChildWelfare );
   }


   @Transactional
   public FormerWardChildWelfares getAllEnrollmentFormerWardChildWelfares(UUID enrollmentId,Integer startIndex, Integer maxItems){
       FormerWardChildWelfares formerWardChildWelfares = new FormerWardChildWelfares();
        List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare> entities = daoFactory.getFormerwardchildwelfareDao().getAllEnrollmentFormerWardChildWelfares(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare entity : entities){
           formerWardChildWelfares.addFormerWardChildWelfare(FormerWardChildWelfareConverter.entityToModel(entity));
        }
        long count = daoFactory.getFormerwardchildwelfareDao().getEnrollmentFormerWardChildWelfaresCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(formerWardChildWelfares.getFormerWardChildWelfares().size());
        pagination.setTotal((int)count);
        formerWardChildWelfares.setPagination(pagination);
        return formerWardChildWelfares; 
   }


}
