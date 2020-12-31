package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.BedUnit;
import com.servinglynk.hmis.model.BedUnits;

public interface BedUnitService {
	BedUnit createBedUnit(BedUnit room);
	void updateBedUnit(BedUnit room);
	void deleteBedUnit(UUID roomId);
	BedUnit getBedUnit(UUID roomId);
	BedUnits getBedUnits(UUID shelterid, UUID areaid, UUID roomid, Pageable pageable);
}