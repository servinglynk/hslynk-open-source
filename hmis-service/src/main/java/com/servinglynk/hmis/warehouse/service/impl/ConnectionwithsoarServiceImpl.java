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
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;


public class ConnectionwithsoarServiceImpl extends ServiceBase implements ConnectionwithsoarService  {

   @Transactional
   public Connectionwithsoar createConnectionwithsoar(Connectionwithsoar connectionwithsoar,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar pConnectionwithsoar = ConnectionwithsoarConverter.modelToEntity(connectionwithsoar, null);
       
       com.servinglynk.hmis.warehouse.model.live.Exit pExit = daoFactory.getExitDao().getExitById(exitId);

       if(pExit == null) throw new ExitNotFoundException();
       
       pConnectionwithsoar.setExitid(pExit);
       pConnectionwithsoar.setDateCreated(LocalDateTime.now());
       pConnectionwithsoar.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getConnectionwithsoarDao().createConnectionwithsoar(pConnectionwithsoar);
       connectionwithsoar.setConnectionwithsoarId(pConnectionwithsoar.getId());
       return connectionwithsoar;
   }


   @Transactional
   public Connectionwithsoar updateConnectionwithsoar(Connectionwithsoar connectionwithsoar,UUID exitId,String caller){
     
	   com.servinglynk.hmis.warehouse.model.live.Exit pExit = daoFactory.getExitDao().getExitById(exitId);

       if(pExit == null) throw new ExitNotFoundException();
       
	   
       com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar pConnectionwithsoar = daoFactory.getConnectionwithsoarDao().getConnectionwithsoarById(connectionwithsoar.getConnectionwithsoarId());
       if(pConnectionwithsoar==null) throw new ConnectionwithsoarNotFoundException();

       ConnectionwithsoarConverter.modelToEntity(connectionwithsoar, pConnectionwithsoar);

       pConnectionwithsoar.setExitid(pExit);
       pConnectionwithsoar.setDateUpdated(LocalDateTime.now());
       pConnectionwithsoar.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getConnectionwithsoarDao().updateConnectionwithsoar(pConnectionwithsoar);
       connectionwithsoar.setConnectionwithsoarId(pConnectionwithsoar.getId());
       return connectionwithsoar;
   }


   @Transactional
   public Connectionwithsoar deleteConnectionwithsoar(UUID connectionwithsoarId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar pConnectionwithsoar = daoFactory.getConnectionwithsoarDao().getConnectionwithsoarById(connectionwithsoarId);
       if(pConnectionwithsoar==null) throw new ConnectionwithsoarNotFoundException();

       daoFactory.getConnectionwithsoarDao().deleteConnectionwithsoar(pConnectionwithsoar);
       return new Connectionwithsoar();
   }


   @Transactional
   public Connectionwithsoar getConnectionwithsoarById(UUID connectionwithsoarId){
       com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar pConnectionwithsoar = daoFactory.getConnectionwithsoarDao().getConnectionwithsoarById(connectionwithsoarId);
       if(pConnectionwithsoar==null) throw new ConnectionwithsoarNotFoundException();

       return ConnectionwithsoarConverter.entityToModel( pConnectionwithsoar );
   }


   @Transactional
   public Connectionwithsoars getAllExitConnectionwithsoars(UUID exitId,Integer startIndex, Integer maxItems){
       Connectionwithsoars connectionwithsoars = new Connectionwithsoars();
        List<com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar> entities = daoFactory.getConnectionwithsoarDao().getAllExitConnectionwithsoars(exitId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar entity : entities){
           connectionwithsoars.addConnectionwithsoar(ConnectionwithsoarConverter.entityToModel(entity));
        }
        long count = daoFactory.getConnectionwithsoarDao().getExitConnectionwithsoarsCount(exitId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(connectionwithsoars.getConnectionwithsoars().size());
        pagination.setTotal((int)count);
        connectionwithsoars.setPagination(pagination);
        return connectionwithsoars; 
   }


}
