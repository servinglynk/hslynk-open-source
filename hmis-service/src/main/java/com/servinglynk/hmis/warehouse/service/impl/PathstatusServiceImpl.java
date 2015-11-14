package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.core.model.Pathstatuses;
import com.servinglynk.hmis.warehouse.service.PathstatusService;
import com.servinglynk.hmis.warehouse.service.converter.PathstatusConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.PathstatusNotFoundException;


public class PathstatusServiceImpl extends ServiceBase implements PathstatusService  {

   @Transactional
   public Pathstatus createPathstatus(Pathstatus pathstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Pathstatus pPathstatus = PathstatusConverter.modelToEntity(pathstatus, null);
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pPathstatus.setEnrollmentid(pEnrollment); 
       pPathstatus.setDateCreated(LocalDateTime.now());
       pPathstatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getPathstatusDao().createPathstatus(pPathstatus);
       pathstatus.setPathstatusId(pPathstatus.getId());
       return pathstatus;
   }


   @Transactional
   public Pathstatus updatePathstatus(Pathstatus pathstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.live.Pathstatus pPathstatus = daoFactory.getPathstatusDao().getPathstatusById(pathstatus.getPathstatusId());
       if(pPathstatus==null) throw new PathstatusNotFoundException();

       PathstatusConverter.modelToEntity(pathstatus, pPathstatus);
       pPathstatus.setEnrollmentid(pEnrollment); 
       pPathstatus.setDateUpdated(LocalDateTime.now());
       pPathstatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getPathstatusDao().updatePathstatus(pPathstatus);
       pathstatus.setPathstatusId(pPathstatus.getId());
       return pathstatus;
   }


   @Transactional
   public Pathstatus deletePathstatus(UUID pathstatusId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Pathstatus pPathstatus = daoFactory.getPathstatusDao().getPathstatusById(pathstatusId);
       if(pPathstatus==null) throw new PathstatusNotFoundException();

       daoFactory.getPathstatusDao().deletePathstatus(pPathstatus);
       return new Pathstatus();
   }


   @Transactional
   public Pathstatus getPathstatusById(UUID pathstatusId){
       com.servinglynk.hmis.warehouse.model.live.Pathstatus pPathstatus = daoFactory.getPathstatusDao().getPathstatusById(pathstatusId);
       if(pPathstatus==null) throw new PathstatusNotFoundException();

       return PathstatusConverter.entityToModel( pPathstatus );
   }


   @Transactional
   public Pathstatuses getAllEnrollmentPathstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Pathstatuses pathstatuss = new Pathstatuses();
        List<com.servinglynk.hmis.warehouse.model.live.Pathstatus> entities = daoFactory.getPathstatusDao().getAllEnrollmentPathstatuss(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Pathstatus entity : entities){
           pathstatuss.addPathstatus(PathstatusConverter.entityToModel(entity));
        }
        long count = daoFactory.getPathstatusDao().getEnrollmentPathstatussCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(pathstatuss.getPathstatuses().size());
        pagination.setTotal((int)count);
        pathstatuss.setPagination(pagination);
        return pathstatuss; 
   }


}
