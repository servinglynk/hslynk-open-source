package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindates;
import com.servinglynk.hmis.warehouse.service.ResidentialmoveindateService;
import com.servinglynk.hmis.warehouse.service.converter.ResidentialmoveindateConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ResidentialmoveindateNotFoundException;


public class ResidentialmoveindateServiceImpl extends ServiceBase implements ResidentialmoveindateService  {

   @Transactional
   public Residentialmoveindate createResidentialmoveindate(Residentialmoveindate residentialmoveindate,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate pResidentialmoveindate = ResidentialmoveindateConverter.modelToEntity(residentialmoveindate, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pResidentialmoveindate.setEnrollmentid(pEnrollment); 
       pResidentialmoveindate.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pResidentialmoveindate, caller);
       daoFactory.getResidentialmoveindateDao().createResidentialmoveindate(pResidentialmoveindate);
       residentialmoveindate.setResidentialmoveindateId(pResidentialmoveindate.getId());
       return residentialmoveindate;
   }


   @Transactional
   public Residentialmoveindate updateResidentialmoveindate(Residentialmoveindate residentialmoveindate,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate pResidentialmoveindate = daoFactory.getResidentialmoveindateDao().getResidentialmoveindateById(residentialmoveindate.getResidentialmoveindateId());
       if(pResidentialmoveindate==null) throw new ResidentialmoveindateNotFoundException();

       ResidentialmoveindateConverter.modelToEntity(residentialmoveindate, pResidentialmoveindate);
       pResidentialmoveindate.setEnrollmentid(pEnrollment); 
       pResidentialmoveindate.setDateUpdated(LocalDateTime.now());
    //   pResidentialmoveindate.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getResidentialmoveindateDao().updateResidentialmoveindate(pResidentialmoveindate);
       residentialmoveindate.setResidentialmoveindateId(pResidentialmoveindate.getId());
       return residentialmoveindate;
   }


   @Transactional
   public Residentialmoveindate deleteResidentialmoveindate(UUID residentialmoveindateId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate pResidentialmoveindate = daoFactory.getResidentialmoveindateDao().getResidentialmoveindateById(residentialmoveindateId);
       if(pResidentialmoveindate==null) throw new ResidentialmoveindateNotFoundException();

       daoFactory.getResidentialmoveindateDao().deleteResidentialmoveindate(pResidentialmoveindate);
       return new Residentialmoveindate();
   }


   @Transactional
   public Residentialmoveindate getResidentialmoveindateById(UUID residentialmoveindateId){
       com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate pResidentialmoveindate = daoFactory.getResidentialmoveindateDao().getResidentialmoveindateById(residentialmoveindateId);
       if(pResidentialmoveindate==null) throw new ResidentialmoveindateNotFoundException();

       return ResidentialmoveindateConverter.entityToModel( pResidentialmoveindate );
   }


   @Transactional
   public Residentialmoveindates getAllEnrollmentResidentialmoveindates(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Residentialmoveindates residentialmoveindates = new Residentialmoveindates();
        List<com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate> entities = daoFactory.getResidentialmoveindateDao().getAllEnrollmentResidentialmoveindates(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate entity : entities){
           residentialmoveindates.addResidentialmoveindate(ResidentialmoveindateConverter.entityToModel(entity));
        }
        long count = daoFactory.getResidentialmoveindateDao().getEnrollmentResidentialmoveindatesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(residentialmoveindates.getResidentialmoveindates().size());
        pagination.setTotal((int)count);
        residentialmoveindates.setPagination(pagination);
        return residentialmoveindates; 
   }


}
