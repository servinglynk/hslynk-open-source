package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.BedOccupants;
import com.servinglynk.hmis.service.converter.BedOccupantConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
@Service
public class BedOccupantServiceImpl extends BaseService implements BedOccupantService {

	@Transactional
	public BedOccupant createBedOccupant(BedOccupant bedUnit) {
		BedOccupantEntity entity = BedOccupantConverter.modelToEntity(bedUnit,null);
		daoFactory.getBedOccupantRepository().save(entity);
		bedUnit.setId(entity.getId());
		return bedUnit;
	}
	
	@Transactional
	public void updateBedOccupant(BedOccupant bedUnit) {
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findOne(bedUnit.getId());
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnit.getId()+" not found");
		entity = BedOccupantConverter.modelToEntity(bedUnit,entity);
		daoFactory.getBedOccupantRepository().save(entity);
	}
	
	@Transactional
	public void deleteBedOccupant(UUID bedUnitId) {
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findOne(bedUnitId);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnitId+" not found");
		daoFactory.getBedOccupantRepository().delete(entity);
	}
	
	@Transactional
	public BedOccupant getBedOccupant(UUID bedUnitId) {
		BedOccupantEntity entity =  daoFactory.getBedOccupantRepository().findOne(bedUnitId);
		if(entity == null) throw new ResourceNotFoundException("BedOccupant "+bedUnitId+" not found");		
		return BedOccupantConverter.entityToModel(entity);
	}
	
	@Transactional
	public BedOccupants getBedOccupants(Pageable pageable) {
		BedOccupants bedUnits = new BedOccupants();
		Page<BedOccupantEntity> entityPage = daoFactory.getBedOccupantRepository().findAll(pageable);
		for(BedOccupantEntity bedUnitEntity : entityPage.getContent()) {
			bedUnits.addBedOccupant(BedOccupantConverter.entityToModel(bedUnitEntity));
		}
		return bedUnits;
	}	
}