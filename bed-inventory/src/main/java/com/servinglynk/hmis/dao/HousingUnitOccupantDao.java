package com.servinglynk.hmis.dao;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.entity.HousingUnitOccupantEntity;

public interface HousingUnitOccupantDao {

	Page<HousingUnitOccupantEntity> getClientHousingUnitOccupants(UUID dedupClientId, Date fromdate, Date todate,
			Pageable pageable);

}
