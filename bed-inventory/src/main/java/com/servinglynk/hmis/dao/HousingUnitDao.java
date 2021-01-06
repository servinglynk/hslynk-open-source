package com.servinglynk.hmis.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.entity.HousingUnitEntity;

public interface HousingUnitDao {

	Page<HousingUnitEntity> getAllHousingUnits(String q, Pageable pageable);

}
