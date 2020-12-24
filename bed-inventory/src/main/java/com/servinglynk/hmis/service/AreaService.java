package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.AreaModel;
import com.servinglynk.hmis.model.Areas;

public interface AreaService {
	AreaModel createArea(AreaModel room);
	void updateArea(AreaModel room);
	void deleteArea(UUID areaId);
	AreaModel getArea(UUID areaId);
	Areas getAreas(UUID shelterid, Pageable pageable);
}