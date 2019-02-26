package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoars;
import com.servinglynk.hmis.warehouse.service.ConnectionwithsoarService;
import com.servinglynk.hmis.warehouse.service.converter.ConnectionwithsoarConverter;
import com.servinglynk.hmis.warehouse.service.exception.ConnectionwithsoarNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;


public class ConnectionwithsoarServiceImpl extends ServiceBase implements ConnectionwithsoarService  {

   @Transactional
   public Connectionwithsoar createConnectionwithsoar(Connectionwithsoar connectionwithsoar,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar pConnectionwithsoar = ConnectionwithsoarConverter.modelToEntity(connectionwithsoar, null);
       
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);

       if(pEnrollment == null) throw new EnrollmentNotFound();
       
       pConnectionwithsoar.setEnrollmentid(pEnrollment);
       pConnectionwithsoar.setDateCreated(LocalDateTime.now());
    //   pConnectionwithsoar.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectDao().populateUserProjectGroupCode(pConnectionwithsoar,caller);
       daoFactory.getConnectionWithSoarDao().createConnectionWithSoar(pConnectionwithsoar);
       connectionwithsoar.setConnectionwithsoarId(pConnectionwithsoar.getId());
       return connectionwithsoar;
   }


   @Transactional
   public Connectionwithsoar updateConnectionwithsoar(Connectionwithsoar connectionwithsoar,UUID enrollmentId,String caller){
     
	   com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);

       if(pEnrollment == null) throw new ExitNotFoundException();
       
	   
       com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar pConnectionwithsoar = daoFactory.getConnectionWithSoarDao().getConnectionWithSoarById(connectionwithsoar.getConnectionwithsoarId());
       if(pConnectionwithsoar==null) throw new ConnectionwithsoarNotFoundException();

       ConnectionwithsoarConverter.modelToEntity(connectionwithsoar, pConnectionwithsoar);

       pConnectionwithsoar.setEnrollmentid(pEnrollment);
       pConnectionwithsoar.setDateUpdated(LocalDateTime.now());
       pConnectionwithsoar.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getConnectionWithSoarDao().updateConnectionWithSoar(pConnectionwithsoar);
       connectionwithsoar.setConnectionwithsoarId(pConnectionwithsoar.getId());
       return connectionwithsoar;
   }


   @Transactional
   public Connectionwithsoar deleteConnectionwithsoar(UUID connectionwithsoarId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar pConnectionwithsoar = daoFactory.getConnectionWithSoarDao().getConnectionWithSoarById(connectionwithsoarId);
       if(pConnectionwithsoar==null) throw new ConnectionwithsoarNotFoundException();

       daoFactory.getConnectionWithSoarDao().deleteConnectionWithSoar(pConnectionwithsoar);
       return new Connectionwithsoar();
   }


   @Transactional
   public Connectionwithsoar getConnectionwithsoarById(UUID connectionwithsoarId){
       com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar pConnectionwithsoar = daoFactory.getConnectionWithSoarDao().getConnectionWithSoarById(connectionwithsoarId);
       if(pConnectionwithsoar==null) throw new ConnectionwithsoarNotFoundException();

       return ConnectionwithsoarConverter.entityToModel( pConnectionwithsoar );
   }


   @Transactional
   public Connectionwithsoars getAllEnrollmentConnectionwithsoars(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Connectionwithsoars connectionwithsoars = new Connectionwithsoars();
        List<com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar> entities = daoFactory.getConnectionWithSoarDao().getAllEnrollmentConnectionwithsoars(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar entity : entities){
           connectionwithsoars.addConnectionwithsoar(ConnectionwithsoarConverter.entityToModel(entity));
        }
        long count = daoFactory.getConnectionWithSoarDao().getEnrollmentConnectionwithsoarsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(connectionwithsoars.getConnectionwithsoars().size());
        pagination.setTotal((int)count);
        connectionwithsoars.setPagination(pagination);
        return connectionwithsoars; 
   }


}
