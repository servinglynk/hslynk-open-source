package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.RhyAfterCare;
import com.servinglynk.hmis.warehouse.core.model.RhyAfterCares;
import com.servinglynk.hmis.warehouse.service.RHYAfterCareService;
import com.servinglynk.hmis.warehouse.service.converter.RhyAfterCareConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitrhyNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RhyAfterCareNotFoundException;

public class RHYAfterCareServiceImpl  extends ServiceBase implements RHYAfterCareService {

	@Override
	public RhyAfterCare createRhyAfterCare(RhyAfterCare rhyAfterCare, UUID exitRhyId, String caller) {
		com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare pRhyAfterCare = RhyAfterCareConverter.modelToEntity(rhyAfterCare, null);
	       com.servinglynk.hmis.warehouse.model.v2017.Exitrhy pExitrhy = daoFactory.getExitrhyDao().getExitrhyById(exitRhyId);
	       if(pExitrhy == null) throw new ExitrhyNotFoundException();
	       pRhyAfterCare.setExitrhyid(pExitrhy);
	       pRhyAfterCare.setDateCreated(LocalDateTime.now());
	       daoFactory.getProjectDao().populateUserProjectGroupCode(pExitrhy, caller);
	       daoFactory.getExitrhyDao().createExitrhy(pExitrhy);
	       rhyAfterCare.setRhyAfterCareId(pRhyAfterCare.getId());
	       return rhyAfterCare;
	}

	@Override
	public RhyAfterCare updateRhyAfterCare(RhyAfterCare rhyAfterCare, UUID exitRhyId, String caller) {
		com.servinglynk.hmis.warehouse.model.v2017.Exitrhy pExitrhy = daoFactory.getExitrhyDao().getExitrhyById(exitRhyId);
	       if(pExitrhy == null) throw new ExitrhyNotFoundException();
	       com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare pRHYAfterCare = daoFactory.getRhyAfterCareDao().getRhyAfterCareById(rhyAfterCare.getRhyAfterCareId());
	       if(pRHYAfterCare==null) throw new RhyAfterCareNotFoundException();

	       RhyAfterCareConverter.modelToEntity(rhyAfterCare, pRHYAfterCare);
	       pRHYAfterCare.setExitrhyid(pExitrhy);
	       pRHYAfterCare.setDateUpdated(LocalDateTime.now());
	       pRHYAfterCare.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
	       daoFactory.getExitrhyDao().updateExitrhy(pExitrhy);
	       rhyAfterCare.setRhyAfterCareId(pRHYAfterCare.getId());
	       return rhyAfterCare;
	}

	@Override
	public RhyAfterCare deleteRhyAfterCare(UUID rhyAfterCareId, String caller) {
		  com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare pRHYAfterCare = daoFactory.getRhyAfterCareDao().getRhyAfterCareById(rhyAfterCareId);
	       if(pRHYAfterCare==null) throw new RhyAfterCareNotFoundException();

	       daoFactory.getRhyAfterCareDao().deleteRhyAfterCare(pRHYAfterCare);
	       return new RhyAfterCare();
	}

	@Override
	public RhyAfterCare getRhyAfterCareById(UUID rhyAfterCareId) {
		  com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare pRHYAfterCare = daoFactory.getRhyAfterCareDao().getRhyAfterCareById(rhyAfterCareId);
	       if(pRHYAfterCare==null) throw new RhyAfterCareNotFoundException();
	       return RhyAfterCareConverter.entityToModel(pRHYAfterCare);
	}

	@Override
	public RhyAfterCares getAllExitrhyRhyAfterCares(UUID exitrhyId, Integer startIndex, Integer maxItems) {
		RhyAfterCares rhyAfterCares = new RhyAfterCares();
        List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> entities = daoFactory.getRhyAfterCareDao().getAllExitrhyRHYAfterCares(exitrhyId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare entity : entities){
        	rhyAfterCares.addRhyaftercares(RhyAfterCareConverter.entityToModel(entity));
        }
        long count = daoFactory.getRhyAfterCareDao().getExitrhyRHYAfterCaresCount(exitrhyId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(rhyAfterCares.getRhyaftercares().size());
        pagination.setTotal((int)count);
        rhyAfterCares.setPagination(pagination);
        return rhyAfterCares;
	}

}
