package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.HousingUnitOccupant;
import com.servinglynk.hmis.model.HousingUnitOccupants;

public interface HousingUnitOccupantService {
	HousingUnitOccupant createHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) throws Exception ;
	void updateHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) throws Exception ;
	void deleteHousingUnitOccupant(UUID housingUnitOccupantId);
	HousingUnitOccupant getHousingUnitOccupant(UUID housingUnitOccupantId);
	HousingUnitOccupants getHousingUnitOccupants(UUID housingunitid, Date fromdate, Date todate, Pageable pageable);
	HousingUnitOccupants getClientHousingUnitOccupants(UUID dedupClientId, Date fromdate, Date todate, Pageable pageable);
	HousingUnitOccupant checkinHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) throws Exception;
	void checkoutHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) throws Exception;
}
