package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddresses;
import com.servinglynk.hmis.warehouse.service.LastPermanentAddressService;
import com.servinglynk.hmis.warehouse.service.converter.LastPermanentAddressConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.LastPermanentAddressNotFoundException;


public class LastPermanentAddressServiceImpl extends ServiceBase implements LastPermanentAddressService  {

   @Transactional
   public LastPermanentAddress createLastPermanentAddress(LastPermanentAddress lastPermanentAddress,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress pLastPermanentAddress = LastPermanentAddressConverter.modelToEntity(lastPermanentAddress, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pLastPermanentAddress.setEnrollmentid(pEnrollment); 
       pLastPermanentAddress.setDateCreated(LocalDateTime.now());
    //   pLastPermanentAddress.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getLastPermAddressDao().createLastPermanentAddress(pLastPermanentAddress);
       lastPermanentAddress.setLastPermanentAddressId(pLastPermanentAddress.getId());
       return lastPermanentAddress;
   }


   @Transactional
   public LastPermanentAddress updateLastPermanentAddress(LastPermanentAddress lastPermanentAddress,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress pLastPermanentAddress = daoFactory.getLastPermAddressDao().getLastPermanentAddressById(lastPermanentAddress.getLastPermanentAddressId());
       if(pLastPermanentAddress==null) throw new LastPermanentAddressNotFoundException();

       LastPermanentAddressConverter.modelToEntity(lastPermanentAddress, pLastPermanentAddress);
       pLastPermanentAddress.setEnrollmentid(pEnrollment); 
       pLastPermanentAddress.setDateUpdated(LocalDateTime.now());
  //     pLastPermanentAddress.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getLastPermAddressDao().updateLastPermanentAddress(pLastPermanentAddress);
       lastPermanentAddress.setLastPermanentAddressId(pLastPermanentAddress.getId());
       return lastPermanentAddress;
   }


   @Transactional
   public LastPermanentAddress deleteLastPermanentAddress(UUID lastPermanentAddressId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress pLastPermanentAddress = daoFactory.getLastPermAddressDao().getLastPermanentAddressById(lastPermanentAddressId);
       if(pLastPermanentAddress==null) throw new LastPermanentAddressNotFoundException();

       daoFactory.getLastPermAddressDao().deleteLastPermanentAddress(pLastPermanentAddress);
       return new LastPermanentAddress();
   }


   @Transactional
   public LastPermanentAddress getLastPermanentAddressById(UUID lastPermanentAddressId){
       com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress pLastPermanentAddress = daoFactory.getLastPermAddressDao().getLastPermanentAddressById(lastPermanentAddressId);
       if(pLastPermanentAddress==null) throw new LastPermanentAddressNotFoundException();

       return LastPermanentAddressConverter.entityToModel( pLastPermanentAddress );
   }


   @Transactional
   public LastPermanentAddresses getAllEnrollmentLastPermanentAddresss(UUID enrollmentId,Integer startIndex, Integer maxItems){
       LastPermanentAddresses lastPermanentAddresss = new LastPermanentAddresses();
        List<com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress> entities = daoFactory.getLastPermAddressDao().getAllEnrollmentLastPermanentAddresss(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress entity : entities){
           lastPermanentAddresss.addLastPermanentAddress(LastPermanentAddressConverter.entityToModel(entity));
        }
        long count = daoFactory.getLastPermAddressDao().getEnrollmentLastPermanentAddresssCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(lastPermanentAddresss.getLastPermanentAddresses().size());
        pagination.setTotal((int)count);
        lastPermanentAddresss.setPagination(pagination);
        return lastPermanentAddresss; 
   }


}
