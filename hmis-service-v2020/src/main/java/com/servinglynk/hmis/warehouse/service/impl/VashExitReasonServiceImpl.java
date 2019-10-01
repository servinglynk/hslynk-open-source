package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.VashExitReason;
import com.servinglynk.hmis.warehouse.core.model.VashExitReasons;
import com.servinglynk.hmis.warehouse.service.VashExitReasonService;
import com.servinglynk.hmis.warehouse.service.converter.VashExitReasonConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.VashExitReasonNotFoundException;

public class VashExitReasonServiceImpl  extends ServiceBase implements VashExitReasonService  {

	   @Transactional
	   public VashExitReason createVashExitReason(VashExitReason vashExitReason,UUID exitId,String caller){
	       com.servinglynk.hmis.warehouse.model.v2020.VashExitReason pVashExitReason = VashExitReasonConverter.modelToEntity(vashExitReason, null);
	       com.servinglynk.hmis.warehouse.model.v2020.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
	       if(pExit == null) throw new ExitNotFoundException();
	       pVashExitReason.setExitid(pExit);
	       pVashExitReason.setDateCreated(LocalDateTime.now());
	       daoFactory.getProjectDao().populateUserProjectGroupCode(pVashExitReason, caller);
	       daoFactory.getVashExitReasonDao().createVashExitReason(pVashExitReason);
	       vashExitReason.setVashExitReasonId(pVashExitReason.getId());
	       return vashExitReason;
	   }


	   @Transactional
	   public VashExitReason updateVashExitReason(VashExitReason VashExitReason,UUID exitId,String caller){
	       com.servinglynk.hmis.warehouse.model.v2020.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
	       if(pExit == null) throw new ExitNotFoundException();
	       com.servinglynk.hmis.warehouse.model.v2020.VashExitReason pVashExitReason = daoFactory.getVashExitReasonDao().getVashExitReasonById(VashExitReason.getVashExitReasonId());
	       if(pVashExitReason==null) throw new VashExitReasonNotFoundException();

	       VashExitReasonConverter.modelToEntity(VashExitReason, pVashExitReason);
	       pVashExitReason.setExitid(pExit);
	       pVashExitReason.setDateUpdated(LocalDateTime.now());
	       pVashExitReason.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
	       daoFactory.getVashExitReasonDao().updateVashExitReason(pVashExitReason);
	       VashExitReason.setVashExitReasonId(pVashExitReason.getId());
	       return VashExitReason;
	   }


	   @Transactional
	   public VashExitReason deleteVashExitReason(UUID VashExitReasonId,String caller){
	       com.servinglynk.hmis.warehouse.model.v2020.VashExitReason pVashExitReason = daoFactory.getVashExitReasonDao().getVashExitReasonById(VashExitReasonId);
	       if(pVashExitReason==null) throw new VashExitReasonNotFoundException();

	       daoFactory.getVashExitReasonDao().deleteVashExitReason(pVashExitReason);
	       return new VashExitReason();
	   }

	   @Transactional
	   public VashExitReason getVashExitReasonById(UUID VashExitReasonId){
	       com.servinglynk.hmis.warehouse.model.v2020.VashExitReason pVashExitReason = daoFactory.getVashExitReasonDao().getVashExitReasonById(VashExitReasonId);
	       if(pVashExitReason==null) throw new VashExitReasonNotFoundException();

	       return VashExitReasonConverter.entityToModel( pVashExitReason );
	   }

	   @Transactional
	   public VashExitReasons getAllExitVashExitReasons(UUID exitId,Integer startIndex, Integer maxItems){
	       VashExitReasons vashExitReasons = new VashExitReasons();
	        List<com.servinglynk.hmis.warehouse.model.v2020.VashExitReason> entities = daoFactory.getVashExitReasonDao().getAllExitVashExitReasons(exitId, startIndex, maxItems);
	        for(com.servinglynk.hmis.warehouse.model.v2020.VashExitReason entity : entities){
	           vashExitReasons.addVashExitReason(VashExitReasonConverter.entityToModel(entity));
	        }
	        long count = daoFactory.getVashExitReasonDao().getExitVashExitReasonsCount(exitId);
	        SortedPagination pagination = new SortedPagination();

	        pagination.setFrom(startIndex);
	        pagination.setReturned(vashExitReasons.getVashExitReasons().size());
	        pagination.setTotal((int)count);
	        vashExitReasons.setPagination(pagination);
	        return vashExitReasons;
	   }
}
