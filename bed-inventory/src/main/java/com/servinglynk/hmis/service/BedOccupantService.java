package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.BedOccupant;
import com.servinglynk.hmis.model.BedOccupants;

public interface BedOccupantService {
	BedOccupant createBedOccupant(BedOccupant bedOccupant) throws Exception;
	void updateBedOccupant(BedOccupant bedOccupant) throws Exception;
	void deleteBedOccupant(UUID bedOccupantId);
	BedOccupant getBedOccupant(UUID bedOccupantId);
	BedOccupants getBedOccupants(UUID bedUnitId,Date fromdate, Date todate, Pageable pageable);
	BedOccupants getClientBedUnitOccupants(UUID dedupClientId, Date fromdate, Date todate, Pageable pageable);
}
