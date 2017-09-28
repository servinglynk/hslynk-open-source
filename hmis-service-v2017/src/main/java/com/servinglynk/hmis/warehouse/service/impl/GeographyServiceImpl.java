package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Geographies;
import com.servinglynk.hmis.warehouse.core.model.Geography;
import com.servinglynk.hmis.warehouse.service.GeographyService;
import com.servinglynk.hmis.warehouse.service.converter.FunderConverter;
import com.servinglynk.hmis.warehouse.service.converter.GeographyConverter;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;

public class GeographyServiceImpl extends ServiceBase implements GeographyService {

	@Override
	@Transactional
	public Geography createGeography(Geography geography, UUID cocId, String caller) {
		   com.servinglynk.hmis.warehouse.model.v2017.Geography pGeography = GeographyConverter.modelToEntity(geography, null);
	       com.servinglynk.hmis.warehouse.model.v2017.Coc coc = daoFactory.getCocDao().getCocById(cocId);
	       if(pGeography == null) throw new CocNotFoundException();
	       pFunder.setProjectid(pProject);
	       pFunder.setDateCreated(LocalDateTime.now());
	       daoFactory.getProjectDao().populateUserProjectGroupCode(pFunder, caller);
	       daoFactory.getFunderDao().createFunder(pFunder);
	       funder.setFunderId(pFunder.getId());
	}

	@Override
	public Geography updateGeography(Geography Geography, UUID cocId, String caller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Geography deleteGeography(UUID GeographyId, String caller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Geography getGeographyById(UUID GeographyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Geographies getAllCocGeographys(UUID projectId, Integer startIndex, Integer maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

}
