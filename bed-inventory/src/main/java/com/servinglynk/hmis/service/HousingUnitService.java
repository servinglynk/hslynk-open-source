package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.HousingUnit;
import com.servinglynk.hmis.model.HousingUnits;

public interface HousingUnitService {
	HousingUnit createHousingUnit(HousingUnit housingUnit);
	void updateHousingUnit(HousingUnit housingUnit);
	void deleteHousingUnit(UUID housingUnitId);
	HousingUnit getHousingUnit(UUID housingUnitId);
	HousingUnits getHousingUnits(Pageable pageable);
}