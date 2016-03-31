package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional; 

import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.service.RhybcpstatusService;
import com.servinglynk.hmis.warehouse.service.converter.RhybcpstatusConverter;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatuses;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.RhybcpstatusNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class RhybcpstatusServiceImpl extends ServiceBase implements RhybcpstatusService  {

   @Transactional
   public Rhybcpstatus createRhybcpstatus(Rhybcpstatus rhybcpstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus pRhybcpstatus = RhybcpstatusConverter.modelToEntity(rhybcpstatus, null);
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pRhybcpstatus.setEnrollmentid(pEnrollment); 
       pRhybcpstatus.setDateCreated(LocalDateTime.now());
//       pRhybcpstatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getRhybcpstatusDao().createRhybcpstatus(pRhybcpstatus);
       rhybcpstatus.setRhybcpstatusId(pRhybcpstatus.getId());
       return rhybcpstatus;
   }


   @Transactional
   public Rhybcpstatus updateRhybcpstatus(Rhybcpstatus rhybcpstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus pRhybcpstatus = daoFactory.getRhybcpstatusDao().getRhybcpstatusById(rhybcpstatus.getRhybcpstatusId());
       if(pRhybcpstatus==null) throw new RhybcpstatusNotFoundException();

       RhybcpstatusConverter.modelToEntity(rhybcpstatus, pRhybcpstatus);
       pRhybcpstatus.setEnrollmentid(pEnrollment); 
       pRhybcpstatus.setDateUpdated(LocalDateTime.now());
  //     pRhybcpstatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getRhybcpstatusDao().updateRhybcpstatus(pRhybcpstatus);
       rhybcpstatus.setRhybcpstatusId(pRhybcpstatus.getId());
       return rhybcpstatus;
   }


   @Transactional
   public Rhybcpstatus deleteRhybcpstatus(UUID rhybcpstatusId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus pRhybcpstatus = daoFactory.getRhybcpstatusDao().getRhybcpstatusById(rhybcpstatusId);
       if(pRhybcpstatus==null) throw new RhybcpstatusNotFoundException();

       daoFactory.getRhybcpstatusDao().deleteRhybcpstatus(pRhybcpstatus);
       return new Rhybcpstatus();
   }


   @Transactional
   public Rhybcpstatus getRhybcpstatusById(UUID rhybcpstatusId){
       com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus pRhybcpstatus = daoFactory.getRhybcpstatusDao().getRhybcpstatusById(rhybcpstatusId);
       if(pRhybcpstatus==null) throw new RhybcpstatusNotFoundException();

       return RhybcpstatusConverter.entityToModel( pRhybcpstatus );
   }


   @Transactional
   public Rhybcpstatuses getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	   Rhybcpstatuses rhybcpstatuss = new Rhybcpstatuses();
        List<com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus> entities = daoFactory.getRhybcpstatusDao().getAllEnrollmentRhybcpstatuss(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus entity : entities){
           rhybcpstatuss.addRhybcpstatus(RhybcpstatusConverter.entityToModel(entity));
        }
        long count = daoFactory.getRhybcpstatusDao().getEnrollmentRhybcpstatussCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(rhybcpstatuss.getRhybcpstatuses().size());
        pagination.setTotal((int)count);
        rhybcpstatuss.setPagination(pagination);
        return rhybcpstatuss; 
   }


}
