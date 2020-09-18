package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.HousingUnitOccupant;
import com.servinglynk.hmis.model.HousingUnitOccupants;

public interface HousingUnitOccupantService {
	HousingUnitOccupant createHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant);
	void updateHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant);
	void deleteHousingUnitOccupant(UUID housingUnitOccupantId);
	HousingUnitOccupant getHousingUnitOccupant(UUID housingUnitOccupantId);
	HousingUnitOccupants getHousingUnitOccupants(Pageable pageable);
}
