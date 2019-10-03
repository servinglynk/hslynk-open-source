package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.RhyAfterCare;
import com.servinglynk.hmis.warehouse.core.model.RhyAfterCares;
import com.servinglynk.hmis.warehouse.service.RHYAfterCareService;
import com.servinglynk.hmis.warehouse.service.converter.RhyAfterCareConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitrhyNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RhyAfterCareNotFoundException;

public class RHYAfterCareServiceImpl  extends ServiceBase implements RHYAfterCareService {

	@Override
	public RhyAfterCare createRhyAfterCare(RhyAfterCare rhyAfterCare, UUID exitId, String caller) {
		com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare pRhyAfterCare = RhyAfterCareConverter.modelToEntity(rhyAfterCare, null);
	       com.servinglynk.hmis.warehouse.model.v2020.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
	       if(pExit == null) throw new ExitNotFoundException();
	       pRhyAfterCare.setExitid(pExit);
	       pRhyAfterCare.setDateCreated(LocalDateTime.now());
	       daoFactory.getProjectDao().populateUserProjectGroupCode(pRhyAfterCare, caller);
	       daoFactory.getRhyAfterCareDao().createRhyAfterCare(pRhyAfterCare);
	       rhyAfterCare.setRhyAfterCareId(pRhyAfterCare.getId());
	       return rhyAfterCare;
	}

	@Override
	public RhyAfterCare updateRhyAfterCare(RhyAfterCare rhyAfterCare, UUID exitId, String caller) {
		com.servinglynk.hmis.warehouse.model.v2020.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
	       if(pExit == null) throw new ExitNotFoundException();
	       com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare pRHYAfterCare = daoFactory.getRhyAfterCareDao().getRhyAfterCareById(rhyAfterCare.getRhyAfterCareId());
	       if(pRHYAfterCare==null) throw new RhyAfterCareNotFoundException();

	       RhyAfterCareConverter.modelToEntity(rhyAfterCare, pRHYAfterCare);
	       pRHYAfterCare.setExitid(pExit);
	       pRHYAfterCare.setDateUpdated(LocalDateTime.now());
	       pRHYAfterCare.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
	       daoFactory.getRhyAfterCareDao().updateRhyAfterCare(pRHYAfterCare);
	       rhyAfterCare.setRhyAfterCareId(pRHYAfterCare.getId());
	       return rhyAfterCare;
	}

	@Override
	public RhyAfterCare deleteRhyAfterCare(UUID rhyAfterCareId, String caller) {
		  com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare pRHYAfterCare = daoFactory.getRhyAfterCareDao().getRhyAfterCareById(rhyAfterCareId);
	       if(pRHYAfterCare==null) throw new RhyAfterCareNotFoundException();

	       daoFactory.getRhyAfterCareDao().deleteRhyAfterCare(pRHYAfterCare);
	       return new RhyAfterCare();
	}

	@Override
	public RhyAfterCare getRhyAfterCareById(UUID rhyAfterCareId) {
		  com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare pRHYAfterCare = daoFactory.getRhyAfterCareDao().getRhyAfterCareById(rhyAfterCareId);
	       if(pRHYAfterCare==null) throw new RhyAfterCareNotFoundException();
	       return RhyAfterCareConverter.entityToModel(pRHYAfterCare);
	}

	@Override
	public RhyAfterCares getAllExitRhyAfterCares(UUID exitId, Integer startIndex, Integer maxItems) {
		RhyAfterCares rhyAfterCares = new RhyAfterCares();
        List<com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare> entities = daoFactory.getRhyAfterCareDao().getAllExitRHYAfterCares(exitId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare entity : entities){
        	rhyAfterCares.addRhyaftercares(RhyAfterCareConverter.entityToModel(entity));
        }
        long count = daoFactory.getRhyAfterCareDao().getExitRHYAfterCaresCount(exitId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(rhyAfterCares.getRhyaftercares().size());
        pagination.setTotal((int)count);
        rhyAfterCares.setPagination(pagination);
        return rhyAfterCares;
	}

}
