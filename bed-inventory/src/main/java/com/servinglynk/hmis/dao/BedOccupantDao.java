package com.servinglynk.hmis.dao;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.entity.BedOccupantEntity;

public interface BedOccupantDao {
	PageImpl<BedOccupantEntity> getBedOccupants(UUID bedUnitId, Date fromdate,Date todate,Pageable pageable);
	PageImpl<BedOccupantEntity> getClinetBedOccupants(UUID clintDedupId, Date fromdate,Date todate,Pageable pageable);
	BedOccupantEntity getClinetBedOccupants(UUID clientId, UUID bedUnitId);
	Boolean isBedUnitVacent(UUID bedunitid, Date startDate, Date endDate);
}
