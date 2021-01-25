package com.servinglynk.hmis.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.RoomEntity;

public interface BedUnitDao {

	Page<BedUnitEntity> getAllBedunits(RoomEntity roomEntity, String q, Pageable pageable);

}
