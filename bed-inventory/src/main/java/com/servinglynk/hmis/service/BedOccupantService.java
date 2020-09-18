package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.BedOccupants;

public interface BedOccupantService {
	BedOccupant createBedOccupant(BedOccupant bedOccupant);
	void updateBedOccupant(BedOccupant bedOccupant);
	void deleteBedOccupant(UUID bedOccupantId);
	BedOccupant getBedOccupant(UUID bedOccupantId);
	BedOccupants getBedOccupants(Pageable pageable);
}
