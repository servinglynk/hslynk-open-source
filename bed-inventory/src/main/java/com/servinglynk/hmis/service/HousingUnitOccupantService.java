package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.HousingUnitOccupant;
import com.servinglynk.hmis.model.HousingUnitOccupants;

public interface HousingUnitOccupantService {
	HousingUnitOccupant createHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) throws Exception ;
	void updateHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) throws Exception ;
	void deleteHousingUnitOccupant(UUID housingUnitOccupantId);
	HousingUnitOccupant getHousingUnitOccupant(UUID housingUnitOccupantId);
	HousingUnitOccupants getHousingUnitOccupants(UUID housingunitid, Pageable pageable);
}
