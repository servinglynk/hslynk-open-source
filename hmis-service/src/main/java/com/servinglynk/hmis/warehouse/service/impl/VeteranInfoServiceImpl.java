package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfo;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfos;
import com.servinglynk.hmis.warehouse.model.live.Client;
import com.servinglynk.hmis.warehouse.service.VeteranInfoService;
import com.servinglynk.hmis.warehouse.service.converter.VeteranInfoConverter;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.VeteranInfoNotFoundException;


public class VeteranInfoServiceImpl extends ServiceBase implements VeteranInfoService  {

   @Transactional
   public VeteranInfo createVeteranInfo(VeteranInfo veteranInfo,UUID clientId,String caller){
	   
	   Client client = daoFactory.getClientDao().getClientById(clientId);
	   
	   if(client == null) throw new ClientNotFoundException();
	   
       com.servinglynk.hmis.warehouse.model.live.VeteranInfo pVeteranInfo = VeteranInfoConverter.modelToEntity(veteranInfo, null);

       pVeteranInfo.setClient(client);
       pVeteranInfo.setDateCreated(LocalDateTime.now());
  //     pVeteranInfo.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getVeteranInfoDao().createVeteranInfo(pVeteranInfo);
       veteranInfo.setVeteranInfoId(pVeteranInfo.getId());
       return veteranInfo;
   }


   @Transactional
   public VeteranInfo updateVeteranInfo(VeteranInfo veteranInfo,UUID clientId,String caller){
	   
       com.servinglynk.hmis.warehouse.model.live.VeteranInfo pVeteranInfo = daoFactory.getVeteranInfoDao().getVeteranInfoById(veteranInfo.getVeteranInfoId());
       if(pVeteranInfo==null) throw new VeteranInfoNotFoundException();
       
	   Client client = daoFactory.getClientDao().getClientById(clientId);
	   
	   if(client == null) throw new ClientNotFoundException();


       VeteranInfoConverter.modelToEntity(veteranInfo, pVeteranInfo);
       pVeteranInfo.setClient(client);
       pVeteranInfo.setDateUpdated(LocalDateTime.now());
//       pVeteranInfo.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getVeteranInfoDao().updateVeteranInfo(pVeteranInfo);
       veteranInfo.setVeteranInfoId(pVeteranInfo.getId());
       return veteranInfo;
   }


   @Transactional
   public VeteranInfo deleteVeteranInfo(UUID veteranInfoId,String caller){
       com.servinglynk.hmis.warehouse.model.live.VeteranInfo pVeteranInfo = daoFactory.getVeteranInfoDao().getVeteranInfoById(veteranInfoId);
       if(pVeteranInfo==null) throw new VeteranInfoNotFoundException();

       daoFactory.getVeteranInfoDao().deleteVeteranInfo(pVeteranInfo);
       return new VeteranInfo();
   }


   @Transactional
   public VeteranInfo getVeteranInfoById(UUID veteranInfoId){
       com.servinglynk.hmis.warehouse.model.live.VeteranInfo pVeteranInfo = daoFactory.getVeteranInfoDao().getVeteranInfoById(veteranInfoId);
       if(pVeteranInfo==null) throw new VeteranInfoNotFoundException();

       return VeteranInfoConverter.entityToModel( pVeteranInfo );
   }


   @Transactional
   public VeteranInfos getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems){
       VeteranInfos veteranInfos = new VeteranInfos();
        List<com.servinglynk.hmis.warehouse.model.live.VeteranInfo> entities = daoFactory.getVeteranInfoDao().getAllClientVeteranInfos(clientId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.VeteranInfo entity : entities){
           veteranInfos.addVeteranInfo(VeteranInfoConverter.entityToModel(entity));
        }
        long count = daoFactory.getVeteranInfoDao().getClientVeteranInfosCount(clientId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(veteranInfos.getVeteranInfos().size());
        pagination.setTotal((int)count);
        veteranInfos.setPagination(pagination);
        return veteranInfos; 
   }


}
