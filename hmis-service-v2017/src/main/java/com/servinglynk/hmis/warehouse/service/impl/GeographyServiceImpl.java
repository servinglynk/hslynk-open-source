package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Geographies;
import com.servinglynk.hmis.warehouse.core.model.Geography;
import com.servinglynk.hmis.warehouse.service.GeographyService;
import com.servinglynk.hmis.warehouse.service.converter.GeographyConverter;
import com.servinglynk.hmis.warehouse.service.exception.CocNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.GeographyNotFoundException;

public class GeographyServiceImpl extends ServiceBase implements GeographyService {

	@Override
	@Transactional
	public Geography createGeography(Geography geography, UUID cocId, String caller) {
		   com.servinglynk.hmis.warehouse.model.v2017.Geography pGeography = GeographyConverter.modelToEntity(geography, null);
	       com.servinglynk.hmis.warehouse.model.v2017.Coc coc = daoFactory.getCocDao().getCocById(cocId);
	       if(pGeography == null) throw new GeographyNotFoundException();
	       pGeography.setCoc(coc);
	       pGeography.setDateCreated(LocalDateTime.now());
	       daoFactory.getProjectDao().populateUserProjectGroupCode(pGeography, caller);
	       daoFactory.getGeographyDao().createGeography(pGeography);
	       pGeography.setId(pGeography.getId());
	       return geography;
	}

	@Override
	public Geography updateGeography(Geography geography, UUID cocId, String caller) {
		com.servinglynk.hmis.warehouse.model.v2017.Coc coc = daoFactory.getCocDao().getCocById(cocId);
	       if(coc == null) throw new CocNotFoundException();
	       com.servinglynk.hmis.warehouse.model.v2017.Geography pGeography = daoFactory.getGeographyDao().getGeographyById(geography.getId());
	       if(pGeography==null) throw new GeographyNotFoundException();

	       GeographyConverter.modelToEntity(geography, pGeography);
	       pGeography.setCoc(coc);
	       pGeography.setDateUpdated(LocalDateTime.now());
	       pGeography.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
	       daoFactory.getGeographyDao().updateGeography(pGeography);
	       pGeography.setId(pGeography.getId());
	       return geography;
	}

	@Override
	public Geography deleteGeography(UUID geographyId, String caller) {
		com.servinglynk.hmis.warehouse.model.v2017.Geography pGeography = daoFactory.getGeographyDao().getGeographyById(geographyId);
	       if(pGeography==null) throw new GeographyNotFoundException();

	       daoFactory.getGeographyDao().deleteGeography(pGeography);
	       return new Geography();
	}

	@Override
	public Geography getGeographyById(UUID geographyId) {
	       com.servinglynk.hmis.warehouse.model.v2017.Geography pGeography = daoFactory.getGeographyDao().getGeographyById(geographyId);
	       if(pGeography==null) throw new GeographyNotFoundException();

	       return GeographyConverter.entityToModel( pGeography );
	}

	@Override
	public Geographies getAllCocGeographys(UUID cocId, Integer startIndex, Integer maxItems) {
		Geographies geographies = new Geographies();
        List<com.servinglynk.hmis.warehouse.model.v2017.Geography> entities = daoFactory.getGeographyDao().getAllCocGeographies(cocId, startIndex, maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Geography entity : entities){
        	geographies.addGeography(GeographyConverter.entityToModel(entity));
        }
        long count = daoFactory.getGeographyDao().getCocGeographiesCount(cocId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(geographies.getGeographies().size());
        pagination.setTotal((int)count);
        geographies.setPagination(pagination);
        return geographies;
	}

}
