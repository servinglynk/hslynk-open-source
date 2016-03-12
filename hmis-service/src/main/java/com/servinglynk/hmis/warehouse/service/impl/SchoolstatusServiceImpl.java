package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatuses;
import com.servinglynk.hmis.warehouse.service.SchoolstatusService;
import com.servinglynk.hmis.warehouse.service.converter.SchoolstatusConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.SchoolstatusNotFoundException;


public class SchoolstatusServiceImpl extends ServiceBase implements SchoolstatusService  {

   @Transactional
   public Schoolstatus createSchoolstatus(Schoolstatus schoolstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus pSchoolstatus = SchoolstatusConverter.modelToEntity(schoolstatus, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pSchoolstatus.setEnrollmentid(pEnrollment); 
       pSchoolstatus.setDateCreated(LocalDateTime.now());
 //      pSchoolstatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getSchoolstatusDao().createSchoolstatus(pSchoolstatus);
       schoolstatus.setSchoolstatusId(pSchoolstatus.getId());
       return schoolstatus;
   }


   @Transactional
   public Schoolstatus updateSchoolstatus(Schoolstatus schoolstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus pSchoolstatus = daoFactory.getSchoolstatusDao().getSchoolstatusById(schoolstatus.getSchoolstatusId());
       if(pSchoolstatus==null) throw new SchoolstatusNotFoundException();

       SchoolstatusConverter.modelToEntity(schoolstatus, pSchoolstatus);
       pSchoolstatus.setEnrollmentid(pEnrollment); 
       pSchoolstatus.setDateUpdated(LocalDateTime.now());
   //    pSchoolstatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getSchoolstatusDao().updateSchoolstatus(pSchoolstatus);
       schoolstatus.setSchoolstatusId(pSchoolstatus.getId());
       return schoolstatus;
   }


   @Transactional
   public Schoolstatus deleteSchoolstatus(UUID schoolstatusId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus pSchoolstatus = daoFactory.getSchoolstatusDao().getSchoolstatusById(schoolstatusId);
       if(pSchoolstatus==null) throw new SchoolstatusNotFoundException();

       daoFactory.getSchoolstatusDao().deleteSchoolstatus(pSchoolstatus);
       return new Schoolstatus();
   }


   @Transactional
   public Schoolstatus getSchoolstatusById(UUID schoolstatusId){
       com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus pSchoolstatus = daoFactory.getSchoolstatusDao().getSchoolstatusById(schoolstatusId);
       if(pSchoolstatus==null) throw new SchoolstatusNotFoundException();

       return SchoolstatusConverter.entityToModel( pSchoolstatus );
   }


   @Transactional
   public Schoolstatuses getAllEnrollmentSchoolstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Schoolstatuses schoolstatuss = new Schoolstatuses();
        List<com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus> entities = daoFactory.getSchoolstatusDao().getAllEnrollmentSchoolstatuss(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus entity : entities){
           schoolstatuss.addSchoolstatus(SchoolstatusConverter.entityToModel(entity));
        }
        long count = daoFactory.getSchoolstatusDao().getEnrollmentSchoolstatussCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(schoolstatuss.getSchoolstatuses().size());
        pagination.setTotal((int)count);
        schoolstatuss.setPagination(pagination);
        return schoolstatuss; 
   }


}
